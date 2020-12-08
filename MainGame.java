package javaFXMiniProject;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.animation.*;


public class MainGame  {
     MainGame mg;
	Players player1 = new Players();
	Players player2 = new Players();
	Die dice1 = new Die();
	int score;
	
	

	   @FXML
	    private StackPane rootPane;

	    @FXML
	    private AnchorPane rootPane2;

	    @FXML
	    private Button mainMenu;

	    @FXML
	    private Button instructions;

	    @FXML
	    private Button exit;

	    @FXML
	    private ImageView die1;

	    @FXML
	    private ImageView die2;

	    @FXML
	    private ImageView die3;

	    @FXML
	    private ImageView die4;

	    @FXML
	    private ImageView die5;

	    @FXML
	    private ImageView die6;

	    @FXML
	    private Button rollButtonP1;

	    @FXML
	    private Label playerOne;

	    @FXML
	    private Label playerTwo;

	    @FXML
	    private Label roll1Player1;

	    @FXML
	    private Label roll2Player1;

	    @FXML
	    private Label roll3Player1;

	    @FXML
	    private Label totalScoreP1;

	    @FXML
	    private Label roll1Player2;

	    @FXML
	    private Label roll2Player2;

	    @FXML
	    private Label roll3Player2;

	    @FXML
	    private Label totalScoreP2;

	    @FXML
	    private Label currentScoreP1;

	    @FXML
	    private Label currentScoreP2;

	    @FXML
	    private Button rollButtonP2;


