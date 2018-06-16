package sample;

public class Sudoku {
    public static final int[][] box = {
            {1, 1, 1, 2, 2, 2, 3, 3, 3},
            {1, 1, 1, 2, 2, 2, 3, 3, 3},
            {1, 1, 1, 2, 2, 2, 3, 3, 3},
            {4, 4, 4, 5, 5, 5, 6, 6, 6},
            {4, 4, 4, 5, 5, 5, 6, 6, 6},
            {4, 4, 4, 5, 5, 5, 6, 6, 6},
            {7, 7, 7, 8, 8, 8, 9, 9, 9},
    };

    public int[][] map;

    public Sudoku(int[][] map) {
        this.map = map;
    }

    public int[][] getSolution() {
        return null;
    }

    public int[] getRow(int row) {
        return null;
    }

    public int[] getCol(int col) {
        return null;
    }

    public int[] getBox(int row, int col) {
        return null;
    }

    public int[] conjunction(int[] rows, int[] cols, int[] boxes) {
        return null;
    }
}
