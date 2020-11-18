package gui;

import game.Gameboard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View extends Application {
	
    public CheckBox scoreOneBox;
    public CheckBox scoreTwoBox;
    public CheckBox scoreThreeBox;
    public CheckBox scoreFourBox;
    public CheckBox scoreFiveBox;

    public TextField onesField;
    public TextField fivesField;
    public TextField sixesField;
    public TextField chanceField;
    public TextField totalField;

    public Button onesButton;
    public Button fivesButton;
    public Button sixesButton;
    public Button chanceButton;
    public Button totalButton;

    public Label diceOneLabel;
    public Label diceTwoLabel;
    public Label diceThreeLabel;
    public Label diceFourLabel;
    public Label diceFiveLabel;

    public Label onesLabel;
    public Label fivesLabel;
    public Label sixesLabel;
    public Label chanceLabel;
    
    public CheckBox[] checkboxes = new CheckBox[5];
    public TextField[] pointsfields = new TextField[10];
    public Button[] pointbuttons = new Button[5];
	public Label[] dicelabels = new Label[5];
	public Label[] pointlabels = new Label[4];
	
    public void initializeControls() {
    	checkboxes = new CheckBox[] {scoreOneBox, scoreTwoBox, scoreThreeBox, scoreFourBox, scoreFiveBox};
    	dicelabels = new Label[] {diceOneLabel, diceTwoLabel, diceThreeLabel, diceFourLabel, diceFiveLabel};
    	pointbuttons = new Button[] {onesButton, fivesButton, sixesButton, chanceButton, totalButton};
    	pointsfields = new TextField[] {onesField, fivesField, sixesField, chanceField, totalField};
    	pointlabels = new Label[] {onesLabel, fivesLabel, sixesLabel, chanceLabel};
    }
    
    public Button rollButton;
    public Button playAgainButton;

    Gameboard yGameboard = new Gameboard(this);

    public void start(Stage primaryStage) throws Exception {
        try {

            FXMLLoader startloader = new FXMLLoader();        
            GridPane root = (GridPane) startloader.load(getClass().getResource("view.fxml").openStream());     
            primaryStage.setScene(new Scene(root));
            
            primaryStage.setTitle("Yahtzee");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void rollHandler() {
        yGameboard.roll();
    }
    
    public void takePointsHandler(ActionEvent event) {
        yGameboard.takePoints(event);
    }
    
    public void playAgainHandler() {

        yGameboard.playAgain();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
