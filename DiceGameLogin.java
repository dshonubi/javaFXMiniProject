package javaFXMiniProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DiceGameLogin implements Initializable{
	
	Players player1;
	Players player2;

    @FXML
    private StackPane rootPane;
    
    @FXML
    private AnchorPane rootPane2;
    
    @FXML
    private TextField playerOneName;

    @FXML
    private TextField playerTwoName;

    @FXML
    private Button submit;

    @FXML
    private Button exit;

    @FXML
    private Button mainMenu;

    @FXML
    private Button instructions;
    
    @FXML
    private ImageView animatedDie1;

    @FXML
    private ImageView animatedDie2;

    @FXML
    void exitClicked(ActionEvent event) {
    System.exit(0);
    }

    @FXML
    void instructionsClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("DiceInstructions.fxml"));
    	rootPane.getChildren().setAll(pane);
    } 

    @FXML
    void mainMenuClicked(ActionEvent event) throws IOException {
    	StackPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
    	rootPane.getChildren().setAll(pane);
    }

    @FXML
    void submitClicked(ActionEvent event) throws IOException {
    	
    	player1 = new Players(playerOneName.getText());
    	String name1 = playerOneName.getText();
    	player2 = new Players(playerTwoName.getText());
    	String name2 = playerTwoName.getText();
    	
    	FXMLLoader load = new FXMLLoader(getClass().getResource("MainDiceGame.fxml"));
    	Parent root = (Parent) load.load();
    	MainGame mg = load.getController();
    	mg.setName1(name1);
    	mg.setName2(name2);
    	mg.setRoll1();
    	mg.setRoll2();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
 
    	
    	}

	@Override
	public void initialize(URL url,ResourceBundle rb) {
		TranslateTransition tn = new TranslateTransition();
		RotateTransition tnn = new RotateTransition();
        tnn.setCycleCount(RotateTransition.INDEFINITE);
        tnn.setByAngle(360);
        tnn.setNode(animatedDie1);
	    tn.setNode(animatedDie1);
	    tn.setToX(-250);
	    tn.setAutoReverse(true);
	    tn.setCycleCount(TranslateTransition.INDEFINITE);
	    tnn.play();
	    tn.play();
	    
        TranslateTransition tn1 = new TranslateTransition();
        RotateTransition tn11 = new RotateTransition();
        tn11.setCycleCount(RotateTransition.INDEFINITE);
        tn11.setByAngle(360);
        tn11.setNode(animatedDie2);
	    tn1.setNode(animatedDie2);
	    tn1.setToX(250);
	    tn1.setAutoReverse(true);
	    tn1.setCycleCount(TranslateTransition.INDEFINITE);
	    tn11.play();
	    tn1.play();
	}	
	}