package loginscreen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class InfoController implements Initializable {



    @FXML
    private Text title4;

    @FXML
    private Text author4;

    @FXML
    private Text date4;

    @FXML
    private Text title1;

    @FXML
    private Text author1;

    @FXML
    private Text date1;

    @FXML
    private Text title2;

    @FXML
    private Text author2;

    @FXML
    private Text date2;

    @FXML
    private Text title5;

    @FXML
    private Text author5;

    @FXML
    private Text date5;

    @FXML
    private Text title3;

    @FXML
    private Text author3;

    @FXML
    private Text date3;

    @FXML
    private Button nextButton;

    @FXML
    private Button prevButton;
    @FXML
    private BorderPane infoBorder;

    @FXML
    private Button overviewButton;

    @FXML
    private Button preventionButton;

    @FXML
    private Button symptomsButton;

    @FXML
    private Button newsroomButton;

    @FXML
    private Parent overview;
    @FXML
    private Parent prevention;
    @FXML
    private Parent symptoms;
    @FXML
    private Parent newsroom;

    int page = 0;

    @FXML
    private Parent loadScene(String sc) throws IOException {
        return FXMLLoader.load(getClass().getResource(sc));
    }

    @FXML
    public void overviewButtonOnAction(ActionEvent event) throws Exception {
        infoBorder.setCenter(overview);
    }
    
    @FXML
    void preventionButtonOnAction(ActionEvent event) {
    	infoBorder.setCenter(prevention);
    }
    
    @FXML
    public void symptomsButtonOnAction(ActionEvent event) throws Exception {
    	infoBorder.setCenter(symptoms);
    }

    @FXML
    public void newsroomButtonOnAction(ActionEvent event) throws Exception {
    	infoBorder.setCenter(newsroom);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            overview = loadScene("overview.fxml");
        	infoBorder.setCenter(overview);
            prevention = loadScene("prevention.fxml");
            symptoms = loadScene("symptoms.fxml");
            newsroom = loadScene("newsroom.fxml");
            //newsroomController nc = new newsroomController();
            //nc.newsInitialize();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