    @FXML
    public void setName1(String name) {
    playerOne.setText(name);  
}
    @FXML
    public void setName2(String name) {
    playerTwo.setText(name);
}   
    @FXML
    public void setRoll1() {
    rollButtonP1.setText(playerOne.getText()+ " roll");
}   
    @FXML
    public void setRoll2() {
    rollButtonP2.setText(playerTwo.getText() + " roll");
}   
    
    
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
    void rollButtonClickedP1(ActionEvent event) throws IOException {
    	RotateTransition t1 = new RotateTransition();
    	t1.setCycleCount(1);
        t1.setByAngle(360);
        t1.setNode(die1);
        t1.play();
        
        RotateTransition t2 = new RotateTransition();
    	t2.setCycleCount(1);
        t2.setByAngle(360);
        t2.setNode(die2);
        t2.play();
        
        RotateTransition t3 = new RotateTransition();
    	t3.setCycleCount(1);
        t3.setByAngle(360);
        t3.setNode(die3);
        t3.play();
        
        RotateTransition t4 = new RotateTransition();
    	t4.setCycleCount(1);
        t4.setByAngle(360);
        t4.setNode(die4);
        t4.play();
        
        RotateTransition t5 = new RotateTransition();
    	t5.setCycleCount(1);
        t5.setByAngle(360);
        t5.setNode(die5);
        t5.play();
        
        RotateTransition t6 = new RotateTransition();
    	t6.setCycleCount(1);
        t6.setByAngle(360);
        t6.setNode(die6);
        t6.play();
        
        int dice2 = dice1.diceRoll();
        String dice3 = Integer.toString(dice2);
        roll1Player1.setText(dice3);
        
        int dice5 = dice1.diceRoll();
        String dice4 = Integer.toString(dice5);
        roll2Player1.setText(dice4);
        
        int dice6 = dice1.diceRoll();
        String dice7 = Integer.toString(dice6);
        roll3Player1.setText(dice7);
        
        
        totalScoreP1.setText(dice7);
        
        
        if(score>=20) {
        
        }else if (roll1Player1 == roll2Player1) {
        score = dice2 + dice5;
        }else if(roll1Player1 == roll3Player1) {
        score = dice2 +dice6;
        }else if (roll2Player1 == roll3Player1) {
        score = dice5 + dice6;
        }else if((roll1Player1 == roll2Player1) && (roll2Player1 == roll3Player1)){
        int dice12 = dice2 *dice5;
        score = dice12 + dice6;
        }else {
        score=1;
        }
        
        currentScoreP1.setText(Integer.toString(score));
        player1.updatePlayerScore(score);
        totalScoreP1.setText(Integer.toString(player1.getPlayerScore()));
        
        if(((player1.getPlayerScore()>=1) && (player2.getPlayerScore()<=0)) || (player2.getPlayerScore()>=1) && (player1.getPlayerScore()<=0)) {
    		JOptionPane.showMessageDialog(null,"Both players need to take turns rolling");
    	}
        
        if((player1.getPlayerScore()>= 20)&&(player2.getPlayerScore()<=19)){
		FXMLLoader load = new FXMLLoader(getClass().getResource("PlayerWins.fxml"));
    	Parent root = null;
		try {
			root = (Parent) load.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	PlayerWinsController pw = load.getController();
    	pw.setPlayerWins("PLAYER 1 WINS!");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
		
	} else if((player1.getPlayerScore()>=20) && (player2.getPlayerScore()>=20)){
		FXMLLoader load = new FXMLLoader(getClass().getResource("PlayerWins.fxml"));
    	Parent root = null;
		try {
			root = (Parent) load.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	PlayerWinsController pw = load.getController();
    	pw.setPlayerWins("IT'S A DRAW!");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
		
	} else if ((player2.getPlayerScore()>= 20)&&(player1.getPlayerScore()<=19)){
			FXMLLoader load = new FXMLLoader(getClass().getResource("PlayerWins.fxml"));
	    	Parent root = null;
			try {
				root = (Parent) load.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	PlayerWinsController pw = load.getController();
	    	pw.setPlayerWins("PLAYER 2 WINS!");
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.show();
    
    

}
    	}

        
    
    @FXML
    void rollButtonClickedP2(ActionEvent event) throws IOException {
    	RotateTransition t1 = new RotateTransition();
    	t1.setCycleCount(1);
        t1.setByAngle(360);
        t1.setNode(die1);
        t1.play();
        
        RotateTransition t2 = new RotateTransition();
    	t2.setCycleCount(1);
        t2.setByAngle(360);
        t2.setNode(die2);
        t2.play();
        
        RotateTransition t3 = new RotateTransition();
    	t3.setCycleCount(1);
        t3.setByAngle(360);
        t3.setNode(die3);
        t3.play();
        
        RotateTransition t4 = new RotateTransition();
    	t4.setCycleCount(1);
        t4.setByAngle(360);
        t4.setNode(die4);
        t4.play();
        
        RotateTransition t5 = new RotateTransition();
    	t5.setCycleCount(1);
        t5.setByAngle(360);
        t5.setNode(die5);
        t5.play();
        
        RotateTransition t6 = new RotateTransition();
    	t6.setCycleCount(1);
        t6.setByAngle(360);
        t6.setNode(die6);
        t6.play();
        
        int dice2 = dice1.diceRoll();
        String dice3 = Integer.toString(dice2);
        roll1Player2.setText(dice3);
        
        int dice5 = dice1.diceRoll();
        String dice4 = Integer.toString(dice5);
        roll2Player2.setText(dice4);
        
        int dice6 = dice1.diceRoll();
        String dice7 = Integer.toString(dice6);
        roll3Player2.setText(dice7);
        
        
        totalScoreP2.setText(dice7);
        if (score>=20) {
        	
        }else if(roll1Player2 == roll2Player2) {
        score = dice2 + dice5;
        }else if(roll2Player2 == roll3Player2) {
        score = dice2 +dice6;
        }else if (roll1Player2 == roll3Player2) {
        score = dice5 + dice6;
        }else if((roll1Player2 == roll2Player2) && (roll2Player2 == roll3Player2)){
        int dice12 = dice2 *dice5;
        score = dice12 + dice6;
        }else {
        score=1;
        }
        currentScoreP2.setText(Integer.toString(score));
        player2.updatePlayerScore(score);
        totalScoreP2.setText(Integer.toString(player2.getPlayerScore()));

        if(((player1.getPlayerScore()>=1) && (player2.getPlayerScore()<=0)) ||(player2.getPlayerScore()>=1) && (player1.getPlayerScore()<=0))  {
    		JOptionPane.showMessageDialog(null,"Both players need to take turns rolling");
    	}
        if((player1.getPlayerScore()>= 20)&&(player2.getPlayerScore()<=19)){
		FXMLLoader load = new FXMLLoader(getClass().getResource("PlayerWins.fxml"));
    	Parent root = null;
		try {
			root = (Parent) load.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	PlayerWinsController pw = load.getController();
    	pw.setPlayerWins("PLAYER 1 WINS!");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
		
	} else if((player1.getPlayerScore()>=20) && (player2.getPlayerScore()>=20)){
		FXMLLoader load = new FXMLLoader(getClass().getResource("PlayerWins.fxml"));
    	Parent root = null;
		try {
			root = (Parent) load.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	PlayerWinsController pw = load.getController();
    	pw.setPlayerWins("IT'S A DRAW!");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
		
	} else if ((player2.getPlayerScore()>= 20)&&(player1.getPlayerScore()<=19)){
			FXMLLoader load = new FXMLLoader(getClass().getResource("PlayerWins.fxml"));
	    	Parent root = null;
			try {
				root = (Parent) load.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	PlayerWinsController pw = load.getController();
	    	pw.setPlayerWins("PLAYER 2 WINS!");
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.show();
    
    

}
    }
    }
    
 
 

 