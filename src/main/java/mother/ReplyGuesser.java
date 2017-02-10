package mother;

import dto.socket.ClientMessage;
import dto.socket.MotherMessage;
import mother.fetchers.AbstractApiFetcher;
import mother.fetchers.StatisticsFetcher;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ReplyGuesser {
    public MotherMessage process(ClientMessage message) throws IOException, ParseException {
        String messageText = message.getText().toLowerCase();
        AbstractApiFetcher fetcher = null;

        if ((messageText.contains("overall") || messageText.contains("average")) && messageText.contains("score")) {
            return new StatisticsFetcher().overall(message);
        }

        return new MotherMessage().setText("I'm not so smart yet. Could you tell this in other way?");
    }
}
