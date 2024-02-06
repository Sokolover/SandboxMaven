package com.src.task;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveValuesFromStringRepresentedKTimes {

    /**
     * Remove values from a string in case it’s represented here k times:
     * <p>
     * Input: “deeedbbcccbdaa”, k = 3
     * <p>
     * Output: “aa”
     */
    public static void main(String[] args) {
        String in = "deeedbbcccbdaa";
        int k = 3;

        System.out.println(removeCharIfAmountMoreThan3Times(in, k));
    }

    private static String removeCharIfAmountMoreThan3Times(String in, int k) {
        Map<Character, Integer> charAmountMap = new HashMap<>();
        for (int i = 0; i < in.length(); i++) {
            char character = in.charAt(i);
            if (charAmountMap.containsKey(character)) {
                charAmountMap.put(character, charAmountMap.get(character) + 1);
            } else {
                charAmountMap.put(character, 1);
            }
        }
        String formattedRegexp = "[" + getRegexpValue(charAmountMap, k) + "]";
        return in.replaceAll(formattedRegexp, "");
    }

    private static String getRegexpValue(Map<Character, Integer> charAmountMap, int k) {
        return charAmountMap.entrySet()
                .stream()
                .filter(it -> it.getValue() >= k)
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
