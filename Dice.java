package javaFXMiniProject;

public class Dice {


public int diceRoll(){
	
int minimum = 1;
int maximum = 6;

int dieScore = minimum + (int)(Math.random() * ((maximum - minimum) + 1)) ;

return dieScore;
}
public static void main(String [] args) {
	
	Dice dice = new Dice();
	System.out.println(dice.diceRoll());
	
}
}
