package ru.geekbrains.lesson_5;

public class Main {

    public static void main(String[] args) {
	// write your code here

        monoThread();
        doubleThread();

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
        System.out.println("Одним потоком затрачено: " + (finalTime - startTime) + " миллисекунд");

    }

    public static void doubleThread(){

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr,h,a2,0,h);

        try {
        MyThread thread1 = new MyThread(a1);
        MyThread thread2 = new MyThread(a2);
        thread1.thread.join();
        thread2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1,0,arr,0,h);
        System.arraycopy(a2,0,arr,h,h);

        long finalTime = System.currentTimeMillis();
        System.out.println("Двумя потоками затрачено: " + (finalTime - startTime) + " миллисекунд");

    }

    static class MyThread extends Thread{
        Thread thread;
        float arr[];

        MyThread(float[] arr) {
            thread = new Thread();
            this.arr = arr;
            thread.start();
        }

        public void run(){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}
