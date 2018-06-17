package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        GridPane pane = new GridPane();
        TextField t0 = new TextField("{0, 0, 0, 2, 6, 0, 7, 0, 1},");
        TextField t1 = new TextField("{6, 8, 0, 0, 7, 0, 0, 9, 0},");
        TextField t2 = new TextField("{1, 9, 0, 0, 0, 4, 5, 0, 0},");
        TextField t3 = new TextField("{8, 2, 0, 1, 0, 0, 0, 4, 0},");
        TextField t4 = new TextField("{0, 0, 4, 6, 0, 2, 9, 0, 0},");
        TextField t5 = new TextField("{0, 5, 0, 0, 0, 3, 0, 2, 8},");
        TextField t6 = new TextField("{0, 0, 9, 3, 0, 0, 0, 7, 4},");
        TextField t7 = new TextField("{0, 4, 0, 0, 5, 0, 0, 3, 6},");
        TextField t8 = new TextField("{7, 0, 3, 0, 1, 8, 0, 0, 0},");
        TextField[] texts = {t0, t1, t2, t3, t4, t5, t6, t7, t8};
        GridPane.setConstraints(t0, 0, 0);
        GridPane.setConstraints(t1, 0, 1);
        GridPane.setConstraints(t2, 0, 2);
        GridPane.setConstraints(t3, 0, 3);
        GridPane.setConstraints(t4, 0, 4);
        GridPane.setConstraints(t5, 0, 5);
        GridPane.setConstraints(t6, 0, 6);
        GridPane.setConstraints(t7, 0, 7);
        GridPane.setConstraints(t8, 0, 8);
        pane.getChildren().addAll(t0, t1, t2, t3, t4, t5, t6, t7, t8);
        pane.getChildren().forEach(node -> {
            if (node instanceof TextField) {
                ((TextField) node).setPrefWidth(400);
                GridPane.setMargin(node, new Insets(5, 5, 1, 50));
            }

        });
        Button button = new Button("Finish");
        GridPane.setConstraints(button, 0, 9);
        pane.getChildren().add(button);

        button.setOnMousePressed(mouseEvent -> {
            int[][] output = new int[9][];
            for (int i = 0; i < output.length; i++) {
                output[i] = getInt(texts[i].getText());

            }
            Sudoku sudoku = new Sudoku(output);
            int[][] value = sudoku.getSolution(sudoku.targetMap);

            StringBuilder theLabelString = new StringBuilder();
            for (int[] aValue : value) {
                theLabelString.append(Arrays.toString(aValue)).append("\n");
            }

            Stage box = new Stage();
            Label label = new Label(theLabelString.toString());
            StackPane pane1 = new StackPane(label);
            label.setAlignment(Pos.CENTER);
            Scene scene = new Scene(pane1, 400, 400);
            box.setScene(scene);
            box.setTitle("Result");
            box.initModality(Modality.APPLICATION_MODAL);
            box.showAndWait();
        });


        root.getChildren().add(pane);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SudokuSolver");
        primaryStage.show();
    }

    private int[] getInt(String string) {
        if (string.equals("")) {
            return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        }
        int count = 0;
        int[] output = new int[9];
        for (int i = 0; i < string.length(); i++) {
            if (count == 9) {
                return output;
            }
            if (48 <= string.charAt(i) && string.charAt(i) <= 57) {
                output[count++] = Integer.valueOf(string.substring(i, i + 1));
            }
        }
        return output;
    }

}
