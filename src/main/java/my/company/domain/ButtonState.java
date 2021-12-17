/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.company.domain;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author JT
 */
public class ButtonState {
    
    private HashMap<Integer, ArrayList<Button>> matrix;
    
    public ButtonState() {
        this.matrix = new HashMap();
    }
    
    public void addButtonArray(int row, ArrayList<Button> buttons) {
        this.matrix.put(row, buttons);
    }
    
    public void addToLayout(GridPane layout) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                layout.add(this.matrix.get(i).get(j), j, i);
            }
        }
    }
    
    public void onAction(int x, int y, Label label) {
        this.matrix.get(x).get(y).setOnAction(event -> {
            if (label.getText().equals("Turn: X")) {
                this.matrix.get(x).get(y).setText("X");
                //checkFunct -->
                label.setText("Turn: O");
                this.matrix.get(x).get(y).setDisable(true);
                checkDraw(label);
                check("O",label);
                check("X",label);

                
            } else {
                this.matrix.get(x).get(y).setText("O");
                this.matrix.get(x).get(y).setDisable(true);
                //checkFunct -->
                label.setText("Turn: X");
                checkDraw(label);
                check("O",label);
                check("X",label);

            }
        });
        
    }
    
    public void runAction(Label label) {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                onAction(i,j,label);
            }
        }
        
    }
    
    private void check(String value, Label label) {
        int row1 = 0, row2 = 0, row3 = 0, column1 = 0, column2 = 0, column3 = 0, mainDiag = 0, secDiag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                if (i == 0 && this.matrix.get(i).get(j).getText().equals(value)) row1++;
                if (i == 1 && this.matrix.get(i).get(j).getText().equals(value)) row2++;
                if (i == 2 && this.matrix.get(i).get(j).getText().equals(value)) row3++;
                if (j == 0 && this.matrix.get(i).get(j).getText().equals(value)) column1++;
                if (j == 1 && this.matrix.get(i).get(j).getText().equals(value)) column2++;
                if (j == 2 && this.matrix.get(i).get(j).getText().equals(value)) column3++;
                if (i == j && this.matrix.get(i).get(j).getText().equals(value)) mainDiag++;
                if (i + j == 2 && this.matrix.get(i).get(j).getText().equals(value)) secDiag++;
            }
        }
        
        
        if (row1 == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        } else if (row2 == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        } else if (row3 == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        } else if (column1 == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        } else if (column2 == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        } else if (column3 == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        } else if (mainDiag == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        } else if (secDiag == 3) {
            label.setText("Winner: " + value);
            disableAllButtons();
        }
        
    }
    
    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrix.get(i).get(j).setDisable(true);
            }
        }
    }
    
    private boolean allDisabled() {
        int flag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.matrix.get(i).get(j).isDisabled()) {
                    flag++;
                }
            }
        }
        return (flag == 9);
    }
    
    private void checkDraw(Label label) {
        if (allDisabled()) {
            label.setText("Draw");
        }
    }
    
}
