package javaFXMiniProject;

public class Players {
	
public String name;
private int totalScore;


public Players(){
	 
}
public Players(String playerName){
name = playerName;
totalScore = 0;
}


public String getPlayerName(){
return name;
}


public int getPlayerScore(){
return totalScore;
}


public void updatePlayerName(String playerName){
name = playerName;
}


public void updatePlayerScore(int num) {
totalScore=totalScore+num;
}

}
