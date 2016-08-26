package tictactoe.board;

import java.util.ArrayList;
import java.util.Arrays;

public class SquareBoard implements Board {
    private int numRows;
    private int[][] rows;

    public SquareBoard(int numRows) {
        this.numRows = numRows;
        setRows();
    }

    public int getNumRows() {
        return numRows;
    }

    public ArrayList<Integer> getSpaces() {
        ArrayList<Integer> spaces = new ArrayList<Integer>();
        for (int i = 0; i < (numRows * numRows); i++) {
            spaces.add(i);
        }
        return spaces;
    }

    public int[][] getHorizontalRows() {
        int[][] horizontalRows = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                horizontalRows[i][j] = (i * numRows) + j;
            }
        }
        return horizontalRows;
    }

    public int[][] getVerticalRows() {
        int[][] verticalRows = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                verticalRows[i][j] = i + (j * numRows);
            }
        }
        return verticalRows;
    }

    public int[][] getDiagonalRows() {
        int[][] diagonalRows = new int[2][numRows];
            for (int j = 0; j < numRows; j++) {
            diagonalRows[0][j] = (numRows + 1) * j;
            diagonalRows[1][j] = (numRows - 1) * (j + 1);
        }
        return diagonalRows;
    }

    public void setRows() {
        rows = new int[(numRows + 1) * 2][numRows];
        System.arraycopy(getHorizontalRows(), 0, rows, 0, numRows);
        System.arraycopy(getVerticalRows(), 0, rows, numRows, numRows);
        System.arraycopy(getDiagonalRows(), 0, rows, 2 * numRows, 2);
    }

    public int[][] getRows() {
        return rows;
    }

    public boolean isSpaceInRow(int space, int[] row) {
        return Arrays.stream(row)
                .anyMatch((rowSpace) -> rowSpace == space);
    }

}