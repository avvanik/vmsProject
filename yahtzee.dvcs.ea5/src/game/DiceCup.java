package game;

public class DiceCup {
	
	private static int currRounds = 0;
	public Dice[] dices = new Dice[5];

	public DiceCup() {
		currRounds = 0;
		initDices();
	}

	private void initDices() {
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new Dice();
		}

	}

	public void rollAll() {
		currRounds = 1;
		for (Dice dice : dices) {
			dice.rollDice();
		}

	}

	public void rollIndex(int index) {
		dices[index].rollDice();

	}

	public void incRounds() {
		currRounds++;
	}

	public int getRounds() {
		return currRounds;
	}

	public void resetRounds() {
		currRounds = 0;
	}

	public void resetDices() {
		for (Dice dice : dices) {
			dice.reset();
		}
	}

}
