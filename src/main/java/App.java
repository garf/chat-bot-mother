import libs.helpers.Config;
import libs.http.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.fusesource.jansi.AnsiConsole;
import server.ServerWorker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class App {
    public static void main( String[] args ) throws InterruptedException {
        AnsiConsole.systemInstall();

        Config config = new Config("./config.properties");

        String key = "listen";
        int port = Integer.parseInt(config.get(key));

        System.out.println(ansi().bold().fg(GREEN).a("Server started on port " + port).reset());

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Could not listen on port" + port);
            System.exit(-1);
        }

        while (true) {
            try {
                Socket accept = server.accept();

                ServerWorker worker = new ServerWorker(accept);
                Thread t = new Thread(worker);
                t.run();
            } catch (IOException e) {
                System.out.println("Accept failed: " + port);
                System.exit(-1);
            }
        }
    }
}
