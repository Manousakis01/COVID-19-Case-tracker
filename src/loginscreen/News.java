package loginscreen;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray; 
import org.json.JSONObject;

import javafx.fxml.FXML; 



public class News {

	private int status;
	//sends an http request using an API
	public String sendRequest() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://covid-19-news.p.rapidapi.com/v1/covid?q=covid&lang=en&sort_by=date&search_in=title&sources=nytimes.com%2C%20theguardian.com%2Cwsj.com&media=True"))
				.header("x-rapidapi-key", "2ec5601ca4msh1275d4576f466cbp1f5053jsn243b8a584e3e")
				.header("x-rapidapi-host", "covid-19-news.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status = response.statusCode();
		return response.body();
	}

	//returns a list of titles of articles
	 public List<String> title(String response) {
		JSONObject jsonObj = new JSONObject(response);
		List<String> titleList = new ArrayList<String>();
		JSONArray jsonArray = jsonObj.getJSONArray("articles");
		for(int i = 0 ; i < jsonArray.length(); i++){
		    titleList.add(jsonArray.getJSONObject(i).optString("title"));
		}
		return titleList;
	}

	//returns a list of urls of articles
	 public List<String> url(String response) {
		JSONObject jsonObj = new JSONObject(response.toString());
		List<String> urlList = new ArrayList<String>();
		JSONArray jsonArray = jsonObj.getJSONArray("articles");
		for(int i = 0 ; i < jsonArray.length() ; i++){
		    urlList.add(jsonArray.getJSONObject(i).optString("clean_url"));
		}
		return urlList;
	}

	//returns a list with dates of articles
	 public List<String> date(String response) {
		JSONObject jsonObj = new JSONObject(response.toString());
		List<String> dateList = new ArrayList<String>();
		JSONArray jsonArray = jsonObj.getJSONArray("articles");
		for(int i = 0 ; i < jsonArray.length() ; i++){
		    dateList.add(jsonArray.getJSONObject(i).optString("published_date"));
		}
		return dateList;
	}

	//returns the status code of the request
	 int getStatusCode() {
		return status;
	}
}
