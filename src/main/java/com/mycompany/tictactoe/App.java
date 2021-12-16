package com.mycompany.tictactoe;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        String value = "X";
        
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
        
        //layout which contains buttons and turnLabel
        VBox completeLayout = new VBox();
        completeLayout.setSpacing(20);
        
        //Label which say whose turn it is
        Label turn = new Label("Turn: " + value);
        turn.setFont(Font.font("Monospaced", 40));
        
        ArrayList<Button> btnList = createButtonList();
        
        //adding buttons to TicTacToe field
        field.add(btnList.get(0), 0, 0);
        field.add(btnList.get(1), 1, 0);
        field.add(btnList.get(2), 2, 0);
        field.add(btnList.get(3), 0, 1);
        field.add(btnList.get(4), 1, 1);
        field.add(btnList.get(5), 2, 1);
        field.add(btnList.get(6), 0, 2);
        field.add(btnList.get(7), 1, 2);
        field.add(btnList.get(8), 2, 2);
        
        completeLayout.getChildren().addAll(turn, field);
        
        layout.setCenter(completeLayout);
        
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
    
    //creating arrayList and adding buttons to it
    public ArrayList<Button> createButtonList() {
        ArrayList<Button> btnList = new ArrayList();
        for (int i = 0; i < 9; i++) {
            btnList.add(createButton());
        }
        return btnList;
    }
}