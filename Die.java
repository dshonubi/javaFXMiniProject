package javaFXMiniProject;

public class Die {


public int diceRoll(){
	
int minimum = 1;
int maximum = 6;

int dieScore = minimum + (int)(Math.random() * ((maximum - minimum) + 1)) ;

return dieScore;

}
}