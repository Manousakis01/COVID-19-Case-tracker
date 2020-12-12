package loginscreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class MenuController implements Initializable{

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

    Parent root2;
    Stage stage1;
    @FXML
    private Parent register;
    private Parent update;

    @FXML
    void helpButtonOnAction(ActionEvent event) {

    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manual.fxml"));
			root2 = (Parent) fxmlLoader.load();
			stage1 = new Stage();
			stage1.setScene(new Scene(root2));  
			stage1.setResizable(false);
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    public void registerButtonOnAction(ActionEvent event) throws Exception {
        borderPane.setCenter(register);
    }
    
    @FXML
    public void updateButtonOnAction(ActionEvent event) throws Exception {
        borderPane.setCenter(update);
    }
  
    @FXML
    private Parent loadScene(String sc) throws IOException {
        return FXMLLoader.load(getClass().getResource(sc));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            register = loadScene("register.fxml");
            update = loadScene("update.fxml");
           // secondFxml =  loadScene("secondFxml.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        };
    }
    
}
