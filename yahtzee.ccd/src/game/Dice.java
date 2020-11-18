package game;

public class Dice {
	
	int value;
	
	public void rollDice() {
		this.value=1 + (int) (6 * Math.random()); 
	}
	public void reset() {
		this.value=0;
	}
	public int getValue() {
		return value;
	}

}
