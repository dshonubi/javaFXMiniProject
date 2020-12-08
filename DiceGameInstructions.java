package javaFXMiniProject;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DiceGameInstructions{

	    @FXML
	    private StackPane rootPane;

	    @FXML
	    private AnchorPane rootPane2;

	    @FXML
	    private Button mainMenu;
	   
	    @FXML
	    private Button beginGame;

	    @FXML
	    private Button instructions;

	    @FXML
	    private Button exit;
    
    @FXML
    void exitClicked(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void mainMenuClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
    	rootPane.getChildren().setAll(pane);

    }
    
    @FXML
    void beginGameClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("PlayerLogin.fxml"));
    	rootPane.getChildren().setAll(pane);

    }



}