package oktatest;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;


public class OktaApp {

    public static final String CLIENT_ID = "...";
    public static final String ISSUER = "https://dev-64347856.okta.com/oauth2/default";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(ISSUER + "/v1/device/authorize"))
            .POST(formBody(
                Map.of("client_id", CLIENT_ID, "scope", "openid profile offline_access")))
            .header("Accept", "application/json")
            .header("Content-Type", "application/x-www-form-urlencoded")
            .build();

        HttpResponse<Map> httpResponse = client.send(request, rs -> parseJson(Map.class));

        if (httpResponse.statusCode() != 200) {
            System.err.println("Error: " + httpResponse);
            throw new RuntimeException("Failed to initialize device grant authorization, likely caused by an invalid IdP configuration");
        }

        Map authorizationResponse = httpResponse.body();
        String deviceCode = (String) authorizationResponse.get("device_code");
        String verificationUri = (String) authorizationResponse.get("verification_uri");
        String userCode = (String) authorizationResponse.get("user_code");
        String verificationUriComplete = (String) authorizationResponse.get("verification_uri_complete");
        Duration interval = Duration.ofSeconds((int) authorizationResponse.get("interval"));
        Duration expiresIn = Duration.ofSeconds((int) authorizationResponse.get("expires_in"));

        if (!GraphicsEnvironment.isHeadless() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            System.out.println("Opening browser to: " + verificationUriComplete);
            Desktop.getDesktop().browse(URI.create(verificationUriComplete));
        } else {
            System.out.println("Open a browser and go to: " + verificationUri + "  enter the code: " + userCode);
        }

        long pollUntilMillis = System.currentTimeMillis() + expiresIn.toMillis();
        while (System.currentTimeMillis() < pollUntilMillis) {
            System.out.println("Sleeping for " + interval.getSeconds() + " seconds");
            Thread.sleep(interval.toMillis());

            HttpRequest tokenRequest = HttpRequest.newBuilder()
                .uri(URI.create(ISSUER + "/v1/token"))
                .POST(formBody(
                    Map.of("client_id", CLIENT_ID, "grant_type","urn:ietf:params:oauth:grant-type:device_code", "device_code", deviceCode)))
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

            HttpResponse<Map> tokenResponse = client.send(tokenRequest, rs -> parseJson(Map.class));

            if (tokenResponse.statusCode() == 200) {
                System.out.println("Authorization complete!");
                System.out.println(tokenResponse.body());
                break;
            } else {
                System.out.println("Error: " + tokenResponse.body());
                System.out.println(tokenResponse);
            }
        }
    }

    // convert a map into encoded form body
    private static HttpRequest.BodyPublisher formBody(Map<String, String> params) {
        return HttpRequest.BodyPublishers.ofString(
            params.entrySet().stream()
                .map(entry -> URLEncoder.encode(entry.getKey(), UTF_8) + "=" + URLEncoder.encode(entry.getValue(), UTF_8))
                .collect(joining("&")));
    }

    // parse a response body using Jackson
    public static <W> HttpResponse.BodySubscriber<W> parseJson(Class<W> targetType) {
        return HttpResponse.BodySubscribers.mapping(
            HttpResponse.BodySubscribers.ofByteArray(),
            (byte[] bytes) -> {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(bytes, targetType);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
    }

}
