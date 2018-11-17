package ru.geekbrains.lesson_6.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        ClientConnected clientConnected = new ClientConnected();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientConnected.readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientConnected.sengMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class ClientConnected{
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader console = null;
        String serverMsg, clientMsg;

        final String IP_ADDRESS = "localhost";
        final int PORT = 7777;

        public ClientConnected() throws IOException {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("You connected to server 7777.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            console = new BufferedReader(new InputStreamReader(System.in));
        }

        void sengMsg() throws IOException{
            System.out.print("Write you message: ");
            while (true){
                if ((clientMsg = console.readLine()) != null){
                    out.println(clientMsg);
                    if (clientMsg.equalsIgnoreCase("/exit")) break;
                }
            }
        }

        void readMessage() throws IOException{
            while (true){
                if ((serverMsg = in.readLine()) != null){
                    System.out.println(serverMsg);
                }
            }
        }

    }
    }
