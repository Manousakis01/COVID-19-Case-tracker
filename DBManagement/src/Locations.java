package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Locations {
	
	final String username = "appuser";
	final String password = "!Test12!";
	final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	private Connection connection;
	private PreparedStatement insertlocation;
	
	public Locations() {
		try {
			connection = DriverManager.getConnection( DATABASE_URL, username, password);

			//creates insert statement for Tested table
			insertlocation = connection.prepareStatement("UPDATE preTested "
					+ "SET location = (?) WHERE partSSN = (?) ");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}

	}
	
	public void InsertLocations() {
		try {
			String loc[] = {
					"Arcadia",
					"Ioannina",
					"Piraeus",
					"Magnisia",
					"Aitolia",
					"Kyklades",
					"Serres",
					"Attiki",
					"Igoumenitsa",
					"Ilia",
					"Trikala",
					"Pellas",
					"Evrou",
					"Thesalonikis"
			};
			
			
			JavaTable jt = new JavaTable("SELECT * FROM preTested");
			int rows = jt.getRowCount();
			
			for (int i = 100; i < rows; i++) {
				//Generates a random index
				Random generator = new Random();
				//and then selects a random element
				int randomIndex = generator.nextInt(loc.length);	
				//from the table above
				String rand = loc[randomIndex];						
				
				//sets parameters and then executes update query
				insertlocation.setString(1, rand);
				String str = " " + i;
				insertlocation.setString(2, str);

				insertlocation.executeUpdate();
			}
			
			
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

