/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.company.domain;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author JT
 */
public class ButtonState {
    
    private final ArrayList<Button> btnList;
    
    public ButtonState() {
        this.btnList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            this.btnList.add(createButton());
        }
    }
    
    public void addToLayout(GridPane layout) {
        int flag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                layout.add(this.btnList.get(flag), j, i);
                flag++;
            }
        }
    }
    
    public void setOnClick(int position, Label label) {
        this.btnList.get(position).setOnAction(event -> {
            if (label.getText().equals("Turn: X")) {
                this.btnList.get(position).setText("X");
                this.btnList.get(position).setDisable(true);
                label.setText("Turn: O");
//                positionOfIndex(position);
                checkValue("X", label);
                checkValue("O", label);
                
            } else {
                this.btnList.get(position).setText("O");
                label.setText("Turn: X");
                this.btnList.get(position).setDisable(true);
//                positionOfIndex(position);
                checkValue("X", label);
                checkValue("O", label);
            }
            });
        
    }
    
//    private void positionOfIndex(int position) {
//        if (position == 1) {
//            this.state[position - 1][position] = this.btnList.get(position).getText();
//        } else if (position == 2) {
//                    this.state[position - 2][position] = this.btnList.get(position).getText();
//                } else if (position == 3) {
//                    this.state[position - 2][position - 3] = this.btnList.get(position).getText();
//                } else if (position == 4) {
//                    this.state[position - 3][position - 3] = this.btnList.get(position).getText();
//                } else if (position == 5) {
//                    this.state[position - 4][position - 3] = this.btnList.get(position).getText();
//                } else if (position == 6) {
//                    this.state[position - 4][position - 6] = this.btnList.get(position).getText();
//                } else if (position == 7) {
//                    this.state[position - 5][position - 6] = this.btnList.get(position).getText();
//                } else if (position == 8) {
//                    this.state[position - 6][position - 6] = this.btnList.get(position).getText();
//                } else {
//                    this.state[position][position] = this.btnList.get(position).getText();
//                }
//    }
    
    private Button createButton() {
        Button button = new Button();
        button.setPrefSize(80, 80);
        button.setFont(Font.font("Monospaced", 40));
        return button;
    }
    
    
    private void checkValue(String value, Label label) {
               if (btnList.get(0).getText().equals(value) && btnList.get(1).getText().equals(value) && btnList.get(2).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
       if (btnList.get(3).getText().equals(value) && btnList.get(4).getText().equals(value) && btnList.get(5).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
       if (btnList.get(6).getText().equals(value) && btnList.get(7).getText().equals(value) && btnList.get(8).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
       if (btnList.get(0).getText().equals(value) && btnList.get(3).getText().equals(value) && btnList.get(6).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
       if (btnList.get(1).getText().equals(value) && btnList.get(4).getText().equals(value) && btnList.get(7).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
       if (btnList.get(2).getText().equals(value) && btnList.get(5).getText().equals(value) && btnList.get(8).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
       if (btnList.get(6).getText().equals(value) && btnList.get(4).getText().equals(value) && btnList.get(2).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
       if (btnList.get(0).getText().equals(value) && btnList.get(4).getText().equals(value) && btnList.get(8).getText().equals(value)) {
           label.setText("Winner is " + value);
           disableAllButtons();
       }
    }
    
    
//    private void check(String value, Label label) {
//        int row1 = 0, row2 = 0, row3 = 0, column1 = 0, column2 = 0, column3 = 0, diagonalMain = 0, diagonalSec = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (i == 0 && this.state[i][j].equals(value)) {
//                    row1++;
//                    
//                } else if (i == 1 && this.state[i][j].equals(value)) {
//                    row2++;
//                } else if (i == 2 && this.state[i][j].equals(value)) {
//                    row3++;
//                } else if (j == 0 && this.state[i][j].equals(value)) {
//                    column1++;
//                } else if (j == 1 && this.state[i][j].equals(value)) {
//                    column2++;
//                } else if (j == 2 && this.state[i][j].equals(value)) {
//                    column3++;
//                } else if (i == j && this.state[i][j].equals(value)) {
//                    diagonalMain++;
//                } else if (i + j == 2 && this.state[i][j].equals(value)) {
//                    diagonalSec++;
//                }
//            }
//        }
//        
//        if (row1 == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        } else if (row2 == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        } else if (row3 == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        } else if (column1 == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        } else if (column2 == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        } else if (column3 == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        } else if (diagonalMain == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        } else if (diagonalSec == 3) {
//            label.setText("Winner is " + value);
//            disableAllButtons();
//        }
//        
//    }
    
    private void disableAllButtons() {
        this.btnList.stream()
                .forEach(button -> button.setDisable(true));
    }
    
}
