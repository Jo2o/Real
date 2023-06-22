package msgraphapi;

import static java.lang.String.format;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientCertificateCredentialBuilder;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.google.gson.JsonElement;
import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.httpcore.HttpClients;
import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.BaseItemCollectionPage;
import com.microsoft.graph.requests.GraphServiceClient;
import com.microsoft.graph.requests.SiteGetAllSitesCollectionPage;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Slf4j
public class MsGraphTutorial {

    private static final String APP_ID = "...";
    private static final String TENANT_ID = "...";
    private static final String CERT_PATH = "C:/.../crrt.pem";
    private static final String CERT_THUMBPRINT = "...";
    private static final List<String> SCOPES = List.of("https://graph.microsoft.com/.default");

    public static void main(String[] args) {

        TokenCredential tokenCredential = new ClientCertificateCredentialBuilder()
            .clientId(APP_ID)
            .tenantId(TENANT_ID)
            .pemCertificate(CERT_PATH)
            .build();

        GraphServiceClient<Request> graphServiceClient = GraphServiceClient.builder()
            .authenticationProvider(new TokenCredentialAuthProvider(SCOPES, tokenCredential))
            .buildClient();

        JsonElement documentItems = graphServiceClient
            .customRequest("/sites/<>.sharepoint.com:/teams/<>>:/lists/Documents/items")
            .buildRequest()
            .get();

        log.info("Sites: {}", documentItems);
    }

}
