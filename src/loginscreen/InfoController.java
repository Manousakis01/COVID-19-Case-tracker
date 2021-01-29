package loginscreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;


public class InfoController implements Initializable {




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
            newsroom = loadScene("newsroom.fxml");
        	infoBorder.setCenter(newsroom);
            prevention = loadScene("prevention.fxml");
            symptoms = loadScene("symptoms.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
