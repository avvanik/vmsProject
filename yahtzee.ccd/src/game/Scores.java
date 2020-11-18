package game;

import java.util.ArrayList;

import gui.View;


public class Scores {

	DiceCup yDiceCup = new DiceCup();
	View yView;

	public int ones = 0;
	public int fives = 0;
	public int sixes = 0;
	public int chance = 0;

	public void calculatePoints(Dice[] dices) {
		for (int i = 0; i < dices.length; i++) {
			if (dices[i].getValue() == 1) {
				ones++;
			}
		}
		for (int i = 0; i < dices.length; i++) {
			if (dices[i].getValue() == 5) {
				fives += 5;
			}
		}
		for (int i = 0; i < dices.length; i++) {
			if (dices[i].getValue() == 6) {
				sixes = sixes + dices[i].getValue();
			}
		}
		for (int i = 0; i < dices.length; i++) {
			chance += dices[i].getValue();
		}

	}

	public ArrayList<Integer> ResultList = new ArrayList<Integer>();

	public int total = 0;

	public int calculateTotal() {
		for (int num : ResultList) {
			total += num;
		}
		return total;
	}

	public void resetPoints() {
		ones=0;
		fives=0;
		sixes=0;
		chance=0;
		total=0;
		
	}

	public void clearResultList() {
			ResultList.clear();
	}

	public void addValueToResultList(ArrayList<Integer> List, Integer value) {
		((ArrayList<Integer>) List).add(value);	
	}

}
