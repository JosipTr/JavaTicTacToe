/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.domain;

/**
 *
 * @author JT
 */
public class ButtonStatement {
    
    private String[][] array;
    
    public ButtonStatement() {
        this.array = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.array[i][j] = "";
            }
        }
    }
    
    public String getState(int i, int j) {
        return this.array[i][j];
    }
    
    public void addStateX(int i, int j) {
        this.array[i][j] = "X";
    }
    
    public void addStateO(int i, int j) {
        this.array[i][j] = "O";
    }
    
    
    public boolean check(String value) {
        int row1 = 0, row2 = 0, row3 = 0, column1 = 0, column2 = 0, column3 = 0, diagonalMain = 0, diagonalSec = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 && this.array[i][j].equals(value)) {
                    row1++;
                    
                } else if (i == 1 && this.array[i][j].equals(value)) {
                    row2++;
                } else if (i == 2 && this.array[i][j].equals(value)) {
                    row3++;
                } else if (j == 0 && this.array[i][j].equals(value)) {
                    column1++;
                } else if (j == 1 && this.array[i][j].equals(value)) {
                    column2++;
                } else if (j == 2 && this.array[i][j].equals(value)) {
                    column3++;
                } else if (i == j && this.array[i][j].equals(value)) {
                    diagonalMain++;
                } else if (i + j == 2 && this.array[i][j].equals(value)) {
                    diagonalSec++;
                }
            }
        }
        if (row1 == 3) return true;
        else if (row2 == 3) return true;
        else if (row3 == 3) return true;
        else if (column1 == 3) return true;
        else if (column2 == 3) return true;
        else if (column3 == 3) return true;
        else if (diagonalMain == 3) return true;
        else if (diagonalSec == 3) return true;
        return false;
    }

       
        
    
}
