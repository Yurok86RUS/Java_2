package ru.geekbrains.lesson_3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
      String[] array = {"null", "one", "two", "tree", "four", "one", "five",
                        "tree", "six", "seven", "one", "six", "eight", "nine"};
      System.out.println("Задание 1: ");

      ArrayList <String> newArray = new Task_1().transformArray(array);
        System.out.println("Исходный массив: " + newArray);

      Set a = new Task_1().deleteReplays(newArray);
        System.out.println("Убрали все повторы:" + a);

      HashMap<String, Integer> hm = new Task_1().sumReplays(newArray);
        System.out.println();
        for (HashMap.Entry<String, Integer> soutHm : hm.entrySet()){
            System.out.println("Элемент " + soutHm.getKey() + " повторяется " + soutHm.getValue() + " раз(а)");
        }

      System.out.println();
      System.out.println("Задание 2: ");

        Task_2 book = new Task_2();
        book.add("Иванов", "000");
        book.add("Петров", "111");
        book.add("Сидоров", "222");
        book.add("Петров", "333");
        book.add("Сидоров", "444");
        book.add("Иванов", "555");
        book.add("Сидоров", "666");
        book.add("Петров", "777");
        book.add("Петров", "888");
        book.add("Петров", "999");

        System.out.println("Телефоны Иванова: " + book.get("Иванов"));
        System.out.println("Телефоны Петрова: " + book.get("Петров"));
        System.out.println("Телефоны Сидорова: " + book.get("Сидоров"));

    }
}
