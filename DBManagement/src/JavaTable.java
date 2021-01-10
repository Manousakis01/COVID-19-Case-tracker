
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

//Jtable column 0 is ResultSet column 1.
// Jtabel row 0 is ResultSet row 1.
public class JavaTable extends AbstractTableModel{
	final String username = "appuser";
	final String password = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	//final String DATABASE_URL = "jdbc:mysql://10.10.1.3:52386/CovidDB";
	final String SELECT_QUERY = "SELECT * FROM Tested";
	private final Connection conn;
	private ResultSetMetaData metaData;
	private final Statement statement;
	private ResultSet resultset;
	private int numberOfRows;

	// Check connection to database.
	private boolean connectedToDatabase = false;

	/**Constructor*/
	public JavaTable () throws SQLException{
		//Connection
		conn = DriverManager.getConnection(DATABASE_URL, username, password);

		// Create Statement for query
		statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		// Update status
		connectedToDatabase = true;

		setQuery(SELECT_QUERY);
	}
	public JavaTable (String query) throws SQLException{
		//Connection
		conn = DriverManager.getConnection(DATABASE_URL, username, password);

		// Create Statement for query
		statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		// Update status
		connectedToDatabase = true;

		setQuery(query);
		resultset.first();
	}

	/** Return type(class) of column.*/
	@Override
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
	@Override
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
	public String getValueAt(int row, int column) {

		// Ensures the connection
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// return a value of the specific column and row of ResultSet
		try {
			resultset.absolute(row + 1);
			//System.out.print(resultset.getObject(column + 1) + ", ");
			return resultset.getString(column + 1);

		} catch (SQLException sqle) {

			sqle.printStackTrace();
		}

		return null;
	}

	public ResultSet getResultSet() {
		return resultset;
	}
	/** New query */
	public void setQuery(String query)
			throws SQLException, IllegalStateException {
		// Ensures the connection
				if (!connectedToDatabase)
					throw new IllegalStateException("Not Connected to Database");

				//sets and excecutes query
				resultset = statement.executeQuery(query);

				//takes metadata for resultSet
				metaData = resultset.getMetaData();

				//indicates row count
				resultset.last(); //go to last row
				numberOfRows = resultset.getRow(); //returns row number

				//informs JTable that the model changed
				fireTableStructureChanged();
	}
	/**Prints result of the SQL query. */
	public void printResult(JavaTable obj) {
		for (int i = 0; i < obj.getRowCount() ;i++ ) {
			for (int j = 0; j < obj.getColumnCount();j++) {
				obj.getValueAt(i, j);
			}
			System.out.println();
			}
	}
	/** Closes Statement and Connection */
	public void disconnectFromDtatabase() {
		if (connectedToDatabase) {
			//closes Statement and Connection
			try {
				resultset.close();
				statement.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				//update connection status
				connectedToDatabase = false;
			}
		}
	}
} //end of class