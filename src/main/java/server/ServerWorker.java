package server;

import dto.socket.ClientMessage;
import dto.socket.MotherMessage;
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

                String[] keyboard = {"Get me a Puppy", "Set me a puppy"};

                motherMessage = new MotherMessage()
                        .setText(String.format("Im mother. You sent: '%s'", clientMessage.getText()))
                        .setKeyboard(keyboard);

                out.writeObject(motherMessage);

                System.out.println(String.format("Received from client: '%s'", clientMessage.getText()));
                System.out.println(String.format("Replied: '%s'", motherMessage.getText()));

            } catch (IOException e) {
                System.out.println(String.format("Read failed: %s", e.getMessage()));
                System.exit(-1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
