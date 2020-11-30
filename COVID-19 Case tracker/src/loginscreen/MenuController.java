package loginscreen;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class MenuController {

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private Circle deathsCircle;

    @FXML
    private Circle victimsCircle;

    @FXML
    private Circle recoveredCircle;

    @FXML
    private Text deathsTxt;

    @FXML
    private Text deathsNum;

    @FXML
    private Text victimsTxt;

    @FXML
    private Text victimsNum;

    @FXML
    private Text recoveredTxt;

    @FXML
    private Text recoveredNum;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private Button homeButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button editButton;

    @FXML
    private Text welcomeTxt;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private PieChart pieChart;

}


