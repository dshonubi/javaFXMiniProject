package javaFXMiniProject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class PlayerWinsController{
	


    @FXML
    private StackPane rootPane;

    @FXML
    private AnchorPane rootPane2;

    @FXML
    private Button mainMenu;

    @FXML
    private Button beginGame;

    @FXML
    private Button exit;

    @FXML
    private Label playerWins;
    
    @FXML
    public void setPlayerWins(String name) {
    playerWins.setText(name);  
}

    @FXML
    void beginGameClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("PlayerLogin.fxml"));
    	rootPane.getChildren().setAll(pane);
    }

    @FXML
    void exitClicked(ActionEvent event) {
    	 System.exit(0);

    }

    @FXML
    void mainMenuClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
    	rootPane.getChildren().setAll(pane);
    }	
		
	}

