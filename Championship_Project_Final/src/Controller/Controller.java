
package Controller;

import Model.Model;
import View.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;

public class Controller {
	private Model theModel;
	private View theView;

	public Controller(Model m, View v) {
		theModel = m;
		theView = v;

		// 1. add event: Change wanted Action:Tennis/Basketball/Soccer
		ChangeListener<Toggle> chlDiffSport = new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				// MAIN EVENT SELECTED
				String sport = theView.getSport();
				//get the right object from the model to the view
				//show the right list according to the toggle group
				theView.setRightList(theModel.getRightSport(sport),false);
			}
		};
		// 2. connect the ChangeListener to view
		theView.addChangeListenerToToggleGroup(chlDiffSport);

		// 1. add event: add Participant
		EventHandler<ActionEvent> eventForAddParticipant = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				//add the name to the right list
				theView.addToList(theModel.getRightSport(sport));
			}
		};
		// 2. attach this event to Add Participant Button pressed
		theView.addEventHandlerToAddParticipant(eventForAddParticipant);

		// 1. add event: Start Championship
		EventHandler<ActionEvent> eventForStartChampionship = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theView.setButtonCount();
				theView.StartChampionship(theModel.getRightSport(sport));
				theView.disableButton();

			}
		};
		// 2. attach this event to Start Championship Button pressed
		theView.addEventHandlerToStartChampionship(eventForStartChampionship);

		// 1. add event: Start Top8Game1
		EventHandler<ActionEvent> eventForTop8StartGame1 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theModel.setNumberOfTimes(0);
				theView.setPressedButton(1);
				theView.startGame(theModel.getRightSport(sport),0,"Top8");
			}
		};
		// 2. attach this event to Start Top8Game1 Button pressed
		theView.addEventHandlerToStartTop8Game1(eventForTop8StartGame1);

		// 1. add event: Start Top8Game2
		EventHandler<ActionEvent> eventForTop8StartGame2 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theModel.setNumberOfTimes(0);
				theView.setPressedButton(2);
				theView.startGame(theModel.getRightSport(sport),2,"Top8");
			}
		};
		// 2. attach this event to Start Top8Game2 Button pressed
		theView.addEventHandlerToStartTop8Game2(eventForTop8StartGame2);

		// 1. add event: Start Top8Game3
		EventHandler<ActionEvent> eventForTop8StartGame3 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theModel.setNumberOfTimes(0);
				theView.setPressedButton(3);
				theView.startGame(theModel.getRightSport(sport),4,"Top8");
			}
		};
		// 2. attach this event to Start Top8Game3 Button pressed
		theView.addEventHandlerToStartTop8Game3(eventForTop8StartGame3);

		// 1. add event: Start Top8Game3
		EventHandler<ActionEvent> eventForTop8StartGame4 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theModel.setNumberOfTimes(0);
				theView.setPressedButton(4);
				theView.startGame(theModel.getRightSport(sport),6,"Top8");
			}
		};
		// 2. attach this event to Start Top8Game4 Button pressed
		theView.addEventHandlerToStartTop8Game4(eventForTop8StartGame4);
		
		// 1. add event: Start Top4Game1
		EventHandler<ActionEvent> eventForTop4StartGame1 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theModel.setNumberOfTimes(0);
				theView.setPressedButton(5);
				theView.startGame(theModel.getRightSport(sport), 0, "Top4");
			}
		};
		// 2. attach this event to Start Top4Game1 Button pressed
		theView.addEventHandlerToStartTop4Game1(eventForTop4StartGame1);

		// 1. add event: Start Top4Game2
		EventHandler<ActionEvent> eventForTop4StartGame2 = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theModel.setNumberOfTimes(0);
				theView.setPressedButton(6);
				theView.startGame(theModel.getRightSport(sport), 2, "Top4");
			}
		};
		// 2. attach this event to Start Top4Game2 Button pressed
		theView.addEventHandlerToStartTop4Game2(eventForTop4StartGame2);

		// 1. add event: Start Final
		EventHandler<ActionEvent> eventForFinals = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theModel.setNumberOfTimes(0);
				theView.setPressedButton(7);
				theView.startGame(theModel.getRightSport(sport), 0, "Finals");
			}
		};
		// 2. attach this event to Start Final Button pressed
		theView.addEventHandlerToStartFinals(eventForFinals);

		// 1. add event: End Game
		EventHandler<ActionEvent> eventForDoneGame = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String sport = theView.getSport();
				boolean winnerFound = theModel.findWinner(theView);
				if (sport.equalsIgnoreCase("Tennis")) {
					if (winnerFound) {
						theView.closeWindow();
						theView.StartChampionship(theModel.getRightSport(theView.getSport()));

					} else {
						theView.makeMoreMatches("Tennis");
					}
				} else if (sport.equalsIgnoreCase("Basketball")) {
					theView.closeWindow();
					theView.StartChampionship(theModel.getRightSport(theView.getSport()));
				} else {
					if (winnerFound) {
						theView.closeWindow();
						theView.StartChampionship(theModel.getRightSport(theView.getSport()));
					} else if (!winnerFound && theModel.getNumberOfTimes() == 2) {
						theView.makeMoreMatches("Soccer2");
					} else if (!winnerFound && theModel.getNumberOfTimes() == 1) {
						theView.makeMoreMatches("Soccer1");
					}
				}
				if(theModel.getPhase() == "Top8") {
					theView.enableTop4Button();
				}else if(theModel.getPhase() == "Top4") {
					theView.enableFinaleButton();
				}else {
					theView.showPrevious();
				}
			}
		};
		// 2. attach this event to Done Button pressed
		theView.addEventHandlerToDoneButton(eventForDoneGame);
		
		// 1. add event: PREVIOUS SCREEN
		EventHandler<ActionEvent> eventForPreviousScreen = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String sport = theView.getSport();
				theView.setRightList(theModel.getRightSport(sport),true);

			}
		};
		// 2. attach this event to Previous Button pressed
		theView.addEventHandlerToPreviousButton(eventForPreviousScreen);
	}

}
