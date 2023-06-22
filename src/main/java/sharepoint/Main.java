package sharepoint;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("file:///C:/Wo...ory");
        System.out.println(uri);
    }
}
