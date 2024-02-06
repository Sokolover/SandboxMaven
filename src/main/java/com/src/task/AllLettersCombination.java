package com.src;

/**
 * Given string “123”, print all combinations of letters of this string
 * <p>
 * (“132”,
 * <p>
 * “213”,
 * <p>
 * “231”,
 * <p>
 * “312”,
 * <p>
 * “321”)
 */
public class AllLettersCombination {

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.isEmpty()) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch);
        }
    }

    // Driver code
    public static void main(String[] args) {
        String s = "1234";
        printPermutn(s, "");
    }

}
