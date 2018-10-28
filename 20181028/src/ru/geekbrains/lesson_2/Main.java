package ru.geekbrains.lesson_2;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    private static String[][] array;
    public static Scanner scanner = new Scanner(System.in);
    public static int size;

    public static void main(String[] args) {
	// write your code here
        System.out.print("Введите размерность двумерного массива: ");
        size = scanner.nextInt();
        System.out.println();
        try {
            initArray();
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.println("Введенная размерность: " + e.getBadSize());
        }

        try {
            sumOfArray(array);
        }catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка в элементе: " + "[" + e.getRow() + "]" + "[" + e.getCol() + "]");
        }

    }

    public static void initArray() throws MyArraySizeException {
        if (size != 4) throw new MyArraySizeException("Размерность не 4", size);
            array = new String[size][size];
            int tmp = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    array[i][j] = Integer.toString(tmp);
                    tmp++;
//                    дичь
//                    array[3][3] = "three";
                        System.out.print(array[i][j] + "    ");
                }
                System.out.println();
            }
        System.out.println();
    }

    public static void sumOfArray(String[][] array) throws MyArrayDataException {

        int sum = 0;

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                try {
                    sum += parseInt(array[i][j]);
                }
                catch (NumberFormatException ex){
                    throw new MyArrayDataException("Хьюстон ви хэв э проблем!",i,j);
                }
            }
        }

        System.out.println("Сумма элементов массива = " + sum);
    }

    static class MyArraySizeException extends Exception{
        private int badSize;
        public int getBadSize() {return badSize;}

        public MyArraySizeException(String message, int badSize) {
            super(message);
            this.badSize = badSize;
        }
    }

    static class MyArrayDataException extends Exception{
        private int row;
        private int col;


        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public MyArrayDataException(String message, int row, int col) {
            super(message);
            this.row = row;
            this.col = col;
        }
    }
}
