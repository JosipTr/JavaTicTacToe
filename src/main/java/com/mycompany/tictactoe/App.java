package com.mycompany.tictactoe;

import com.mycompany.domain.ButtonStatement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        ButtonStatement statements = new ButtonStatement();
        
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
        
        btnAction(btnList, 0, textTurn);
        btnAction(btnList, 1, textTurn);
        btnAction(btnList, 2, textTurn);
        btnAction(btnList, 3, textTurn);
        btnAction(btnList, 4, textTurn);
        btnAction(btnList, 5, textTurn);
        btnAction(btnList, 6, textTurn);
        btnAction(btnList, 7, textTurn);
        btnAction(btnList, 8, textTurn);
        
        
        completeLayout.getChildren().addAll(textTurn, field);
        
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
    
    //button logic
    public void btnAction(ArrayList<Button> btnList, int position, Label label) {
        
        btnList.get(position).setOnAction(event -> {
            if (label.getText().equals("Turn: X")) {
                btnList.get(position).setText("X");
                label.setText("Turn: O");
                btnList.get(position).setDisable(true);
//                statements.addStateX(GridPane.getColumnIndex(btnList.get(position)), GridPane.getRowIndex(btnList.get(position)));
//                statements.check("X");
//                statements.check("O");
            } else {
                btnList.get(position).setText("O");
                label.setText("Turn: X");
                btnList.get(position).setDisable(true);
//                statements.addStateO(GridPane.getColumnIndex(btnList.get(position)), GridPane.getRowIndex(btnList.get(position)));
//                statements.check("X");
//                statements.check("O");
            }
        });
        
    }
    
}