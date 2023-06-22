package msgraphapi;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientCertificateCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    private static final String APP_NAME = "...";
    private static final String APP_ID = "...";
    private static final String TENANT_ID = "...";
    private static final String THUMBPRINT = "...";

    public static void main(String[] args) {



        TokenCredential clientCertificateCredential = new ClientCertificateCredentialBuilder()
            .clientId(APP_ID)
            .tenantId(TENANT_ID)
            .pemCertificate("C:\\Wo...pem")
            .build();

        TokenCredentialAuthProvider tokenCredAuthProvider = new TokenCredentialAuthProvider(List.of("read"), clientCertificateCredential);

//        GraphServiceClient graphClient = GraphServiceClient.builder()
//            .authenticationProvider(tokenCredAuthProvider)
//            .
//            .buildClient()
//            .sites().;

//        log.info("Me: {}", graphClient.me().buildRequest().get());
    }

}
