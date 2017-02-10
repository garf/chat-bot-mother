package mother.connectors;

import java.io.IOException;
import libs.helpers.Config;

public class ApiHttpConnector extends HttpConnector {
    @Override
    public String getContent(String endpoint) throws IOException {
        return super.getContent(this.getApiUrl() + endpoint);
    }

    @Override
    public String postContent(String endpoint, String data) throws IOException {
        return super.postContent(this.getApiUrl() + endpoint, data);
    }

    private String getApiUrl() {
        Config config = new Config("./config.properties");

        return config.get("api.url");
    }
}
