package ru.geekbrains.lesson_6.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Serv serv = new Serv();
        serv.serverStart();
        serv.waitClient();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    String txt = null;
                    try {
                        txt = serv.in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (txt != null){
                        try {
                            serv.sendMsg(txt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serv.writeConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class Serv{
        BufferedReader in = null;
        PrintWriter out = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader console = null;

        void serverStart() {
                try {
                    serverSocket = new ServerSocket(7777);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error open port 7777");
                }
            System.out.println("Server 7777 sterted...");
        }

        void waitClient() throws IOException{
            try {
                socket = serverSocket.accept();
                System.out.println("Client connected.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Client not found");
            }

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void sendMsg(String msg) throws IOException  {
            if (msg.equalsIgnoreCase("/exit")) close();
            out.println("Server: " + msg);
            System.out.println(msg);
        }

        void close() throws IOException{
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        }

        void writeConsole() throws IOException{
            while (true){
                console = new BufferedReader(new InputStreamReader(System.in));
                String txt = console.readLine();
                sendMsg(txt);
            }
        }

    }
}
