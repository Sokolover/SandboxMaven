package com.src.task;

import java.util.*;

public class DuplicatesInArray {

    public static void main(String[] args) {
        int[] in = new int[]{4,3,2,7,8,2,3,1};

        System.out.println(findDuplicates(in));
    }

    private static List<Integer> findDuplicates(int[] in) {
        Set<Integer> duplicatesCheck = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int i : in) {
            if (!duplicatesCheck.add(i)) {
                duplicates.add(i);
            }
        }

        return duplicates;
    }


}
