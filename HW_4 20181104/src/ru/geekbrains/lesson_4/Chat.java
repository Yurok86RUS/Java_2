package ru.geekbrains.lesson_4;

import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame{

    public Chat() {
    }

    public void initChat(){

        Container container = getContentPane();

        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 500);

        //основные панели
        JPanel informPanel = new JPanel();
        JPanel chatPanel = new JPanel();
        JPanel sendPanel = new JPanel();
        Box smilePanel = Box.createVerticalBox();
        //наполнение панели отправки
        JPanel stylePanel = new JPanel();
        Box sendMessage = Box.createHorizontalBox();

        informPanel.setBackground(Color.gray);
        chatPanel.setBackground(Color.yellow);
        stylePanel.setBackground(Color.green);

        //добавляем основные панели
        add(informPanel,BorderLayout.NORTH);
        add(chatPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);
        add(smilePanel, BorderLayout.EAST);
        //добавляем панели на sendPanel
        sendPanel.setLayout(new BorderLayout());
        sendPanel.add(sendMessage, BorderLayout.NORTH);
        sendPanel.add(stylePanel,BorderLayout.SOUTH);


        JButton buttonSmile = new JButton(":)");
        buttonSmile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton buttonCry = new JButton(";(");
        buttonCry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton buttonSadness = new JButton(":(");
        buttonSadness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        smilePanel.add(buttonSmile);
        smilePanel.add(Box.createVerticalStrut(10));
        smilePanel.add(buttonCry);
        smilePanel.add(Box.createVerticalStrut(10));
        smilePanel.add(buttonSadness);

        //sendMessage.setLayout(new BorderLayout());
        JTextField insertText = new JTextField();
        insertText.setPreferredSize(new Dimension(300,30));
        JButton send = new JButton("Отправить");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sendMessage.add(insertText);
        sendMessage.add(send);



        setVisible(true);
    }
}
