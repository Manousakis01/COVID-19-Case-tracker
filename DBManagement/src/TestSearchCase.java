import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSearchCase {

	final String USER = "appuser";
	final String PASSWORD = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	private Connection connection;
	private PreparedStatement selectViaAmka;
	private ResultSet resultSet = null;

}
