package com.src.task;

public class PalindromeFull {

    public static void main(String[] args) {
        boolean q1 = findPalindrome("");
        boolean q2 = findPalindrome("a");
        boolean q3 = findPalindrome("aa");
        boolean q4 = findPalindrome("aba");
        boolean q5 = findPalindrome("bba");
        boolean q6 = findPalindrome("bbba");
        boolean q7 = findPalindrome("aA");
        boolean q8 = findPalindrome(null);
        System.out.println("empty string: " + q1);
        System.out.println("a: " + q2);
        System.out.println("aa: " + q3);
        System.out.println("aba: " + q4);
        System.out.println("bba: " + q5);
        System.out.println("bbba: " + q6);
        System.out.println("aA: " + q7);
        System.out.println("null: " + q8);

        System.out.println("3223: " + isPalindromNumber(3223));
    }

    private static boolean findPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        input = input.toUpperCase();

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromNumber(int number) {
        int copy = number;
        int reverste = 0;

        while (copy != 0) {
            reverste = reverste * 10 + copy % 10;
            copy = copy / 10;
        }
        return reverste == number;
    }
}
