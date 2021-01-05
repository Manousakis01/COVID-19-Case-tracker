package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SearchCase {

	final String username = "appuser";
	final String password = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	private Connection connection;
	private PreparedStatement selectViaAmka;


	// constructor
	public SearchCase () {
		try {
			connection = DriverManager.getConnection( DATABASE_URL, username, password);

			//creates select statement for Tested table
			selectViaAmka = connection.prepareStatement("SELECT * FROM Tested WHERE  "
					+ " SSN = ?");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}

	}


	//* when you click search button*/
	public void searchButtonPerformed(String SSN) {
		ResultSet resultSet = null;

		try {
			// sets ssn
			selectViaAmka.setString(1, SSN);

			// executeQuery returns a ResultSet with case's info
			resultSet = selectViaAmka.executeQuery();
			while (resultSet.next()) {
				
				System.out.println(resultSet.getString("SSN"));
				System.out.println(resultSet.getString("firstname"));
				
				// emfanise opoia theleis opoy theleis arkei na to oriseis esy
				resultSet.getString("lastName");
				resultSet.getString("dateOfBirth");
				resultSet.getString("dateOfTest");
				resultSet.getString("location");
				resultSet.getString("email");
				resultSet.getString("number");
			}
			resultSet.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			close();
		} 

	}


	//* closes connection with DB */
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

}
