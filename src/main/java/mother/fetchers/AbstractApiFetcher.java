package mother.fetchers;

import mother.connectors.ApiHttpConnector;
import mother.connectors.HttpConnector;

public class AbstractApiFetcher {
    HttpConnector connector;

    public AbstractApiFetcher() {
        this.connector = new ApiHttpConnector();
    }

    public HttpConnector getConnector() {
        return this.connector;
    }
}
