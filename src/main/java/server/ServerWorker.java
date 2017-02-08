package server;

import libs.http.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable {
    private Socket client = null;

    public ServerWorker(Socket client) {
        this.client = client;
        System.out.println("New connection from: " + client.getInetAddress().getHostName());
    }

    @Override
    public void run() {
        String content;
        BufferedReader in;
        PrintWriter out;

        while (true) {
            try {
                in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
                out = new PrintWriter(this.client.getOutputStream(), true);

                content = in.readLine();
                String reply = String.format("Im mother. You sent: '%s'", content);
                out.println(reply);
                System.out.println(String.format("Received from client: '%s'", content));
                System.out.println(String.format("Replied: '%s'", reply));
            } catch (IOException e) {
                System.out.println(String.format("Read failed: %s", e.getMessage()));
                System.exit(-1);
            }
        }
    }
}
