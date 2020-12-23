import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Random;



public class InsertLocations {
	public static void main(String[] args) {
		try {
			Class.forName("name"); //Connection with the database "name"
			Connection conn = null; //Setting up the connection
			conn = DriverManager.getConnection("url of the database", "system", "triger");
			
			
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
					"Evrou"
			};
			
			
			Random generator = new Random();					//Generates a random index
			int randomIndex = generator.nextInt(loc.length);	//and then selects a random element
			String rand = loc[randomIndex];						//from the table above

			String sql = "INSERT INTO Tested(location) VALUES (?)";
			
			PreparedStatement psmt = conn.prepareStatement(sql); 
			psmt.setString(6, rand);
			psmt.executeUpdate();
			psmt.close();
					
			
					
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
	}

}
