package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

//Jtable column 0 is ResultSet column 1.
// Jtabel row 0 is ResultSet row 1.
public class Users extends AbstractTableModel{
	final String username = "root";
	final String password = "!@#lerinth4.D";
	final String DATABASE_URL = "jdbc:mysql://localhost:3306/logins";
	final String SELECT_QUERY = "SELECT id, first_name, last_name, email, password FROM users";
	private final Connection conn;
	private ResultSetMetaData metaData;
	private final Statement statement;
	private ResultSet resultset;
	private int numberOfRows;
	
	// Check connection to database.
	private boolean connectedToDatabase = false;
	
	/**Constructor*/
	public Users (String DTABASE_URL, String username, String password, String SELECT_QUERY ) throws SQLException{
		//Connection 
		conn = DriverManager.getConnection(DATABASE_URL, username, password);
		
		// Create Statement for query 
		statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		// Update status 
		connectedToDatabase = true;
		
		//setQuery(SELECT_QUERY);
	}
	
	/** Return type(class) of column.*/
	public Class getColumnClass(int column) throws IllegalStateException {
		
		// Ensures the connection
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		// Indicates Java Class of column
		try {
			String className = metaData.getColumnClassName(column+1);
			// return class object of className
			return Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Object.class; // if there were troubles if return type superclass Object
	}
	
	/*try (
		Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "!@#lerinth4.D");
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery(SELECT_QUERY);)
	{ 
		ResultSet = 
	}*/
	@Override
	/** Returns rows number */
	public int getRowCount() {
	
		// Ensures the connection
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		return numberOfRows;
	}
	
	@Override
	/** Returns number of column*/
	public int getColumnCount() throws IllegalStateException {
		
		// Ensures the connection
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		//Inicates column number
		try {
			return metaData.getColumnCount();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return 0; // if there were troubles it returns 0
	}
	/**Returns the name of a specific column  */
	public String getColumnName(int column) throws IllegalStateException {
		
		// Ensures the connection
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		// Indicates name of column.
		try {
			return metaData.getColumnName(column + 1);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return " "; // if there were troubles, returns empty as column name
	}
	
	/**Return the value of a specific column and row. */
	@Override
	public Object getValueAt(int row, int column) {
		
		// Ensures the connection
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		// return a value of the specific column and row of ResultSet
		try {
			resultset.absolute(row + 1);
			return resultset.getObject(column + 1);
			
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
		}
		
		return null;
	}
}