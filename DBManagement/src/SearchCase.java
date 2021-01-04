import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class SearchCase {

	final String username = "appuser";
	final String password = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	private Connection connection;
	private PreparedStatement selectViaAmka;
	private List<Tested> results;
	private int numberOfEntries = 0;
	private Tested currentEntry;
	private JTextField AMKAField;
	private JTextField firstNameField;
	private JTextField dateOfBirthField;
	private JTextField locationField;
	private JTextField emailField;
	private JTextField numberField;
	private JTextField dateOfTestField;
	private JTextField lastNameField;

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

	/** searches case by AMKA */
	public List <Tested> getCaseByAMKA (String AMKA) {
		List <Tested> results = null;
		ResultSet resultSet = null;

		try {
			// sets amka
			selectViaAmka.setString(1, AMKA);

			// executeQuery returns a ResultSet with case's info
			resultSet = selectViaAmka.executeQuery();

			results = new ArrayList<Tested>();
			while (resultSet.next()) {
				results.add(new Tested(resultSet.getString("SSN"),
						resultSet.getString("firstName"),
						resultSet.getString("lastName"),
						resultSet.getString("dateOfBirth"),
						resultSet.getString("dateOfTest"),
						resultSet.getString("location"),
						resultSet.getString("email"),
						resultSet.getString("number")));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}

			return results;
	}

	//* when you click search button*/
	public void searchButtonPerformed(String AMKA) {
		results = getCaseByAMKA(AMKA);
		numberOfEntries = results.size();

		if (numberOfEntries != 0) {
			currentEntry = results.get(0);

			System.out.println(currentEntry.getSSN());
			//System.out.println(currentEntry.get);
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