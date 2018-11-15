package ru.geekbrains.lesson_6.client;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Client implements Initializable {

        Socket socket;
        //DataInputStream dataInputStream;
        //DataOutputStream dataOutputStream;

        private Scanner in;
        private PrintWriter out;

        final String IP_ADDRESS = "localhost";
        final int PORT = 7777;

        @Override
        public void initialize (URL location, ResourceBundle resources){

            try {
                socket = new Socket(IP_ADDRESS, PORT);
                //dataInputStream = new DataInputStream(socket.getInputStream());
                //dataOutputStream = new DataOutputStream(socket.getOutputStream());
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                //String string = dataInputStream.readUTF();
                                //if (string.equals("/serverclosed")) break;
                                //System.out.println(string);
                                String string = in.nextLine();
                                if (in.equals("/serverclosed")) break;
                                System.out.println(string);
                            } finally {
                                try {
                                    socket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
