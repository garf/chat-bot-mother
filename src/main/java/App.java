import libs.helpers.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class App {
    public static void main( String[] args ) {
        AnsiConsole.systemInstall();

        Config config = new Config("./config.properties");

        String key = "listen";
        String telegramToken = config.get(key);

//        Boolean isTokenSet = telegramToken != null && !telegramToken.equals("SetYourToken");
//
//        if (!isTokenSet) {
//            System.out.println("Token: " + ansi().bg(RED).fg(BLACK).a("NOT SET").reset());
//            System.out.println("Please set your telegram token");
//            return;
//        }

//        System.out.println("Token: " + ansi().fg(GREEN).bold().a(telegramToken).reset());
//
//        TelegramBot bot = TelegramBotAdapter.build(telegramToken);

        final Logger logger = LoggerFactory.getLogger(App.class);

        System.out.println(ansi().bg(GREEN).fg(BLACK).a("Bot started").reset());
    }
}
