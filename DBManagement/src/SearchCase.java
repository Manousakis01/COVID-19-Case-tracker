import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SearchCase {

	final String USER = "appuser";
	final String PASSWORD = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	private Connection connection;
	private PreparedStatement selectViaAmka;
	private ResultSet resultSet = null;


	// constructor
	public SearchCase () {
		try {
			connection = DriverManager.getConnection( DATABASE_URL, USER, PASSWORD);

			//creates select statement for Tested table
			selectViaAmka = connection.prepareStatement("SELECT * FROM Tested WHERE  "
					+ " SSN = ?");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}

	}


	//* when you click search button*/
	public ResultSet searchButtonPerformed(String SSN) {
		try {
			// sets ssn
			selectViaAmka.setString(1, SSN);

			// executeQuery returns a ResultSet with case's info
			resultSet = selectViaAmka.executeQuery();

		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return resultSet;
	}


	//* closes connection with DB */
	public void close() {
		try {
			connection.close();
			resultSet.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

}
