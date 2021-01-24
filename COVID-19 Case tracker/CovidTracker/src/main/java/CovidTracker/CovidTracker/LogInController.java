package CovidTracker.CovidTracker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.net.URL;





public class LogInController {
	
	@FXML
	private static String CurrentUserName;

	// declare the items
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
	private Button loginButtonn;
	@FXML
	private Label exitLabel;
	@FXML
	private AnchorPane anchorPane1;
	//@FXML
	//private Text txtDmsteam;
	//@FXML
	//private Text txtTitle;
	Parent root1;
	Stage stage;

	

	/*When login Button is pressed checks if the textfields are empty,
	 *if they are a message shows up,
	and if they are not proceed to the method validateLogin */

	@FXML
	public void loginButtonOnAcction(ActionEvent event) {
		CurrentUserName = usernameTextField.getText();
		if (usernameTextField.getText().isEmpty() && enterPasswordField.getText().isEmpty()) {
			loginMessageLabel.setText("Please insert your Username and Password");
		} else { 
			loginMessageLabel.setText("Please wait");
			if (validateLogin()) {
				loginButtonn.getScene().getWindow().hide();
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
					root1 = (Parent) fxmlLoader.load();
					stage = new Stage();
					stage.setScene(new Scene(root1));  
					stage.setResizable(false);
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**ExitButtonPressed method just gives the x button the permission to close the window */
	
	 @FXML
	 void exitButtonPressed(MouseEvent event) {
	    Stage stage = (Stage) exitLabel.getScene().getWindow();
	    stage.close();
	 }

	 /*validateLogin method makes a new database connection,
	  *then use sql code to check if the given username and password
	  *are the same with those in the database.After the verification a message shows
	  *up and inform the client about the verification status  */
	 @FXML
	 public boolean validateLogin() {
		 boolean flag = false;
			try {
				//Username is Primary Key so the following query returns 0 or 1
				JavaTable UserSearch = new JavaTable("SELECT COUNT(*) FROM Users WHERE Users.Username = '"
				+ usernameTextField.getText() + "'" );
				
				JavaTable PasswordSearch = new JavaTable("SELECT COUNT(*) FROM Users WHERE Users.Username = '"
						+ usernameTextField.getText() + "'AND Users.password = '" + enterPasswordField.getText() + "'");
				
				int UserExists = Integer.parseInt(UserSearch.getValueAt(0, 0));
				
				int LoginSuccess = Integer.parseInt(PasswordSearch.getValueAt(0, 0));
				
				if (UserExists == 0) {
					loginMessageLabel.setText("User does not exist");
				}
				else {
					
					if (LoginSuccess == 0) { 
						loginMessageLabel.setText("Incorrect Password");				
					}
					else {
						CurrentUserName = usernameTextField.getText();
						loginMessageLabel.setText("Welcome!");
						flag = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
	 }
	 @FXML
	 public static String getUsername() {
		 return CurrentUserName;
	 }
}
