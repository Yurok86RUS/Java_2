package ru.geekbrains.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task_2 {

    private HashMap<String, List<String>> phoneBook = new HashMap<>();
    private List<String> phoneNumberList;

    public void add(String surname, String number){
        if (phoneBook.containsKey(surname)){
            phoneNumberList = phoneBook.get(surname);
            phoneNumberList.add(number);
            phoneBook.put(surname,phoneNumberList);
        }
        else {
            phoneNumberList = new ArrayList<>();
            phoneNumberList.add(number);
            phoneBook.put(surname,phoneNumberList);
        }
    }

    public List<String> get(String surname){
        return phoneBook.get(surname);
    }


}
