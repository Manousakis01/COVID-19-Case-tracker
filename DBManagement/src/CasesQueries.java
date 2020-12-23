package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class CasesQueries {
	
	final String username = "appuser";
	final String password = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52385/CovidDb";
	private Connection connection;
	private PreparedStatement insertTested;
	private PreparedStatement insertPositive;
	private PreparedStatement insertMeth;
	private PreparedStatement insertHealed;
	private PreparedStatement insertDeath;

	public CasesQueries() {
		try {
			connection = DriverManager.getConnection( DATABASE_URL, username, password);
			
			//creates insert statement for Tested table
			insertTested = connection.prepareStatement("INSERT INTO Tested "
					+ "(AMKA, firstName, lastName, dateOfBirth, dateOfTest, location, email, number) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			//creates insert statement for Positive Table
			insertPositive = connection.prepareStatement(" INSERT INTO Positive"
					+ "(AMKA) VALUES (?) ");
			
			//creates insert statement for Meth Table
			insertMeth = connection.prepareStatement(" INSERT INTO Meth"
					+ "(AMKA, dateOfMeth) VALUES (?, ?) ");
			
			//creates insert statement for Healed Table
			insertHealed = connection.prepareStatement(" INSERT INTO Healed"
					+ "(AMKA, dateOfHeal) VALUES (?, ?) ");
			
			//creates insert statement for death Table
			insertDeath = connection.prepareStatement(" INSERT INTO Death"
					+ "(AMKA, dateOfDeath) VALUES (?, ?) ");
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
		
	}
	
	/** adds new case in Tested table*/
	public int addTested(int AMKA, String firstName, String lastName,
			String dateOfBirth, String dateOfTest, String location, String email, String number) {
		int result = 0;
		
		try { 
			//sets parameters and then executes insertNewCase query
			insertTested.setInt(1, AMKA);
			insertTested.setString(2, firstName);
			insertTested.setString(3, lastName);
			insertTested.setString(4, dateOfBirth);
			insertTested.setString(5, dateOfTest);
			insertTested.setString(6, location);
			insertTested.setString(7, email);
			insertTested.setString(8, number);
			
			result = insertTested.executeUpdate();
			
			//adds case in Positive table automatically
			addPositive(AMKA);
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		
		return result;
	}
	public void SelfInsertPositive() {
		int randomNumber = 0;
		Random rand = new Random();
		try {
			var autoInsert = connection.prepareStatement(" INSERT INTO Positive"
					+ "SELECT SSN FROM Tested LIMIT (?) ");
			randomNumber = rand.nextInt()*(50)+17;
			autoInsert.setInt(1,randomNumber )
		}
	}
	/** adds new case in Positive table*/
	public int addPositive(int AMKA) {
		int result = 0;
	
		try { 
			//sets parameters and then executes insertPositive query
			insertPositive.setInt(1, AMKA);
			
			result = insertPositive.executeUpdate();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		
		return result;
	}
	
	/** adds new case in Meth table*/
	public int addMeth(int AMKA, String dateOfMeth) {
		int result = 0;
	
		try { 
			//sets parameters and then executes insertMeth query
			insertMeth.setInt(1, AMKA);
			insertMeth.setString(2, dateOfMeth);
			
			result = insertMeth.executeUpdate();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		
		return result;
	}
	
	/** adds new case in Healed table*/
	public int addHealed(int AMKA, String dateOfHeal) {
		int result = 0;
	
		try { 
			//sets parameters and then executes insertHeal query
			insertHealed.setInt(1, AMKA);
			insertHealed.setString(2,  dateOfHeal);
			
			result = insertHealed.executeUpdate();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		
		return result;
	}
	
	/** adds new case in Death table*/
	public int addDeath(int AMKA, String dateOfDeath) {
		int result = 0;
	
		try { 
			//sets parameters and then executes insertDeath query
			insertDeath.setInt(1, AMKA);
			insertDeath.setString(2,  dateOfDeath);
			
			result = insertDeath.executeUpdate();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		
		return result;
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
}
