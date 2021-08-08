
package View;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TextFieldBlock{
	private TextField tf;

	public TextFieldBlock(HBox hb, int j) {
		tf = new TextField();
		hb.getChildren().addAll(tf);
		tf.setMinWidth(j);
		tf.setMaxWidth(j);
		HBox.setMargin(tf, new Insets(10));

	}
	
	public TextField getTextField() {
		return tf;
	}
	
	
}

