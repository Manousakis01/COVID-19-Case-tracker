package loginscreen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.net.URL;





public class LogInController {

	@FXML
	private Label loginMessageLabel;
	@FXML
	private ImageView brandingImageView;
	@FXML
	private ImageView faceImageView;
	@FXML
	private ImageView lockImageView;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField enterPasswordField;
	@FXML
	private Button loginButttonn;
	@FXML
	private Label exitLabel;

	public void loginButtonOnAcction(ActionEvent event) {
		if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false) {
			validateLogin();
		} else {
			loginMessageLabel.setText("Please insert your Username and Password");
		}
		try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();
		} catch (Exception e) {
			System.out.println("Can't load new window!");
		}
	}

	 @FXML
	 void exitButtonPressed(MouseEvent event) {
	    Stage stage = (Stage) exitLabel.getScene().getWindow();
	    stage.close();
	 }
	  

	 public void validateLogin() {
			DatabaseConnectionWithLogScr connectNow = new DatabaseConnectionWithLogScr();
			Connection connectDB = connectNow.getConnection();
			// Verification.
			String verifyLogin = "SELECT username, password FROM useracc WHERE username =  '" + usernameTextField.getText() + "' AND password ='" + enterPasswordField.getText() + " ' ";

			try {

				Statement statement = connectDB.createStatement();
				ResultSet queryResult = statement.executeQuery(verifyLogin);
				//If query result is not empty means that user passed verification.
				if (queryResult.next()) {
					loginMessageLabel.setText("Congratulations!");
				} else {
					loginMessageLabel.setText("Invalid login. Please try again.");
				}

			} catch (Exception e) {
				e.printStackTrace();
				e.getCause();
			}
	 }

}
