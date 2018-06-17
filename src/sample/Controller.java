package sample;

public class Controller {
    int[][] output;
    public int[][] getOutput() {
        int[][] map = new int[9][9];
        for (int row = 0; row < 9; row++) {
            map[row] = null;
        }
        Sudoku sudoku = new Sudoku(map);
        output = sudoku.getSolution(sudoku.targetMap);
        return output;
    }

    public void toOutput() {

    }
}
