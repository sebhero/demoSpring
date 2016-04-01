package sample.component;

import javafx.scene.control.TextArea;
import org.springframework.stereotype.Component;

/**
 * Created by Sebastian Börebäck on 2016-04-01.
 */

@Component
public class SentTextAreaComponent extends TextArea {

	public SentTextAreaComponent() {
		this.setEditable(false);
	}
}