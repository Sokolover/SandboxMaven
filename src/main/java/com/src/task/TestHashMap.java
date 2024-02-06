package com.src;

import java.util.HashMap;
import java.util.HashSet;

public class TestHashMap {

//    public static void main(String[] args) {
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("1", "1");
//        objectObjectHashMap.put("2", "2");
//        System.out.println(objectObjectHashMap.get("3"));
//    }

    public static void main(String args[])
    {
        // Creating an empty HashSet
        HashSet<String> set = new HashSet<String>();

        // Use add() method to add elements into the Set
        set.add("Welcome");
        set.add("To");
        set.add("Geeks");
        set.add("4");
        set.add("Geeks");

        // Displaying the HashSet
        System.out.println("HashSet: " + set);
    }
}
