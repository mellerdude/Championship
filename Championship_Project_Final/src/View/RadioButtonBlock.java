
package View;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RadioButtonBlock{
	private String fontFamily = "Tahoma";
	private Color color = Color.BLACK;
	private int fontSize = 16;
	private RadioButton rButton;
	
	
	public RadioButtonBlock(String ntext, String nFontFamily, int nFontSize, Color nColor, VBox vb, ToggleGroup tg) {
		rButton = new RadioButton(ntext);
		rButton.setFont(Font.font(nFontFamily,nFontSize));
		rButton.setTextFill(nColor);
		vb.getChildren().addAll(rButton);
		VBox.setMargin(rButton, new Insets(10));
		rButton.setToggleGroup(tg);
	}
	
	public RadioButtonBlock(String ntext, String nFontFamily, int nFontSize, Color nColor) {
		rButton = new RadioButton(ntext);
		rButton.setFont(Font.font(nFontFamily,nFontSize));
		rButton.setTextFill(nColor);
	}
	
	public RadioButtonBlock(String ntext) {
		rButton = new RadioButton(ntext);
		rButton.setFont(Font.font(fontFamily,fontSize));
		rButton.setTextFill(color);
	}
	
	public RadioButtonBlock(String ntext, String nFontFamily) {
		rButton = new RadioButton(ntext);
		rButton.setFont(Font.font(nFontFamily,fontSize));
		rButton.setTextFill(color);
	}
	
	public RadioButtonBlock(String ntext, Color nColor) {
		rButton = new RadioButton(ntext);
		rButton.setFont(Font.font(fontFamily,fontSize));
		rButton.setTextFill(nColor);
	}
	
	public RadioButton getButton() {
		return rButton;
	}
}
