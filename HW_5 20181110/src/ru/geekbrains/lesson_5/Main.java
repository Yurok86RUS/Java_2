package ru.geekbrains.lesson_5;

public class Main {

    public static void main(String[] args) {
	// write your code here

        monoThread();

    }

    public static void monoThread(){

        final int size = 10000000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finalTime = System.currentTimeMillis();
        System.out.println("Одним потоком затрачено: " + (finalTime - startTime) + "миллисекунд");

    }

    public void doubleThread(){

    }
}
