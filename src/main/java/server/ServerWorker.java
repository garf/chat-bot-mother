package server;

import dto.socket.ClientMessage;
import dto.socket.MotherMessage;
import mother.ReplyGuesser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;

public class ServerWorker implements Runnable {
    private Socket client = null;

    public ServerWorker(Socket client) {
        this.client = client;
        System.out.println("New connection from: " + client.getInetAddress().getHostName());
    }

    @Override
    public void run() {
        ClientMessage clientMessage;
        ObjectInputStream in;
        ObjectOutputStream out;
        MotherMessage motherMessage;

        while (true) {
            try {
                out = new ObjectOutputStream(this.client.getOutputStream());
                in = new ObjectInputStream(this.client.getInputStream());
                clientMessage = (ClientMessage) in.readObject();
                out.writeObject(new ReplyGuesser().process(clientMessage));
            } catch (IOException e) {
                System.out.println(String.format("Read failed: %s", e.getMessage()));
                System.exit(-1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
