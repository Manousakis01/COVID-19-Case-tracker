package loginscreen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SignOutController {
	
    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;
    
    @FXML
	void signOutDenied(ActionEvent event) {
	    noButton.getScene().getWindow().hide();
    }
    @FXML
    void signOutAccepted(ActionEvent event) {
    	Platform.exit();
    	System.exit(0);
    }

}
