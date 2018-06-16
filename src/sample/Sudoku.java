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

    public int[][] map;

    public Sudoku(int[][] map) {
        this.map = map;
    }

    public int[][] getSolution() {
        return null;
    }

    private int[] getRow(int row) {
        int[] theRow = map[row];
        return find(theRow);
    }

    private int[] getCol(int col) {
        int[] output = new int[9];
        for (int i = 0; i < output.length; i++) {
            output[i] = map[i][col];
        }
        return find(output);
    }

    private int[] getBox(int row, int col) {
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

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(null);
        System.out.println(Arrays.toString(sudoku.conjunction(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3}, new int[]{3})));
        int[] test = new int[4];
        for (int i = 0; i < 3; i++) {
            test[i] = 1;
        }
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(sudoku.find(new int[]{1, 2, 3, 4, 0, 0, 1, 1, 1, 1})));
    }

}
