package sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    private int[] getRow(int row) {
        return null;
    }

    private int[] getCol(int col) {
        return null;
    }

    private int[] getBox(int row, int col) {
        return null;
    }

    public Integer[] conjunction(int[] rows, int[] cols, int[] boxes) {
        Set<Integer> rowSet = getSet(rows);
        Set<Integer> temp = getSet(cols);
        rowSet.retainAll(temp);
        temp = getSet(boxes);
        rowSet.retainAll(temp);
        Integer[] output = rowSet.toArray(new Integer[0]);

        return output;
    }

    private Set<Integer> getSet(int[] args) {
        Set<Integer> output = new HashSet<>();
        for (int i = 0; i < args.length; i++) {
            output.add(args[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(null);
        System.out.println(Arrays.toString(sudoku.conjunction(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3}, new int[]{3})));
    }

}
