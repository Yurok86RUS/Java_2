package ru.geekbrains.lesson_4;

import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame{

    public Chat() {
    }

    public void initChat(){

        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 500);

        //основные панели
        JPanel informPanel = new JPanel();
        JPanel chatPanel = new JPanel();
        JPanel sendPanel = new JPanel();
        JPanel smylePanel = new JPanel();
        //наполнение панели отправки
        JPanel stylePanel = new JPanel();
        JPanel sendMessage = new JPanel();

        informPanel.setBackground(Color.gray);
        chatPanel.setBackground(Color.yellow);
        sendPanel.setBackground(Color.cyan);
        stylePanel.setBackground(Color.green);
        sendMessage.setBackground(Color.blue);
        smylePanel.setBackground(Color.magenta);

        //добавляем основные панели
        add(informPanel,BorderLayout.NORTH);
        add(chatPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);
        add(smylePanel, BorderLayout.EAST);
        //добавляем панели на sendPanel
        sendPanel.setLayout(new BorderLayout());
        sendPanel.add(stylePanel,BorderLayout.SOUTH);
        sendPanel.add(sendMessage, BorderLayout.NORTH);

        //chatPanel.setLayout(new BorderLayout());
        //sendPanel.setLayout(new BorderLayout());

        

    setVisible(true);
    }
}
