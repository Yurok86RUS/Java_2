package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Server server;
    private String nick;

    private HashMap<ClientHandler, String> listClients = new HashMap<>();


    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //цикл авторизации
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickname(tokens[1], tokens[2]);
                                if (newNick != null) {
                                    sendMsg("/authok");
                                    nick = newNick;
                                    server.subscribe(ClientHandler.this);
                                    listClients.put(ClientHandler.this,nick);
                                    break;
                                } else {
                                    sendMsg("Неверный логин/пароль");
                                }
                            }
                        }
                        //рабочий цикл
                        while (true) {
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                out.writeUTF("/serverclosed");
                                break;
                            }
                            if (str.startsWith("/w")) {
                                String sender = getClient(ClientHandler.this);
                                String[] parsingNick = str.split(" ", 3);
                                String toNick = parsingNick[1];
                                String newStr = parsingNick[2];
                                //String[] delSymbol = str.split(" ", 3);
                                //String newStr = delSymbol[2];
                                server.sendToNick(newStr,toNick, sender);
                            } else {
                                server.broadcastMsg(str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getClient (ClientHandler qwe){
//        System.out.println("тут мы пошли в хэшмапу и там: ");
//        for (Map.Entry<ClientHandler, String> hm : listClients.entrySet()){
//            System.out.println("key " + hm.getKey() + " ; value " + hm.getValue());
//        }
        return listClients.get(qwe);
    }

}
