package com.src.task;

import java.util.HashMap;
import java.util.Map;

public class ArrayElementsFrequency {

    /**
     * Counting frequencies of array elements
     * <p>
     * Example:
     * <p>
     * The following array is given
     * <p>
     * {'mom','jack','loft','mom'};
     * <p>
     * should be output in this form
     * <p>
     * {(mom,2),(jack,0),(loft,0)}
     */
    public static void main(String[] args) {
        String[] in = new String[]{"mom", "jack", "loft", "mom"};
        Map<String, Integer> result = countFrequencies(in);
        System.out.println(result);
    }

    private static Map<String, Integer> countFrequencies(String[] in) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String elementKey : in) {
            if (countMap.containsKey(elementKey)) {
                countMap.put(elementKey, countMap.get(elementKey) + 1);
            } else {
                countMap.put(elementKey, 1);
            }
        }
        return countMap;
    }
}
