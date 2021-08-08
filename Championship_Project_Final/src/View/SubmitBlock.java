package View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SubmitBlock extends Button {
	private Button submitButton;
	
	public SubmitBlock(String ntext, String nFontFamily, int nFontSize, Color nColor, HBox hb) {
		submitButton = new Button(ntext);
		submitButton.setFont(Font.font(nFontFamily, nFontSize));
		submitButton.setTextFill(nColor);
		hb.getChildren().add(submitButton);
		HBox.setMargin(submitButton, new Insets(10));
	}

	public SubmitBlock(String ntext, String nFontFamily, int nFontSize, Color nColor, VBox vb) {
		submitButton = new Button(ntext);
		submitButton.setFont(Font.font(nFontFamily, nFontSize));
		submitButton.setTextFill(nColor);
		vb.getChildren().add(submitButton);
		VBox.setMargin(submitButton, new Insets(10));
	}

	public SubmitBlock(String ntext, String nFontFamily, int nFontSize, Color nColor) {
		submitButton = new Button(ntext);
		submitButton.setFont(Font.font(nFontFamily, nFontSize));
		submitButton.setTextFill(nColor);
	}

	public Button getButton() {
		return submitButton;
	}
}
