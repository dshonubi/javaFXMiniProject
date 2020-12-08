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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Homepage {
	
	@FXML
	private StackPane rootPane;
	
    @FXML
	private AnchorPane rootPane2;

    @FXML
    private Button btn_Begin_Homepage;

    @FXML
    private Button btn_Instructions;

    @FXML
    private Button btn_Exit_Homepage;

    @FXML
    void beginClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("PlayerLogin.fxml"));
    	rootPane.getChildren().setAll(pane);

    }
    
    @FXML
    void instructionsClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("DiceInstructions.fxml"));
    	rootPane.getChildren().setAll(pane);
    }

    @FXML
    void exitClicked(ActionEvent event) {
    	
    	System.exit(0);

    }

    

}