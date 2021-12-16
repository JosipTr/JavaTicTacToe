package com.mycompany.tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        //Application title
        Parameters params = getParameters();
        String title = params.getNamed().get("title");
        
        //main layout
        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 300);
        
        //TicTacToe fields
        GridPane field = new GridPane();
        field.setAlignment(Pos.CENTER);
        field.setVgap(20);
        field.setHgap(20);
        field.setPrefSize(300, 300);
        
        
        Button buttonFieldOne = createButton();
        Button buttonFieldTwo = createButton();
        Button buttonFieldThree = createButton();
        Button buttonFieldFour = createButton();
        Button buttonFieldFive = createButton();
        Button buttonFieldSix = createButton();
        Button buttonFieldSeven = createButton();
        Button buttonFieldEight = createButton();
        Button buttonFieldNine = createButton();
        
        //adding buttons to TicTacToe field
        field.add(buttonFieldOne, 0, 0);
        field.add(buttonFieldTwo, 1, 0);
        field.add(buttonFieldThree, 2, 0);
        field.add(buttonFieldFour, 0, 1);
        field.add(buttonFieldFive, 1, 1);
        field.add(buttonFieldSix, 2, 1);
        field.add(buttonFieldSeven, 0, 2);
        field.add(buttonFieldEight, 1, 2);
        field.add(buttonFieldNine, 2, 2);
        
        layout.setCenter(field);
        
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public static void main(String[] args) {
        launch("--title=TicTacToe");
    }
    
    public Button createButton() {
        Button button = new Button();
        button.setPrefSize(80, 80);
        button.setFont(Font.font("Monospaced", 40));
        return button;
    }

}