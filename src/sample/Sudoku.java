package sample;

import java.util.ArrayList;
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
            {7, 7, 7, 8, 8, 8, 9, 9, 9},
            {7, 7, 7, 8, 8, 8, 9, 9, 9},
    };
    public static final int[][] sample = {
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0},
    };

    public int[][] targetMap;

    public Sudoku(int[][] targetMap) {
        this.targetMap = targetMap;
    }

    public int[][] getSolution(int[][] map) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (map[row][col] == 0) {
                    Integer[] possible = conjunction(getRow(row, map), getCol(col, map), getBox(row, col, map));
                    if (possible.length == 0) {
                        return null;
                    }

                    for (int i = 0; i < possible.length; i++) {
                        int[][] copy = new int[9][9];
                        for (int j = 0; j < 9; j++) {
                            copy[j] = map[j].clone();
                        }
                        copy[row][col] = possible[i];
                        int[][] output = getSolution(copy);
                        if (output != null) {
                            return output;
                        }
                    }
                }
            }
        }
        return map;
    }

    private int[] getRow(int row, int[][] map) {
        int[] theRow = map[row];
        return find(theRow);
    }

    private int[] getCol(int col, int[][] map) {
        int[] output = new int[9];
        for (int i = 0; i < output.length; i++) {
            output[i] = map[i][col];
        }
        return find(output);
    }

    private int[] getBox(int row, int col, int[][] map) {
        int value = box[row][col];
        int[] output = new int[9];
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (box[i][j] == value) {
                    output[count++] = map[i][j];
                }
            }
        }
        return find(output);
    }

    public Integer[] conjunction(int[] rows, int[] cols, int[] boxes) {
        Set<Integer> rowSet = getSet(rows);
        Set<Integer> temp = getSet(cols);
        rowSet.retainAll(temp);
        temp = getSet(boxes);
        rowSet.retainAll(temp);

        return rowSet.<Integer>toArray(new Integer[0]);
    }

    private Set<Integer> getSet(int[] args) {
        Set<Integer> output = new HashSet<>();
        for (int i = 0; i < args.length; i++) {
            output.add(args[i]);
        }
        return output;
    }

    public int[] find(int[] array) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                temp.add(array[i]);
            }
        }
        ArrayList<Integer> temp2 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            temp2.add(i);
        }
        temp2.removeAll(temp);
        int[] output = new int[temp2.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = temp2.get(i);
        }
        return output;
    }

}
