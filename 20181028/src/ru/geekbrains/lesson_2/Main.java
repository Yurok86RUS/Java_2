package ru.geekbrains.lesson_2;

import java.util.Scanner;

public class Main {

    private static int[][] array;
    public static Scanner scanner = new Scanner(System.in);
    public static int size;

    public static void main(String[] args) {
	// write your code here
        System.out.print("Введите размерность двумерного массива: ");
        size = scanner.nextInt();
        System.out.println();
        initArray();

    }

    public static void initArray(){
        array = new int[size][size];
        int tmp = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                array[i][j] = tmp;
                tmp++;
                if (array[i][j] < 10) {
                    System.out.print(array[i][j] + "    ");
                }
                else System.out.print(array[i][j] + "   ");
            }
            System.out.println();
        }
    }



}
