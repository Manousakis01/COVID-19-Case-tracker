package loginscreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LogInController {
	
	 @FXML
	 private Label exitLabel;
	    

	 @FXML
	 void exitButtonPressed(MouseEvent event) {
	    Stage stage = (Stage) exitLabel.getScene().getWindow();
	    stage.close();
	 }
}

