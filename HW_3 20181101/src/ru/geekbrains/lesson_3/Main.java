package ru.geekbrains.lesson_3;

import java.util.ArrayList;
import java.util.Set;

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

        
    }
}
