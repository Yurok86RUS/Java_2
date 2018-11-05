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

        informPanel.setBackground(Color.cyan);
        chatPanel.setBackground(Color.yellow);
        stylePanel.setBackground(Color.green);

        //добавляем основные панели
        add(informPanel,BorderLayout.NORTH);
        add(chatPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);
        add(smilePanel, BorderLayout.EAST);

        chatPanel.setLayout(new BorderLayout());

        //добавляем панели на sendPanel
        sendPanel.setLayout(new BorderLayout());
        sendPanel.add(sendMessage, BorderLayout.NORTH);
        sendPanel.add(stylePanel,BorderLayout.SOUTH);


        JButton buttonSmile = new JButton(":)");
        buttonSmile.setBackground(Color.yellow);
        buttonSmile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton buttonCry = new JButton(";(");
        buttonCry.setBackground(Color.yellow);
        buttonCry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton buttonSadness = new JButton(":(");
        buttonSadness.setBackground(Color.yellow);
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

        //наполнение stylePanel
        stylePanel.setLayout(new GridLayout());
        JButton bold = new JButton("Жирный");
        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton italics = new JButton("Курсив");
        italics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        stylePanel.add(bold);
        stylePanel.add(italics);

        //основное окно
        JTextArea mainWindow = new JTextArea();
        mainWindow.setEditable(false);
        JScrollPane scroll = new JScrollPane(mainWindow);
        chatPanel.add(scroll);

        //наполнение sendMessage
        JTextField insertText = new JTextField();
        insertText.setPreferredSize(new Dimension(300,30));
        JButton send = new JButton("Отправить");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            mainWindow.append(insertText.getText() + "\n");
            insertText.setText(null);
            insertText.grabFocus();
            }
        });
        sendMessage.add(insertText);
        sendMessage.add(send);


        //верхняя строка
        JLabel info = new JLabel("Домашнее задание по четвертому уроку");
        informPanel.add(info);

        setVisible(true);
    }
}