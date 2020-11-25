package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnMain {
	public static void main (String[] args)  throws Exception{
		getConnection();
		//createTable();
		//post();
		get();
	}
	/**Method DBConnMain.get() provides objects from sql.*/
	public static ArrayList<String> get() throws Exception{
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT email,password FROM Users");
		ResultSet result = statement.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			//System.out.print(result.getInt("id"));
			//System.out.println();
			//System.out.print(result.getString("first_name"));
			//System.out.println();
			//System.out.print(result.getString("last_name"));
			//System.out.println();
			System.out.print(result.getString("email"));
			System.out.println();
			System.out.print(result.getString("password"));
			System.out.println();
	
		}
		return array;
	} catch(Exception e) {System.out.println(e);}	
	return null;
	}
	/**Connection with Data Base. Needs username, password and url or path for identification. */
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			//Data Base path,Logins = Database Name
			String url = "jdbc:mysql://localhost:3306/logins"; 
			// User name
			String username = "root";
			//Database password
			String password = "!@#lerinth4.D";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	//Optional. It might be done by Mysql Workbench
	public static void post() throws Exception{
		
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES (1,'Hyacinthie', 'Stebbins', 'hstebbins0@baidu.com','zcKsaU0ieO2')");
			PreparedStatement st1 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES(2, 'Isis', 'Wash', 'iwash1@odnoklassniki.ru', 'PZ7qs2cg1')");
			PreparedStatement st2 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES(3, 'Dion', 'Jagiela', 'djagiela2@weibo.com', 'PKv4f9dnWgj')");
			PreparedStatement st3 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES (4, 'Virgina', 'Ruttgers', 'vruttgers3@devhub.com', 'dOvQ5MB7')");
			PreparedStatement st4 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES (5, 'Sigfrid', 'Hesey', 'shesey4@princeton.edu', '0E1Ty8I')");
			PreparedStatement st5 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES (6, 'Livvy', 'Woodeson', 'lwoodeson5@delicious.com', 'pi9noWU4UCu')");
			PreparedStatement st6 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES (7, 'Janene', 'Greet', 'jgreet6@gravatar.com', 'CAyJ4yzDo')");
			PreparedStatement st7 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES(8, 'Lazar', 'Passy', 'lpassy7@cpanel.net', 'QxoWwkT3MA')");
			PreparedStatement st8 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES (9, 'Roxane', 'Peak', 'rpeak8@bizjournals.com', 'XvvTnJgl')");
			PreparedStatement st9 = con.prepareStatement("INSERT INTO Users (id, first_name, last_name,email,password) VALUES (10, 'Erroll', 'Poland', 'epoland9@aol.com', 'ffNwBWxH5')");
			
			st.executeUpdate();	
			st1.executeUpdate();
			st2.executeUpdate();	
			st3.executeUpdate();	
			st4.executeUpdate();	
			st5.executeUpdate();	
			st6.executeUpdate();	
			st7.executeUpdate();	
			st8.executeUpdate();	
			st9.executeUpdate();	
			
		} catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Insert completed!");
		}
	}
	//Optional. It might be done by Mysql Workbench
	public static void createTable() throws Exception {
		try {
			Connection con = getConnection();
			// Create a table.
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Users("
					+ " id int NOT NULL AUTO_INCREMENT,"
					+ " first_name varchar(255),"
					+ " last_name varchar(255),"
					+ " email varchar(255),"
					+ " password varchar(255),"
					+ " PRIMARY KEY(id))");
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			
		} finally {
			System.out.println("The function has been completed");
		}
	}
}
