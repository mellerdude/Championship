package View;

import java.util.ArrayList;
import Model.Sport;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class View {
	private Stage mainStage;
	// Borders
	private BorderPane bp;
	private HBox hbTitle;
	private VBox vbLeft;
	private VBox vbCenter;
	private VBox vbRight;
	private HBox hbNameEnter;
	private HBox hbSubmitAction;
	// Right - Catagories
	private ToggleGroup tgCategory;
	private RadioButtonBlock CategoryTennis;
	private RadioButtonBlock CategoryBasketball;
	private RadioButtonBlock CategorySoccer;
	private boolean isTennisDisable;
	private boolean isBasketballDisable;
	private boolean isSoccerDisable;
	private int buttonPressedCount = 0;
	// Center - Main
	private TextFieldBlock enterName;
	private SubmitBlock add;
	private SubmitBlock Start;
	private final String simpleFont = "Tahoma"; 
	
	// Championship Chart
	private final String playText = "Play a game";

	private SubmitBlock quarterPlay1;
	private SubmitBlock quarterPlay2;
	private SubmitBlock quarterPlay3;
	private SubmitBlock quarterPlay4;
	private SubmitBlock semiPlay1;
	private SubmitBlock semiPlay2;
	private SubmitBlock finalePlay;
	private VBox quart1;
	private VBox quart2;
	private VBox quart3;
	private VBox quart4;
	private VBox semi1;
	private VBox semi2;
	private VBox finale;
	private HBox prevErea;
	private SubmitBlock previous;
	// Rectangles for participant names and play buttons parameters
	private final int WIDTH = 125;
	private final int HEIGHT = 40;
	private final int PLAYSIZEX = 120;
	private final int PLAYSIZEY = 40;
	private final int XTOP8 = 30;
	private final int YTOP8 = 100;
	private final int XSEMI = XTOP8 + 290;
	private final int YSEMI = YTOP8 + 35;
	private final int XFINALE = XTOP8 + 600;
	private final int YFINALE = YTOP8 + 105;

	// Game blocks
	private BorderPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private TextBlock gameTitle;
	private HBox gameTitleBox;
	private VBox matches;
	private HBox player1Matches;
	private HBox player2Matches;
	private HBox done;
	private SubmitBlock doneBlock;
	private TextFieldBlock player1match1;
	private TextFieldBlock player1match2;
	private TextFieldBlock player1match3;
	private TextFieldBlock player1match4;
	private TextFieldBlock player1match5;
	private TextFieldBlock player2match1;
	private TextFieldBlock player2match2;
	private TextFieldBlock player2match3;
	private TextFieldBlock player2match4;
	private TextFieldBlock player2match5;
	private TextBlock player1Name;
	private TextBlock player2Name;
	private Button pressedButton;
	private int pressedButtonNum;
	private final int widthOfInput = 40;
	private boolean visible = false;
	private boolean soccerMatchExtended = false;

	public View(Stage stage) {

		// Stage 1: Add Participants
		mainStage = stage;
		// Create Borders
		bp = new BorderPane();
		hbTitle = new HBox();
		vbLeft = new VBox();
		vbCenter = new VBox();
		vbRight = new VBox();
		hbNameEnter = new HBox();
		hbSubmitAction = new HBox();
		// Title
		hbTitle.setAlignment(Pos.CENTER);
		TextBlock Title = new TextBlock("Championship", "Times-new-roman", 46, Color.BLUE, hbTitle);
		Title.getText().setStyle("-fx-font-weight: bold");
		Title.getText().setStroke(Color.BLACK);
		// Create Right - Categories
		vbRight.setAlignment(Pos.CENTER_LEFT);
		tgCategory = new ToggleGroup();
		CategoryTennis = new RadioButtonBlock("Tennis", simpleFont, 20, Color.BLACK, vbRight, tgCategory);
		CategoryBasketball = new RadioButtonBlock("Basketball", simpleFont, 20, Color.BLACK, vbRight, tgCategory);
		CategorySoccer = new RadioButtonBlock("Soccer", simpleFont, 20, Color.BLACK, vbRight, tgCategory);
		CategoryTennis.getButton().setSelected(true);
		isTennisDisable = false;
		isBasketballDisable = false;
		isSoccerDisable = false;

		// Create Center - Main
		vbCenter.setAlignment(Pos.CENTER);

		TextBlock pName = new TextBlock("Enter participant name:", simpleFont, 16, Color.BLACK, hbNameEnter);
		enterName = new TextFieldBlock(hbNameEnter, 120);

		add = new SubmitBlock("Add participant", simpleFont, 16, Color.DARKMAGENTA, hbSubmitAction);
		Start = new SubmitBlock("Start Championship", simpleFont, 16, Color.DARKMAGENTA, hbSubmitAction);
		Start.getButton().setVisible(false);

		hbNameEnter.setAlignment(Pos.CENTER);
		hbSubmitAction.setAlignment(Pos.CENTER);
		vbCenter.getChildren().addAll(hbNameEnter, hbSubmitAction);

		// Left - Participants
		vbLeft.setAlignment(Pos.BASELINE_LEFT);

		// Stage 2: Championship
		quart1 = new VBox();
		quart2 = new VBox();
		quart3 = new VBox();
		quart4 = new VBox();
		semi1 = new VBox();
		semi2 = new VBox();
		finale = new VBox();
		prevErea = new HBox();
		quarterPlay1 = new SubmitBlock(playText, simpleFont, 16, Color.BLACK, quart1);
		quart1.setLayoutX(XTOP8 + WIDTH + 10);
		quart1.setLayoutY(YTOP8 + 25);
		quarterPlay1.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);
		quarterPlay2 = new SubmitBlock(playText, simpleFont, 16, Color.BLACK, quart2);
		quart2.setLayoutX(XTOP8 + WIDTH + 10);
		quart2.setLayoutY(YTOP8 + 25 + 70 * 2);
		quarterPlay2.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);
		quarterPlay3 = new SubmitBlock(playText, simpleFont, 16, Color.BLACK, quart3);
		quart3.setLayoutX(XTOP8 + WIDTH + 10);
		quart3.setLayoutY(YTOP8 + 25 + 70 * 4);
		quarterPlay3.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);
		quarterPlay4 = new SubmitBlock(playText, simpleFont, 16, Color.BLACK, quart4);
		quart4.setLayoutX(XTOP8 + WIDTH + 10);
		quart4.setLayoutY(YTOP8 + 25 + 70 * 6);
		quarterPlay4.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);

		semiPlay1 = new SubmitBlock(playText, simpleFont, 16, Color.BLACK, semi1);
		semi1.setLayoutX(XSEMI + WIDTH + 20);
		semi1.setLayoutY(YSEMI + 60);
		semiPlay1.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);
		semiPlay2 = new SubmitBlock(playText, simpleFont, 16, Color.BLACK, semi2);
		semi2.setLayoutX(XSEMI + WIDTH + 20);
		semi2.setLayoutY(YSEMI + 60 + 70 * 4);
		semiPlay2.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);

		finalePlay = new SubmitBlock(playText, simpleFont, 16, Color.BLACK, finale);
		finale.setLayoutX(XFINALE);
		finale.setLayoutY(YFINALE + 120);
		finalePlay.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);

		previous = new SubmitBlock("previous", simpleFont, 16, Color.DARKMAGENTA, prevErea);
		prevErea.setLayoutX(850);
		prevErea.setLayoutY(600);
		previous.getButton().setMinSize(PLAYSIZEX, PLAYSIZEY);

		// Stage 3: Game
		gamePane = new BorderPane();
		gameScene = new Scene(gamePane, 400, 400);
		gameStage = new Stage();
		done = new HBox();
		doneBlock = new SubmitBlock("Done", simpleFont, 16, Color.BLACK, done);
		matches = new VBox();
		player1Matches = new HBox();
		player2Matches = new HBox();
		gameTitleBox = new HBox();
		player1Name = new TextBlock("", simpleFont, 14, Color.BLUE);
		player2Name = new TextBlock("", simpleFont, 14, Color.RED);
		pressedButton = new Button();
		// Border Alignments
		setBorderAlignment();
		bp.setStyle("-fx-background-color:LIGHTSKYBLUE");

		Scene scene = new Scene(bp, 1024, 680);
		mainStage.setScene(scene);
		mainStage.show();
	}

	//
	public void setBorderAlignment() {
		bp.setLeft(vbLeft);
		bp.setCenter(vbCenter);
		bp.setRight(vbRight);
		bp.setTop(hbTitle);
	}

	// get the selected Sport
	public String getSport() {
		if (CategoryTennis.getButton().isSelected()) {
			return CategoryTennis.getButton().getText();
		} else if (CategoryBasketball.getButton().isSelected())
			return CategoryBasketball.getButton().getText();
		else
			return CategorySoccer.getButton().getText();
	}

	// show the right list according to the selected sport
	public void setRightList(Sport sport, boolean ifPreviosPressed) {
		bp.getChildren().clear();
		setBorderAlignment();
		if (!ifPreviosPressed) {
			drawNames(sport);
		} else {
			switch (sport.getType()) {
			case "Tennis":
				CategoryTennis.getButton().setDisable(true);
				isTennisDisable = true;
				break;
			case "Basketball":
				CategoryBasketball.getButton().setDisable(true);
				isBasketballDisable = true;
				break;
			case "Soccer":
				CategorySoccer.getButton().setDisable(true);
				isSoccerDisable = true;
				break;
			}
		}
		if (isTennisDisable && isBasketballDisable && isSoccerDisable) {
			closeGame();
		}

	}

	public void drawNames(Sport sport) {
		ArrayList<String> listOfParticipant;
		listOfParticipant = sport.getListOfParti();
		checkParticipant(sport);
		for (int i = 0; i < listOfParticipant.size(); i++) {
			String name = listOfParticipant.get(i);
			TextBlock pNew = new TextBlock(name, simpleFont, 16, Color.BLACK);
			Rectangle r = new Rectangle(XTOP8, YTOP8 + (i * 70), WIDTH, HEIGHT);
			r.setFill(Color.AQUAMARINE);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(3);
			pNew.getText().setLayoutX(XTOP8 + 5);
			pNew.getText().setLayoutY((YTOP8 + (i * 70)) + 25);
			bp.getChildren().addAll(r, pNew.getText());
		}

	}

	// add the Participant to the right List
		public void addToList(Sport sport) {
			String newParti = getParticiName();
			enterName.getTextField().clear();
			// add participant to the right list
			// write the participant's name on the left screen
			if (newParti.equalsIgnoreCase("No-name-"))
				sport.getListOfParti().add(newParti + (sport.getListOfParti().size() + 1));
			else
				sport.getListOfParti().add(newParti);
			drawNames(sport);

		}

	// check if all participants' are added
	// if true --> add button disappear & start button appear
	// if false --> add button appear & start button disappear
	public void checkParticipant(Sport sport) {
		if (sport.getListOfParti().size() == 8) {
			add.getButton().setVisible(false);
			enterName.getTextField().setDisable(true);
			Start.getButton().setVisible(true);
		} else {
			add.getButton().setVisible(true);
			Start.getButton().setVisible(false);
			enterName.getTextField().setDisable(false);
		}
	}

	// Stage 2: Championship
	public void StartChampionship(Sport sport) {
		previous.getButton().setVisible(false);
		bp.getChildren().clear();
		bp.setTop(hbTitle);

		String playerName;

		boolean down = true;

		// Create Top 8 finals
		for (int i = 0; i < 8; i++) {
			Rectangle r = new Rectangle(XTOP8, YTOP8 + (i * 70), WIDTH, HEIGHT);
			Line connector;
			r.setFill(Color.AQUAMARINE);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(3);

			TextBlock Name = new TextBlock(sport.getListOfParti().get(i), simpleFont, 16, Color.BLACK);
			Name.getText().setLayoutX(XTOP8 + 5);
			Name.getText().setLayoutY((YTOP8 + (i * 70)) + 25);

			// create lines and play button
			Line toPlayLine = new Line(XTOP8 + WIDTH + 10, YTOP8 + (i * 70) + 20, XTOP8 + WIDTH + 80,
					YTOP8 + (i * 70) + 20);
			if (down == false) {
				connector = new Line(XTOP8 + WIDTH + 80, YTOP8 + (i * 70) + 20, XTOP8 + WIDTH + 80,
						(YTOP8 + (i * 70) + 20) - 10);
				down = true;
				bp.getChildren().addAll(r, toPlayLine, connector, Name.getText());
			} else {
				Line toWinner = new Line(XTOP8 + WIDTH + 10 + PLAYSIZEX, YTOP8 + (i * 70) + 55,
						XTOP8 + WIDTH + 10 + PLAYSIZEX + 30, YTOP8 + (i * 70) + 55);
				connector = new Line(XTOP8 + WIDTH + 80, YTOP8 + (i * 70) + 20, XTOP8 + WIDTH + 80,
						(YTOP8 + (i * 70) + 20) + 10);
				down = false;
				bp.getChildren().addAll(r, toPlayLine, toWinner, connector, Name.getText());
			}

		}
		// Create semi-finals
		for (int i = 0; i < 4; i++) {
			Rectangle r = new Rectangle(XSEMI, YSEMI + (i * 140), WIDTH, HEIGHT);
			Line connector;
			r.setFill(Color.AQUAMARINE);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(3);

			playerName = "";
			if (sport.getListOf4Best().get(i).equalsIgnoreCase(""))
				playerName = " No winner yet";
			else
				playerName = sport.getListOf4Best().get(i).toString();
			TextBlock Name = new TextBlock(playerName, simpleFont, 16, Color.BLACK);
			Name.getText().setLayoutX(XSEMI + 5);
			Name.getText().setLayoutY((YSEMI + (i * 140)) + 25);

			// create lines and play button
			Line toPlayLine = new Line(XSEMI + WIDTH + 10, YSEMI + (i * 140) + 20, XSEMI + WIDTH + 80,
					YSEMI + (i * 140) + 20);
			Line toWinner = new Line(XSEMI + WIDTH + 30 + PLAYSIZEX, YSEMI + (i * 140) + 90,
					XSEMI + WIDTH + 30 + PLAYSIZEX + 30, YSEMI + (i * 140) + 90);
			if (down == false) {
				connector = new Line(XSEMI + WIDTH + 80, YSEMI + (i * 140) + 20, XSEMI + WIDTH + 80,
						(YSEMI + (i * 140) + 20) - 40);
				down = true;
				bp.getChildren().addAll(r, toPlayLine, connector, Name.getText());
			} else {
				connector = new Line(XSEMI + WIDTH + 80, YSEMI + (i * 140) + 20, XSEMI + WIDTH + 80,
						(YSEMI + (i * 140) + 20) + 40);
				down = false;
				bp.getChildren().addAll(r, toPlayLine, toWinner, connector, Name.getText());
			}

		}

		// create finale
		for (int i = 0; i < 2; i++) {
			Rectangle r = new Rectangle(XFINALE, YFINALE + (i * 280), WIDTH, HEIGHT);
			Line connector;
			r.setFill(Color.AQUAMARINE);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(3);
			playerName = "";
			if (sport.getListOfFinals().get(i).equalsIgnoreCase(""))
				playerName = " No winner yet";
			else
				playerName = sport.getListOfFinals().get(i).toString();
			TextBlock Name = new TextBlock(playerName, simpleFont, 16, Color.BLACK);
			Name.getText().setLayoutX(XFINALE + 5);
			Name.getText().setLayoutY((YFINALE + (i * 280)) + 25);

			// create lines and play button
			Line toWinner = new Line(XFINALE + WIDTH, YFINALE + 150, XFINALE + WIDTH + 60, YFINALE + 150);
			if (down == false) {
				connector = new Line(XFINALE + WIDTH / 2, YFINALE + (i * 280), XFINALE + WIDTH / 2,
						YFINALE + (i * 280) - 110);
				down = true;
				bp.getChildren().addAll(r, connector, Name.getText());
			} else {
				connector = new Line(XFINALE + WIDTH / 2, YFINALE + (i * 280) + 40, XFINALE + WIDTH / 2,
						YFINALE + (i * 280) + 40 + 100);
				down = false;
				bp.getChildren().addAll(r, connector, toWinner, Name.getText());
			}
		}
		// Winner
		String winner = sport.getWinner();
		playerName = "";
		if (winner.equalsIgnoreCase(""))
			playerName = " No winner yet";
		else
			playerName = winner;
		Rectangle r = new Rectangle(XFINALE + WIDTH + 60, YFINALE + 130, WIDTH, HEIGHT);
		r.setFill(Color.GOLD);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(3);

		TextBlock Name = new TextBlock(playerName, simpleFont, 16, Color.BLACK);
		Name.getText().setLayoutX(XFINALE + WIDTH + 60 + 5);
		Name.getText().setLayoutY(YFINALE + 130 + 25);
		previous.getButton().setLayoutX(Name.getText().getLayoutX());
		previous.getButton().setLayoutY(Name.getText().getLayoutY());
		bp.getChildren().addAll(quart1, quart2, quart3, quart4, semi1, semi2, finale, r, Name.getText(), prevErea);
	}

	public void startGame(Sport sport, int place, String phase) {// change box sizes
		if (phase.equalsIgnoreCase("Top8")) {
			player1Name.setText(sport.getListOfParti().get(place));
			player2Name.setText(sport.getListOfParti().get(place + 1));
		} else if (phase.equalsIgnoreCase("Top4")) {
			player1Name.setText(sport.getListOf4Best().get(place));
			player2Name.setText(sport.getListOf4Best().get(place + 1));

		} else {
			player1Name.setText(sport.getListOfFinals().get(place));
			player2Name.setText(sport.getListOfFinals().get(place + 1));
		}
		gameTitle = new TextBlock(sport.getType(), simpleFont, 28, Color.PURPLE, gameTitleBox);
		gameTitleBox.setAlignment(Pos.TOP_CENTER);
		gamePane.setTop(gameTitleBox);
		done.setAlignment(Pos.BOTTOM_CENTER);
		gamePane.setBottom(done);
		matches.getChildren().addAll(player1Matches, player2Matches);
		setLittleGames(sport);
		gamePane.setCenter(matches);
		BorderPane.setMargin(matches, new Insets(100, 0, 0, 0));
		gameStage.setScene(gameScene);
		gameStage.show();
	}

	public void setLittleGames(Sport sport) {
		player1Matches.getChildren().add(player1Name.getText());
		player1Name.getText().setWrappingWidth(70);
		player2Matches.getChildren().add(player2Name.getText());
		player2Name.getText().setWrappingWidth(70);
		HBox.setMargin(player1Name.getText(), new Insets(10));
		HBox.setMargin(player2Name.getText(), new Insets(10));
		if (sport.getType().equalsIgnoreCase("Tennis")) {
			player1match1 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match2 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match3 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match4 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match4.getTextField().setVisible(false);
			player1match5 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match5.getTextField().setVisible(false);
			player2match1 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match2 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match3 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match4 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match4.getTextField().setVisible(false);
			player2match5 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match5.getTextField().setVisible(false);
		} else if (sport.getType().equalsIgnoreCase("Basketball")) {
			player1match1 = new TextFieldBlock(player1Matches, widthOfInput);

			player1match2 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match3 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match4 = new TextFieldBlock(player1Matches, widthOfInput);
			player2match1 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match2 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match3 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match4 = new TextFieldBlock(player2Matches, widthOfInput);
		} else {
			player1match1 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match2 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match3 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match3.getTextField().setVisible(false);
			player1match4 = new TextFieldBlock(player1Matches, widthOfInput);
			player1match4.getTextField().setVisible(false);
			player2match1 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match2 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match3 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match3.getTextField().setVisible(false);
			player2match4 = new TextFieldBlock(player2Matches, widthOfInput);
			player2match4.getTextField().setVisible(false);
		}
	}

	public void makeMoreMatches(String sport) {
		setVisible(true);
		if (sport.equalsIgnoreCase("Tennis")) {
			player1match4.getTextField().setVisible(true);
			player1match5.getTextField().setVisible(true);
			player2match4.getTextField().setVisible(true);
			player2match5.getTextField().setVisible(true);
		} else {
			if (sport.equalsIgnoreCase("Soccer1")) {
				player1match3.getTextField().setVisible(true);
				player2match3.getTextField().setVisible(true);
			} else {
				player1match4.getTextField().setVisible(true);
				player2match4.getTextField().setVisible(true);
			}
		}
	}

	//when first 4 games end the other 2 can be played
	public void enableTop4Button() {
		if (quarterPlay1.getButton().isDisable() && quarterPlay2.getButton().isDisable()
				&& quarterPlay3.getButton().isDisable() && quarterPlay4.getButton().isDisable()) {
			semiPlay1.getButton().setDisable(false);
			semiPlay2.getButton().setDisable(false);
		}
	}
	
	//when middle 2 games end the final game can be played
	public void enableFinaleButton() {
		if (semiPlay1.getButton().isDisable() && semiPlay2.getButton().isDisable()) {
			finalePlay.getButton().setDisable(false);
		}
	}

	//when tournament end previous button show up 
	//and we can choose other sport to do tournament
	public void showPrevious() {
		previous.getButton().setVisible(true);
		if(buttonPressedCount == 3) {
			//when all 3 sport chosen previous cange to end game
			previous.getButton().setText("END GAME");
		}
	}

	//when tournament start we enable the 4 first games and disable the rest
	public void disableButton() {
		quarterPlay1.getButton().setDisable(false);
		quarterPlay2.getButton().setDisable(false);
		quarterPlay3.getButton().setDisable(false);
		quarterPlay4.getButton().setDisable(false);
		semiPlay1.getButton().setDisable(true);
		semiPlay2.getButton().setDisable(true);
		finalePlay.getButton().setDisable(true);
	}

	//when done is pressed and there is a winner the little games window is closed
	public void closeWindow() {
		player2Matches.getChildren().clear();
		player1Matches.getChildren().clear();
		gamePane.getChildren().clear();
		gameTitleBox.getChildren().clear();
		matches.getChildren().clear();
		pressedButton.setDisable(true);
		gameStage.close();
	}

	//close the main program
	public void closeGame() {
		mainStage.close();
	}
	
	// get the Participant's Name
		public String getParticiName() {
			if (enterName.getTextField().getText().equalsIgnoreCase(""))
				return "No-name-";

			else
				return enterName.getTextField().getText();
		}
	
	//set the pressed button so we can know which one to disable
	public void setPressedButton(int numButton) {
		switch (numButton) {
		case 1:
			pressedButton = quarterPlay1.getButton();
			break;
		case 2:
			pressedButton = quarterPlay2.getButton();
			break;
		case 3:
			pressedButton = quarterPlay3.getButton();
			break;
		case 4:
			pressedButton = quarterPlay4.getButton();
			break;
		case 5:
			pressedButton = semiPlay1.getButton();
			break;
		case 6:
			pressedButton = semiPlay2.getButton();
			break;
		case 7:
			pressedButton = finalePlay.getButton();
			break;
		}
		pressedButtonNum = numButton;
	}

	public int getPlayer1match1() {
		return Integer.parseInt(player1match1.getTextField().getText());
	}

	public int getPlayer2match1() {
		return Integer.parseInt(player2match1.getTextField().getText());
	}

	public int getPlayer1match2() {
		return Integer.parseInt(player1match2.getTextField().getText());
	}

	public int getPlayer2match2() {
		return Integer.parseInt(player2match2.getTextField().getText());
	}

	public int getPlayer1match3() {
		return Integer.parseInt(player1match3.getTextField().getText());
	}

	public int getPlayer2match3() {
		return Integer.parseInt(player2match3.getTextField().getText());
	}

	public int getPlayer1match4() {
		return Integer.parseInt(player1match4.getTextField().getText());
	}

	public int getPlayer2match4() {
		return Integer.parseInt(player2match4.getTextField().getText());
	}

	public int getPlayer1match5() {
		return Integer.parseInt(player1match5.getTextField().getText());
	}

	public int getPlayer2match5() {
		return Integer.parseInt(player2match5.getTextField().getText());
	}

	public int getPressedButtonNum() {
		return pressedButtonNum;
	}

	public void setButtonCount() {
		buttonPressedCount++;
	}

	public boolean getSoccerMatchExtended() {
		return soccerMatchExtended;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	// add event listener to the toggle group
	public void addChangeListenerToToggleGroup(ChangeListener<Toggle> listener) {
		tgCategory.selectedToggleProperty().addListener(listener);
	}

	// add event to the add participant
	public void addEventHandlerToAddParticipant(EventHandler<ActionEvent> event) {
		add.getButton().setOnAction(event);
	}

	//add event to the start championship 
	public void addEventHandlerToStartChampionship(EventHandler<ActionEvent> event) {
		Start.getButton().setOnAction(event);
	}

	//add event to Top8Game1
	public void addEventHandlerToStartTop8Game1(EventHandler<ActionEvent> event) {
		quarterPlay1.getButton().setOnAction(event);
	}

	//add event to Top8Game2
	public void addEventHandlerToStartTop8Game2(EventHandler<ActionEvent> event) {
		quarterPlay2.getButton().setOnAction(event);
	}

	//add event to Top8Game3
	public void addEventHandlerToStartTop8Game3(EventHandler<ActionEvent> event) {
		quarterPlay3.getButton().setOnAction(event);
	}

	//add event to Top8Game4
	public void addEventHandlerToStartTop8Game4(EventHandler<ActionEvent> event) {
		quarterPlay4.getButton().setOnAction(event);
	}

	//add event to Top4Game1
	public void addEventHandlerToStartTop4Game1(EventHandler<ActionEvent> event) {
		semiPlay1.getButton().setOnAction(event);

	}

	//add event to Top4Game2
	public void addEventHandlerToStartTop4Game2(EventHandler<ActionEvent> event) {
		semiPlay2.getButton().setOnAction(event);

	}

	//add event to FinalGame
	public void addEventHandlerToStartFinals(EventHandler<ActionEvent> event) {
		finalePlay.getButton().setOnAction(event);

	}

	//add event to done button
	public void addEventHandlerToDoneButton(EventHandler<ActionEvent> event) {
		doneBlock.getButton().setOnAction(event);
	}

	//add event to previous button
	public void addEventHandlerToPreviousButton(EventHandler<ActionEvent> event) {
		previous.getButton().setOnAction(event);
	}

}
