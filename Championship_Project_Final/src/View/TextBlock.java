package View;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextBlock {
	private String fontFamily = "Tahoma";
	private Color color = Color.BLACK;
	private int fontSize = 16;
	private Text textBlock;
	
	public TextBlock(String ntext, String nFontFamily, int nFontSize, Color nColor, VBox vb) {
		textBlock = new Text(ntext);
		textBlock.setFont(Font.font(nFontFamily,nFontSize));
		textBlock.setFill(nColor);
		vb.getChildren().addAll(textBlock);
		VBox.setMargin(textBlock, new Insets(10));
	}
	
	public TextBlock(String ntext, String nFontFamily, int nFontSize, Color nColor, HBox hb) {
		textBlock = new Text(ntext);
		textBlock.setFont(Font.font(nFontFamily,nFontSize));
		textBlock.setFill(nColor);
		hb.getChildren().addAll(textBlock);
		HBox.setMargin(textBlock, new Insets(10));
	}
	
	public TextBlock(String ntext, String nFontFamily, int nFontSize, Color nColor) {
		textBlock = new Text(ntext);
		textBlock.setFont(Font.font(nFontFamily,nFontSize));
		textBlock.setFill(nColor);
	}
	
	public TextBlock(String ntext) {
		textBlock = new Text(ntext);
		textBlock.setFont(Font.font(fontFamily,fontSize));
		textBlock.setFill(color);
	}
	
	public TextBlock(String ntext, String nFontFamily) {
		textBlock = new Text(ntext);
		textBlock.setFont(Font.font(nFontFamily,fontSize));
		textBlock.setFill(color);
	}
	
	public TextBlock(String ntext, Color nColor) {
		textBlock = new Text(ntext);
		textBlock.setFont(Font.font(fontFamily,fontSize));
		textBlock.setFill(nColor);
	}
	
	public Text getText() {
		return textBlock;
	}
	public void setText(String txt) {
		textBlock.setText(txt);
	}
	
	
}
