package game;

import java.util.ArrayList;

import gui.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Gameboard {

	View yView;

	public Gameboard(View view) {
		yView = view;
	}

	DiceCup yDiceCup = new DiceCup();
	Scores yScores = new Scores();

	public void roll() {
		yView.initializeControls();
		yDiceCup.incRounds();	
		resetButtons();
		
		switch (yDiceCup.getRounds()) {
		case 0:
			yDiceCup.rollAll();
			setDiceColumn();
			break;
		case 1:
			pickDice();
			setDiceColumn();
			break;
		case 2:
			pickDice();
			setDiceColumn();
			break;
		case 3:
			pickDice();
			setDiceColumn();
			yView.rollButton.setDisable(true);
			yDiceCup.resetDices();
			yDiceCup.resetRounds();
			break;
		}
	}

	public void takePoints(ActionEvent event) {
		handleNextRound();
		if (event.getSource() == yView.onesButton) {
			handlePoints(yView.onesButton, yScores.ones, yView.onesField, yScores.ResultList);
		}
		if (event.getSource() == yView.fivesButton) {
			handlePoints(yView.fivesButton, yScores.fives, yView.fivesField, yScores.ResultList);

		}
		if (event.getSource() == yView.sixesButton) {
			handlePoints(yView.sixesButton, yScores.sixes, yView.sixesField, yScores.ResultList);

		}
		if (event.getSource() == yView.chanceButton) {
			handlePoints(yView.chanceButton, yScores.chance, yView.chanceField, yScores.ResultList);

		}
		if (event.getSource() == yView.totalButton) {
			yView.rollButton.setDisable(true);
			yView.totalField.setText(" " + yScores.calculateTotal());
			yScores.ResultList.clear();
		}
	}
	
	public void setDiceColumn() {

		for (int i = 0; i < yView.dicelabels.length; i++) {
			yView.dicelabels[i].setText(" " + yDiceCup.dices[i].getValue());
		}

		yScores.resetPoints();
		yScores.calculatePoints(yDiceCup.dices);

		for (int i = 0; i < yView.pointlabels.length; i++) {
			yScores.initializePoints();
			yView.pointlabels[i].setText(" " + yScores.points[i]);
		}
	}

	public void pickDice() {
		for (int i = 0; i < yView.checkboxes.length; i++) {
			if (!yView.checkboxes[i].isSelected()) {
				yDiceCup.rollIndex(i);
				yView.dicelabels[i].setText(" " + yDiceCup.dices[i].getValue());
				yView.dicelabels[i].setTextFill(Color.BLACK);
			} else {
				yView.dicelabels[i].setTextFill(Color.GREEN);
			}

		}

	}

	private void handlePoints(Button pointbuttons, int points, TextField pointsfields, ArrayList<Integer> resultlist) {
		pointbuttons.setDisable(true);
		pointsfields.setText(" " + points);
		yScores.ResultList.add(points);
		yView.rollButton.setDisable(false);
	}

	public void handleNextRound() {
		resetBoxes();
		resetLabels();
		yDiceCup.resetDices();
		yDiceCup.resetRounds();
	}

	public void playAgain() {	
		yView.initializeControls();
		yView.rollButton.setDisable(false);
		yDiceCup.resetRounds();
		yScores.resetPoints();
		yScores.ResultList.clear();
		resetButtons();
		resetFields();
		resetLabels();
		resetBoxes();
		yDiceCup.resetDices();
	}

	public void resetLabels() {
		for (int i = 0; i < yView.pointlabels.length; i++) {
			yView.pointlabels[i].setText(" ");
		}
		for (int i = 0; i < yView.dicelabels.length; i++) {
			yView.dicelabels[i].setText(" ");
			yView.dicelabels[i].setTextFill(Color.BLACK);
		}
	}

	public void resetFields() {
		for (int i = 0; i < yView.pointsfields.length; i++) {
			yView.pointsfields[i].setText(" ");
		}
	}

	public void resetBoxes() {
		for (int i = 0; i < yView.checkboxes.length; i++) {
			yView.checkboxes[i].setSelected(false);
		}
	}

	public void resetButtons() {
		for (int i = 0; i < yView.pointbuttons.length; i++) {
			yView.pointbuttons[i].setDisable(false);
		}
	}

}
