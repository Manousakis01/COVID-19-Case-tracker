package loginscreen;

//import Email.SendEmail;
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
	
	ObservableList<String> prefecturetList = FXCollections.observableArrayList("Achaea", "Aetolia-Acarnania", "Arcadia", "Argolis", "Arta", "Athens"
			, "Boeotia"
			, "Cephalonia", "Chalkidiki", "Chania", "Chios", "Corfu", "Corinthia", "Cyclades"
			, "Dodecanese", "Drama"
			, "East Attica", "Elis", "Euboea", "Evros", "Evrytania"
			, "Florina"
			, "Grevena"
			, "Herakleion"
			, "Imathia", "Ioannina"
			, "Karditsa", "Kastoria", "Kavala", "Kilkis", "Kozani"
			, "Laconia", "Larissa", "Lasithi", "Lefkada", "Lesbos"
			, "Magnesia", "Messenia", "Mount Athos"
			, "Pella", "Phocis", "Phthiotis", "Pieria", "Piraeus", "Preveza"
			, "Rethymno", "Rhodope"
			, "Samos", "Serres"
			, "Thesprotia", "Thessaloniki", "Trikala" 
			, "West Attica"
			, "Xanthi"
			, "Zakynthos");
	
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
	private ChoiceBox PrefectureBox;
	
	@FXML
	private TextField PhoneTextField;
	
	@FXML
	private TextField MailTextField;
	
	@FXML
	private Label MessageLabel;
	
	@FXML
	private Label FirstNameLabel;
	
	@FXML
	private Label LastNameLabel;
	
	@FXML
	private Label SSNLabel;
	
	@FXML
	private Label BDateLabel;
	
	@FXML
	private Label TDateLabel;
	
	@FXML
	private Label PrefectureLabel;
	
	@FXML
	private Label PhoneLabel;
	
	@FXML
	private Label MailLabel;
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private TextField MailSendTextField;
	
	@FXML
	private Button MailSendButton;
	
	@FXML
	private Label MailSendLabel;
	
	
	
	
	@FXML
	private void initialize() {
		resultBox.setValue("Positive or Negative");
		resultBox.setItems(resultList);
		PrefectureBox.setValue("Select Prefecture");
		PrefectureBox.setItems(prefecturetList);
		
	}
	
	@FXML
	void RegisterButtonOnAction(ActionEvent event) {
		if (FullInfo()) {
			register();
			MessageLabel.setStyle("-fx-text-fill: white;");
			MessageLabel.setText("Case registered successfully");
		}
		else {
			MessageLabel.setStyle("-fx-text-fill: red;");
			MessageLabel.setText("Please enter all the Info");
		}
	
		}
	@FXML
	void MailSendButtonOnAction(ActionEvent event) throws Exception {
		if (MailSendTextField.getText().isEmpty()) {
			MailSendLabel.setText("Please enter an E-Mail address");
		}
		else {
			MailSendLabel.setText("Preparing to send E-mail");
			SendEmail.sendMail(MailSendTextField.getText());
			MailSendLabel.setText("Message sent succesfully");
		}
	}
	
	public boolean FullInfo() {
		if (FirstNameTextField.getText().isEmpty() || LastNameTextField.getText().isEmpty() 
				|| SSNTextField.getText().isEmpty() || BDatePicker.getValue() == null
						|| TDatePicker.getValue() == null || PrefectureBox.getValue() == "Select Prefecture"
								|| PhoneTextField.getText().isEmpty() || MailTextField.getText().isEmpty()
								|| resultBox.getValue() == "Positive or Negative") {
			if (FirstNameTextField.getText().isEmpty()) {
				FirstNameLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				FirstNameLabel.setStyle("-fx-text-fill: white;");
			}
			if (LastNameTextField.getText().isEmpty()) {
				LastNameLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				LastNameLabel.setStyle("-fx-text-fill: white;");
			}
			if (SSNTextField.getText().isEmpty()) {
				SSNLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				SSNLabel.setStyle("-fx-text-fill: white;");
			}
			if (BDatePicker.getValue() == null) {
				BDateLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				BDateLabel.setStyle("-fx-text-fill: white;");
			}
			if (TDatePicker.getValue() == null) {
				TDateLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				TDateLabel.setStyle("-fx-text-fill: white;");
			}
			if (PrefectureBox.getValue() == "Select Prefecture") {
				PrefectureLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				PrefectureLabel.setStyle("-fx-text-fill: white;");
			}
			if (PhoneTextField.getText().isEmpty()) {
				PhoneLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				PhoneLabel.setStyle("-fx-text-fill: white;");
			}
			if (MailTextField.getText().isEmpty()) {
				MailLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				MailLabel.setStyle("-fx-text-fill: white;");
			}
			if (resultBox.getValue() == "Positive or Negative") {
				resultLabel.setStyle("-fx-text-fill: red;");

			}
			else {
				resultLabel.setStyle("-fx-text-fill: white;");
			}
			return false;
		}
		else {
			FirstNameLabel.setStyle("-fx-text-fill: white;");
			LastNameLabel.setStyle("-fx-text-fill: white;");
			SSNLabel.setStyle("-fx-text-fill: white;");
			BDateLabel.setStyle("-fx-text-fill: white;");
			TDateLabel.setStyle("-fx-text-fill: white;");
			PrefectureLabel.setStyle("-fx-text-fill: white;");
			PhoneLabel.setStyle("-fx-text-fill: white;");
			MailLabel.setStyle("-fx-text-fill: white;");
			resultLabel.setStyle("-fx-text-fill: white;");
			return true;
		}
	}
	
	public void register() {
		InsertIntoTable Insert = new InsertIntoTable();
		if (resultBox.getValue() == "Negative") {
			
			Insert.Tested(SSNTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), BDatePicker.getValue().toString(), TDatePicker.getValue().toString() , PrefectureBox.getValue().toString(), MailTextField.getText(), PhoneTextField.getText());
		}
		else {
			Insert.Tested(SSNTextField.getText(), FirstNameTextField.getText(), LastNameTextField.getText(), BDatePicker.getValue().toString(), TDatePicker.getValue().toString() , PrefectureBox.getValue().toString(), MailTextField.getText(), PhoneTextField.getText());
			Insert.Positive(SSNTextField.getText());
		}
	}
}
