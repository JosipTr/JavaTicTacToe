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
import my.company.domain.ButtonState;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        ButtonState buttonState = new ButtonState();
        
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
        
        //layout which contains buttons and labels
        VBox completeLayout = new VBox();
        completeLayout.setSpacing(20);
        completeLayout.setAlignment(Pos.CENTER);
        
        
        //Label which say whose turn it is
        Label textTurn = new Label("Turn: X");
        textTurn.setFont(Font.font("Monospaced", 40));

        //buttons
        for (int i = 0; i < 3; i++) {
            buttonState.addButtonArray(i, buttonList());
        }
        
        //Button playAgain
        
        Button button = new Button("New Game");
        
        
        //adding buttons to TicTacToe field
        buttonState.addToLayout(field);
        
        //addig layouts to VBox
        completeLayout.getChildren().addAll(textTurn, field);
        
        //adding layouts to the main layout
        layout.setCenter(completeLayout);
        
        //button logic
        buttonState.runAction(textTurn);
        
        //setting toDisplay
        Scene scene = new Scene(layout);
        
        
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
    
    
    /////////////////////////////MAIN///////////////////////////////////
    
    public static void main(String[] args) {
        launch("--title=TicTacToe");
    }
    
    ////////////////////////////FUNCTIONS/////////////////////////////////
    
    public Button createButton() {
        Button button = new Button();
        button.setPrefSize(80, 80);
        button.setFont(Font.font("Monospaced", 40));
        return button;
    }
    
    public ArrayList<Button> buttonList() {
        ArrayList<Button> buttons = new ArrayList();
        for (int i = 0; i < 3; i++) {
            buttons.add(createButton());
        }
        return buttons;
    }
    
    
    public void playAgain(Stage stage, Button button) {
        button.setOnAction(event -> {
            restart(stage, button);
        });
    }

    private void restart(Stage stage, Button button) {
        playAgain(stage,button);
    }
    
}
