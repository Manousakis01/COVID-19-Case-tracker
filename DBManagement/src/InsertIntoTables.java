
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoTables {

	final String username = "appuser";
	final String password = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	private Connection connection;
	private PreparedStatement insertTested;
	private PreparedStatement insertPositive;
	private PreparedStatement insertMeth;
	private PreparedStatement insertHealed;
	private PreparedStatement insertDeath;

	public InsertIntoTables() {
		try {
			connection = DriverManager.getConnection( DATABASE_URL, username, password);

			//creates insert statement for Tested table
			insertTested = connection.prepareStatement("INSERT INTO Tested "
					+ "(SSN, firstName, lastName, dateOfBirth, dateOfTest, location, email, number) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			//creates insert statement for Positive Table
			insertPositive = connection.prepareStatement(" INSERT INTO Positive"
					+ "(SSN) VALUES (?) ");

			//creates insert statement for Meth Table
			insertMeth = connection.prepareStatement(" INSERT INTO Meth"
					+ "(SSN, dateOfMeth) VALUES (?, ?) ");

			//creates insert statement for Healed Table
			insertHealed = connection.prepareStatement(" INSERT INTO Healed"
					+ "(SSN, dateOfHeal) VALUES (?, ?) ");

			//creates insert statement for death Table
			insertDeath = connection.prepareStatement(" INSERT INTO Death"
					+ "(SSN, dateOfDeath) VALUES (?, ?) ");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}

	}

	/** adds new case in Tested table*/
	public void addTested(String SSN, String firstName, String lastName,
			String dateOfBirth, String dateOfTest, String location, String email, String number) {

		try {
			//sets parameters and then executes insertNewCase query
			insertTested.setString(1, SSN);
			insertTested.setString(2, firstName);
			insertTested.setString(3, lastName);
			insertTested.setString(4, dateOfBirth);
			insertTested.setString(5, dateOfTest);
			insertTested.setString(6, location);
			insertTested.setString(7, email);
			insertTested.setString(8, number);

			insertTested.executeUpdate();
	

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

	}
	
	/** adds new case in Positive table*/
	public void addPositive(String SSN) {
		try {
			//sets parameters and then executes insertPositive query
			insertPositive.setString(1, SSN);

			insertPositive.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
	}

	/** adds new case in Meth table*/
	public void addMeth(String AMKA, String dateOfMeth) {

		try {
			//sets parameters and then executes insertMeth query
			insertMeth.setString(1, AMKA);
			insertMeth.setString(2, dateOfMeth);

			insertMeth.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

	}
	

	/** adds new case in Healed table*/
	public void addHealed(String SSN, String dateOfHeal) {

		try {
			//sets parameters and then executes insertHeal query
			insertHealed.setString(1, SSN);
			insertHealed.setString(2,  dateOfHeal);
			
			insertHealed.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

	}

	/** adds new case in Death table*/
	public void addDeath(String AMKA, String dateOfDeath) {

		try {
			//sets parameters and then executes insertDeath query
			insertDeath.setString(1, AMKA);
			insertDeath.setString(2,  dateOfDeath);

			insertDeath.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

	}

	
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

}

