package employee.view;

import java.io.IOException;

import employee.Main;
import javafx.fxml.FXML;

public class Logincontroller {
	
	private Main main;
	
	@FXML
	private void goMenu() throws IOException {
		main.goMenuScene();
		
	}

}
