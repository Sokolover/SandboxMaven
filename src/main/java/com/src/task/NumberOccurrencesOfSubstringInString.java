package com.src.task;

public class NumberOccurrencesOfSubstringInString {

    public static void main(String[] args) {
        String string = "aaabbbaaacaaaasdwqe";
        String search = "aaa";

        System.out.println(searchOccurrencesNumberOfSubstring(string, search));
    }

    private static int searchOccurrencesNumberOfSubstring(String string, String search) {
        int occurrencesNumber = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == search.charAt(0)) {
                int charCounter = 0;
                for (int j = 0; j < search.length(); j++) {
                    if (string.charAt(i + j) == search.charAt(j)) {
                        charCounter++;
                    } else {
                        break;
                    }
                }
                if (charCounter == search.length()) {
                    occurrencesNumber++;
                }
            }

        }

        return occurrencesNumber;
    }
}
