import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Locations {
	Indetifieres in = new Indetifieres();
	private Connection connection;
	private PreparedStatement insertlocation;

	public Locations() {
		try {
			connection = DriverManager.getConnection(in.getDATABASE_URL(), in.getUSER(), in.getPASSWORD());

			//creates insert statement for preTested table
			insertlocation = connection.prepareStatement("UPDATE preTested "
					+ "SET location = (?) WHERE partSSN = (?) ");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}

	}
	/**InsertLocations is created to help the creator.
	 * The method randomly insert data in the table preTested.
	 */
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
			Random generator;
			int randomIndex;
			String rand;
			for (int i = 100; i < rows; i++) {
				//Generates a random index
				generator = new Random();
				//and then selects a random element
				randomIndex = generator.nextInt(loc.length);
				//from the table above
				rand = loc[randomIndex];

				//sets parameters and then executes update query
				insertlocation.setString(1, rand);

				insertlocation.setString(2, Integer.toString(i));

				insertlocation.executeUpdate();
			}
			System.out.println("Done!");

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

