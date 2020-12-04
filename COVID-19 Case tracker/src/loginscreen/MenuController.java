package loginscreen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane statsAnchor;

    @FXML
    private Circle deathsCircle;

    @FXML
    private Circle victimsCircle;

    @FXML
    private Circle recoveredCircle;

    @FXML
    private Text deathsTxt;

    @FXML
    private Text deathsNumTxt;

    @FXML
    private Text victimsTxt;

    @FXML
    private Text numVictimsTxt;

    @FXML
    private Text recoveredTxt;

    @FXML
    private Text recoveredNumTxt;

    @FXML
    private Text welcomeTxt;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private AnchorPane sideAnchor;

    @FXML
    private Button statsButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button updateButton;

    @FXML
    private ImageView statsView;

    @FXML
    private Separator sep2;

    @FXML
    private Separator sep1;

    @FXML
    private Separator sep3;

    @FXML
    private Separator sep4;

    @FXML
    private ImageView registerView;

    @FXML
    private Button helpButton;

    @FXML
    private ImageView infoView;

    @FXML
    private ImageView updateView;

    @FXML
    private ImageView helpView;

    @FXML
    void helpButtonOnAction(ActionEvent event) {
    
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manual.fxml"));
			Parent root2;
			root2 = (Parent) fxmlLoader.load();
			Stage stage3 = new Stage();
			stage3.setScene(new Scene(root2));  
			stage3.setResizable(false);
			stage3.initModality(Modality.APPLICATION_MODAL);
			stage3.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
}
