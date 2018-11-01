package ru.geekbrains.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task_1 {

    public Task_1() {
    }

    public ArrayList <String> transformArray(String[] arr){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : arr){
            arrayList.add(s);
        }
        return arrayList;
    }

    public Set<String> deleteReplays (ArrayList<String> arrayList){
        Set<String> s = new LinkedHashSet<>(arrayList);
        return s;
    }

    public HashMap<String, Integer> sumReplays (ArrayList<String> arrayList){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Integer sum;

        for (String i : arrayList){
            sum = hashMap.get(i);
            hashMap.put(i,sum == null ? 1 : sum + 1);
        }
        return hashMap;
    }
}
