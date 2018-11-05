package ru.geekbrains.lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
        insertText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    mainWindow.append(insertText.getText() + "\n");
                    insertText.setText(null);
                    insertText.grabFocus();
                }
                super.keyReleased(e);
            }
        });
        sendMessage.add(insertText);
        sendMessage.add(send);

        JButton buttonSmile = new JButton(":)");
        buttonSmile.setBackground(Color.yellow);
        buttonSmile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            insertText.setText(insertText.getText() + " :)");
            insertText.grabFocus();
            }
        });
        JButton buttonCry = new JButton(";(");
        buttonCry.setBackground(Color.yellow);
        buttonCry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertText.setText(insertText.getText() + " ;(");
                insertText.grabFocus();
            }
        });
        JButton buttonSadness = new JButton(":(");
        buttonSadness.setBackground(Color.yellow);
        buttonSadness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertText.setText(insertText.getText() + " :(");
                insertText.grabFocus();
            }
        });
        smilePanel.add(buttonSmile);
        smilePanel.add(Box.createVerticalStrut(10));
        smilePanel.add(buttonCry);
        smilePanel.add(Box.createVerticalStrut(10));
        smilePanel.add(buttonSadness);

        //наполнение stylePanel
        stylePanel.setLayout(new GridLayout());
        JButton bold1 = new JButton("Жирный");
        bold1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton italics = new JButton("Курсив");
        italics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JFormattedTextField textField = new JFormattedTextField();
//                String s = insertText.getText();
//                textField.setFont(new Font("Aral",Font.BOLD,15));
//                textField.setText(s);

            }
        });
        stylePanel.add(bold1);
        stylePanel.add(italics);

        //верхняя строка
        JLabel info = new JLabel("Домашнее задание по четвертому уроку");
        informPanel.add(info);

        setVisible(true);
    }
}
