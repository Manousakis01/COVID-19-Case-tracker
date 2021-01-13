package loginscreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController {
	
	ObservableList<String> resultList = FXCollections.observableArrayList("Positive","Negative");
	
	@FXML
	private ChoiceBox resultBox;
	
	@FXML
	private Button RegisterButton;
	
	@FXML
	private TextField FirstNameTextField;
	
	@FXML
	private Label FirstNameLabel;
	
	
	@FXML
	private void initialize() {
		resultBox.setValue("Positive or Negative");
		resultBox.setItems(resultList);
		
	}
	
	@FXML
	void RegisterButtonOnAction(ActionEvent event) {
		System.out.println(resultBox.getValue());
	}
}
