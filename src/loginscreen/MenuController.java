package loginscreen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
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
    private Text tcasesTxt;
    
    @FXML
    private Text trecoveredTxt;
    
    @FXML
    private Text tdeathsTxt;
    
    @FXML
    private Text UsernameText;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private PieChart pieChart;

    Stage stage2;
    
    Parent root2;
   
	Stage stage1;
    
    @FXML
    private Parent register;
    @FXML
    private Parent update;

    private ObservableList data;

    // getting the number of positive cases
    public void positiveText() {
    	try {
			JavaTable jv1 = new JavaTable("SELECT count(*) FROM Positive");
			String kl1 = jv1.getValueAt(jv1.getRowCount()-1, jv1.getColumnCount()-1);
			numVictimsTxt.setText(kl1);
			jv1.setQuery("SELECT COUNT(Positive.SSN) "
					+ "FROM Tested, Positive "
					+ "WHERE Positive.SSN = Tested.SSN AND DATEDIFF(SYSDATE(), Tested.dateOfTest) = 0 ");
			String kp1 = jv1.getValueAt(jv1.getRowCount()-1, jv1.getColumnCount()-1);
			tcasesTxt.setText("(+"+kp1+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //getting the number of deaths
    public void deathsText() {
    	try {
			JavaTable jv2 = new JavaTable("SELECT count(*) FROM Death");
			String kl2 = jv2.getValueAt(jv2.getRowCount()-1, jv2.getColumnCount()-1);
			deathsNumTxt.setText(kl2);
			jv2.setQuery("SELECT COUNT(Death.SSN) "
					+ "FROM Tested, Death "
					+ "WHERE Death.SSN = Tested.SSN AND DATEDIFF(SYSDATE(), Death.dateOfDeath) = 0");
			String kp2 = jv2.getValueAt(jv2.getRowCount()-1, jv2.getColumnCount()-1);
			tdeathsTxt.setText("(+"+kp2+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //getting the number of recovered people
    public void recoveredText() {
    	try {
			JavaTable jv3 = new JavaTable("SELECT count(*) FROM Healed");
			String kl3 = jv3.getValueAt(jv3.getRowCount()-1, jv3.getColumnCount()-1);
			recoveredNumTxt.setText(kl3);
			jv3.setQuery("SELECT COUNT(Healed.SSN) "
					+ "FROM Tested, Healed "
					+ "WHERE Healed.SSN = Tested.SSN AND DATEDIFF(SYSDATE(), Healed.dateOfHealed) = 0");
			String kp3 = jv3.getValueAt(jv3.getRowCount()-1, jv3.getColumnCount()-1);
			trecoveredTxt.setText("(+"+kp3+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void barChart() {
    	try {
			JavaTable jv4 = new JavaTable("SELECT Tested.dateOfTest, COUNT(Tested.SSN) "
					+ "FROM Tested, Positive "
					+ "WHERE Positive.SSN = Tested.SSN AND DATEDIFF(SYSDATE(), Tested.dateOfTest) <= 90 "
					+ "GROUP BY Tested.dateOfTest "
					+ "ORDER BY Tested.dateOfTest");
			XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
			ResultSet rs = jv4.getResultSet();
			do {
				series.getData().add(new Data<String, Integer>(rs.getString(1) + " (" + rs.getInt(2) + ")", rs.getInt(2)));
			} while(rs.next());
			barChart.getData().add(series);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void pieChart() {
    	try {
			JavaTable jv5 = new JavaTable("SELECT COUNT(Meth.SSN) FROM Meth");
			data = FXCollections.observableArrayList();
			ResultSet rs2 =jv5.getResultSet();
			data.add(new PieChart.Data("Available",200));
			do {
				data.add(new PieChart.Data("In use",rs2.getDouble(1)));
				
				
			} while(rs2.next());
			pieChart.getData().addAll(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  
    @FXML
    public void signOutButtonOnAction(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignOut.fxml"));
			root2 = (Parent) fxmlLoader.load();
			stage2 = new Stage();
			stage2.setScene(new Scene(root2));  
			stage2.setResizable(false);
			stage2.initModality(Modality.APPLICATION_MODAL);
			stage2.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    protected void helpButtonOnAction(ActionEvent event) {
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
    void statsButtonOnAction(ActionEvent event) {
    	 borderPane.setCenter(statsAnchor);
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
            update = loadScene("update2.fxml");
            positiveText();
            deathsText();
            recoveredText();
            barChart();
            pieChart();
           // LogInController log1 = new LogInController();
            UsernameText.setText(LogInController.getUsername());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
