package com.src.task;

public class WordSearch {

    public static void main(String[] args) {
        myTest();
//        leetCodeTest1();
    }

    private static void leetCodeTest1() {
        char[][] board = {
                {'a', 'b'}
        };

        String word = "ba";

        System.out.println(word + ": " + exist(board, word));
    }


    private static void myTest() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        String word1 = "SEE";
        String word2 = "ABCB";

//        System.out.println(word + ": " + exist(board, word));
        System.out.println(word1 + ": " + exist(board, word1));
//        System.out.println(word2 + ": " + exist(board, word2));
    }

    public static boolean exist(char[][] board, String word) {
        char wordLetter = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char boardLetter = board[i][j];
                if (boardLetter == wordLetter && recursiveFindWord(board, i, j, word, 0, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean recursiveFindWord(char[][] board, int rowIndex, int columnIndex, String word, int currentWordLetterIndex, int prevLetterRowIndex, int prevLetterColumnIndex) {

        int leftIndex = columnIndex - 1;
        int rightIndex = columnIndex + 1;
        int upIndex = rowIndex - 1;
        int downIndex = rowIndex + 1;

        int nextWordLetterIndex = currentWordLetterIndex + 1;

        if (nextWordLetterIndex == word.length()) {
            return true;
        }

        char nextWordLetter = word.charAt(nextWordLetterIndex);

        if (isLeftLetter(board, rowIndex, prevLetterColumnIndex, leftIndex, nextWordLetter)) {

            return recursiveFindWord(board, rowIndex, leftIndex, word, nextWordLetterIndex, rowIndex, columnIndex);

        }
//        else
        if (isRightLetter(board, rowIndex, prevLetterColumnIndex, rightIndex, nextWordLetter)) {

            return recursiveFindWord(board, rowIndex, rightIndex, word, nextWordLetterIndex, rowIndex, columnIndex);

        }
//            else
        if (isUpLetter(board, columnIndex, prevLetterRowIndex, upIndex, nextWordLetter)) {

            return recursiveFindWord(board, upIndex, columnIndex, word, nextWordLetterIndex, rowIndex, columnIndex);

        }
//                else
        if (isDownLetter(board, columnIndex, prevLetterRowIndex, downIndex, nextWordLetter)) {

            return recursiveFindWord(board, downIndex, columnIndex, word, nextWordLetterIndex, rowIndex, columnIndex);

        }

        return false;
    }

    private static boolean isDownLetter(char[][] board, int columnIndex, int prevLetterRowIndex, int downIndex, char nextWordLetter) {
        return downIndex < board.length && prevLetterRowIndex != downIndex && board[downIndex][columnIndex] == nextWordLetter;
    }

    private static boolean isUpLetter(char[][] board, int columnIndex, int prevLetterRowIndex, int upIndex, char nextWordLetter) {
        return upIndex >= 0 && prevLetterRowIndex != upIndex && board[upIndex][columnIndex] == nextWordLetter;
    }

    private static boolean isRightLetter(char[][] board, int rowIndex, int prevLetterColumnIndex, int rightIndex, char nextWordLetter) {
        return rightIndex < board[0].length && prevLetterColumnIndex != rightIndex && board[rowIndex][rightIndex] == nextWordLetter;
    }

    private static boolean isLeftLetter(char[][] board, int rowIndex, int prevLetterColumnIndex, int leftIndex, char nextWordLetter) {
        return leftIndex >= 0 && prevLetterColumnIndex != leftIndex && board[rowIndex][leftIndex] == nextWordLetter;
    }
}
