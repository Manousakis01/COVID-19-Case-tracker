package loginscreen;



import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
	public Connection databaseLink;

	public Connection getConnection() {
		String databaseUser = "root";
		String databasePassword = "entercode";
		String url = "jdbc:mysql://localhost/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}


		return databaseLink;
	}

}