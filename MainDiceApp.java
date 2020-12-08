package javaFXMiniProject;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDiceApp extends Application{
public void start(Stage primaryStage) throws IOException{
	
     FXMLLoader load = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
     Parent root = (Parent) load.load();
     primaryStage.setScene(new Scene(root));
     primaryStage.show();
	
}
	
public static void main(String[] args ) {
launch(args);
	
}
}