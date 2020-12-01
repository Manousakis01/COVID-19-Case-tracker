package loginscreen;


import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnectionWithLogScr {
	public Connection databaseLink;

	public Connection getConnection() {
		//enter the database name
		String databaseName = "";
		//enter the User of the database
		String databaseUser = "";
		//enter the Database password
		String databasePassword = "";
		//here is the mysql url for remote
		String url = "jdbc:mysql://localhost/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//fills the database's verification info
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}


		return databaseLink;
	}

}
