package mother.fetchers;

import dto.socket.ClientMessage;
import dto.socket.MotherMessage;
import libs.parsers.JsonParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class StatisticsFetcher extends AbstractApiFetcher {

    public MotherMessage overall(ClientMessage message) throws ParseException, IOException {
        MotherMessage reply = new MotherMessage();

        String response = this.getConnector().getContent("/overall-average");
        JsonParser parser = new JsonParser(response);
        reply.setText(String.format("Your average score is: <b>%s</b> %%", parser.getByKey("score")));

        return reply;
    }
}
