package ru.geekbrains.lesson_3;

import java.util.ArrayList;

public class Task_1 {

    public Task_1() {
    }

    public void transformArray(String[] arr){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : arr){
            arrayList.add(s);
        }
        System.out.println(arrayList);
    }
}
