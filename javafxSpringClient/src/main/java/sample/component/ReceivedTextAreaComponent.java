package sample.component;

import javafx.scene.control.TextArea;
import org.springframework.stereotype.Component;

/**
 * Created by Sebastian Börebäck on 2016-04-01.
 */

@Component
public class ReceivedTextAreaComponent extends TextArea {

	public ReceivedTextAreaComponent() {
		this.setEditable(false);
	}
}