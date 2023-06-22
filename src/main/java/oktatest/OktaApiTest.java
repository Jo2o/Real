package oktatest;

import com.okta.authn.sdk.AuthenticationException;
import com.okta.authn.sdk.client.AuthenticationClient;
import com.okta.authn.sdk.client.AuthenticationClients;
import com.okta.authn.sdk.resource.AuthenticationResponse;
import com.okta.idx.sdk.api.client.IDXAuthenticationWrapper;
import com.okta.idx.sdk.api.client.ProceedContext;
import com.okta.jwt.JwtVerifiers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OktaApiTest {

    public static void main(String[] args) throws AuthenticationException {

        IDXAuthenticationWrapper idxAuthenticationWrapper = new IDXAuthenticationWrapper();
//                AuthenticationResponse beginResponse = idxAuthenticationWrapper.begin();
//        ProceedContext proceedContext = beginResponse.getProceedContext();

        AuthenticationClient authenticationClient = AuthenticationClients.builder()
            .setOrgUrl("https://dev-64347856.okta.com/")
            .build();

        AuthenticationResponse response = authenticationClient
            .authenticate("<email>", "<password>".toCharArray(), null, new ExampleAuthenticationStateHandler());

        log.info("{}", response);
    }

}
