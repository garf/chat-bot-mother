package mother.fetchers;

import mother.connectors.ApiHttpConnector;
import mother.connectors.HttpConnector;

/**
 * Created by Garfild on 10.02.2017.
 */
public class AbstractApiFetcher {
    HttpConnector connector;

    public AbstractApiFetcher() {
        this.connector = new ApiHttpConnector();
    }

    public HttpConnector getConnector() {
        return this.connector;
    }
}
