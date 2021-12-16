package com.mycompany.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
        
        
        
        
        
        
        
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public static void main(String[] args) {
        launch("--title=TicTacToe");
    }

}