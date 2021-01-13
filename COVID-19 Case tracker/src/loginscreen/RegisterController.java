package loginscreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
	private TextField LastNameTextField;
	
	@FXML
	private TextField SSNTextField;
	
	@FXML
	private DatePicker BDatePicker;
	
	@FXML
	private DatePicker TDatePicker;
	
	@FXML
	private TextField PrefectureTextField;
	
	@FXML
	private TextField PhoneTextField;
	
	@FXML
	private TextField MailTextField;
	
	@FXML
	private Label MessageLabel;
	
	
	
	@FXML
	private void initialize() {
		resultBox.setValue("Positive or Negative");
		resultBox.setItems(resultList);
		
	}
	
	@FXML
	void RegisterButtonOnAction(ActionEvent event) {
		if (FullInfo()) {
			register();
			MessageLabel.setText("Case registered successfully");
		}
		else {
			MessageLabel.setText("Please enter all the Info");
		}
	
		}
	
	public boolean FullInfo() {
		if (FirstNameTextField.getText().isEmpty() || LastNameTextField.getText().isEmpty() 
				|| SSNTextField.getText().isEmpty() || BDatePicker.getValue() == null
						|| TDatePicker.getValue() == null || PrefectureTextField.getText().isEmpty()
								|| PhoneTextField.getText().isEmpty() || MailTextField.getText().isEmpty()
								|| resultBox.getValue() == "Positive or Negative") {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void register() {
		InsertIntoTables Insert = new InsertIntoTables();
		if (resultBox.getValue() == "Negative") {
			
			Insert.addTested(SSNTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), BDatePicker.getValue().toString(), TDatePicker.getValue().toString() , PrefectureTextField.getText(), MailTextField.getText(), PhoneTextField.getText());
		}
		else {
			Insert.addTested(SSNTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), BDatePicker.getValue().toString(), TDatePicker.getValue().toString() , PrefectureTextField.getText(), MailTextField.getText(), PhoneTextField.getText());
			Insert.addPositive(SSNTextField.getText());
		}
	}
}
