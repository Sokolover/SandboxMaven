package com.src;

public class SnakeMatrixOutput {

    /**
     * input:
     * <p>
     * [1,2,3]
     * <p>
     * [4,5,6]
     * <p>
     * [7,8,9]
     * <p>
     * result:
     * <p>
     * 1>4>7>8>5>2>3>6>9
     */
    public static void main(String[] args) {
        int[][] in = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(snakeFormatMatrix(in));
    }

    private static String snakeFormatMatrix(int[][] in) {
        StringBuilder result = new StringBuilder();
        for (int column = 0; column < in[0].length; column++) {
            goColumns(in, column, result);
        }
        removeLastSymbol(result);
        return result.toString();
    }

    private static void removeLastSymbol(StringBuilder result) {
        result.replace(result.length() - 1, result.length(), "");
    }

    private static void goColumns(int[][] in, int column, StringBuilder result) {
        if (column % 2 == 0) {
            goRowsUpToDown(in, result, column);
        } else {
            goRowsDownToUp(in, result, column);
        }
    }

    private static void goRowsDownToUp(int[][] in, StringBuilder result, int column) {
        int rowStartPosition = in.length - 1;
        int rowBoundValue = 0;
        for (int row = rowStartPosition; row >= rowBoundValue; row--) {
            result.append(in[row][column]).append(">");
        }
    }

    private static void goRowsUpToDown(int[][] in, StringBuilder result, int column) {
        int rowStartPosition = 0;
        int rowBoundValue = in.length;
        for (int row = rowStartPosition; row < rowBoundValue; row++) {
            result.append(in[row][column]).append(">");
        }
    }

}
