package loginscreen;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class newsroomController {

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

    private int page = 0;

    List<String> titleList = new ArrayList<String>();
    List<String> urlList = new ArrayList<String>();
    List<String> dateList = new ArrayList<String>();

    @FXML
    void prevButtonOnAction(ActionEvent event) {
    	if(page - 5 < 0) {
    		page = 0;
    	} else {
    		page = page - 5;
    	}
    	setArticles(page);
    }

    @FXML
    void nextButtonOnAction(ActionEvent event) {
    	if(page + 5 < 45) {
    		page = 0;
    	}
    	setArticles(page);
    }

     void setArticles(int page) {
    	newsInitialize();
    	title1.setText(titleList.get(0 + page));
    	title2.setText(titleList.get(1 + page));
    	title3.setText(titleList.get(2 + page));
    	title4.setText(titleList.get(3 + page));
    	title5.setText(titleList.get(4 + page));
    	date1.setText(dateList.get(0 + page));
    	date2.setText(dateList.get(1 + page));
    	date3.setText(dateList.get(2 + page));
    	date4.setText(dateList.get(3 + page));
    	date5.setText(dateList.get(4 + page));
    	author1.setText(urlList.get(0 + page));
    	author2.setText(urlList.get(1 + page));
    	author3.setText(urlList.get(2 + page));
    	author4.setText(urlList.get(3 + page));
    	author5.setText(urlList.get(4 + page));
    }

    @FXML
    void newsInitialize() {
        News news = new News();
        String request = news.sendRequest();
        titleList = news.title(request);
        dateList = news.date(request);
        urlList = news.url(request);
        setArticles(0);
    }
}

