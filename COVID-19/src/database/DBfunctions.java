package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class DBfunctions {

	/**Method DBConnMain.get() provides objects from sql.*/
	public static ArrayList<String> get(String Url,String Username, String Password) throws Exception{
		try {
		
		Connection con = getConnection(Url, Username, Password);
		//"SELECT * FROM Users"
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Users");
		ResultSet result = statement.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			//System.out.print(result.getInt("id") + " , ");
			System.out.println();
			//System.out.print(result.getString("first_name") + " , ");
			System.out.println();
			System.out.print(result.getString("last_name") + " , ");
			System.out.println();
			System.out.print(result.getString("email") + " , ");
			//System.out.println();
			System.out.print(result.getString("password") + " , ");
			System.out.println();
	
		}
		return array;
	} catch(Exception e) {System.out.println(e);}
	return null;
	} 
	/**Method DBConnMain.get() provides object from sql query result.*/
	public static ResultSet get(String Url,String Username, String Password, String query) throws Exception{
		try {
		//Connection with database.
		Connection con = getConnection(Url, Username, Password);
		//query statement.
		PreparedStatement statement = con.prepareStatement(query);
		// query result.
		ResultSet result = statement.executeQuery();
		return result;
	} catch(Exception e) {
		System.out.println(e);
		}
	return null;
	}
	/**Method DBConnMain.get() prints object from sql query result.*/
	public static ArrayList<String> printResult(String Url,String Username, String Password) throws Exception{
		try {
			int  answer ;
			ArrayList<String> array;
			
		Scanner sc = new Scanner(System.in);
		Connection con = getConnection(Url, Username, Password);
		do {
		System.out.println("Please enter query. ");
		System.out.println("logins-> users:id, first_name, last_name, email, password. ");
		System.out.println("population-> citizens: id, name, lastname, dname, gender, location, number, Email, date.");
		
		//Query statement
		PreparedStatement statement = con.prepareStatement(sc.nextLine());
		//Query result
		ResultSet result = statement.executeQuery();
		array = new ArrayList<String>();
		
		System.out.println("Enter the names of columns. (Seperate with ' , ' )");
		//columNames has all the columns that user wants to appear. 
		String columNames = sc.next(); 
		
		// columName has each seperated column that user wants to appear.
		String [] columName = columNames.split(",");
		
		while(result.next()) {
			for(String i : columName) {
				try {
					System.out.print(result.getString(i) + ", ");
					System.out.println();
				} catch (SQLException e) {
					System.out.print(result.getInt("i") + ", ");
					System.out.println();
				} catch (Exception e) {
					System.out.println(e);
				}
			}	
		}
		
		System.out.println("Do you want to continue. (1.Yes/ 0.No ");
		answer = sc.nextInt();
		
		} while (answer == 1);
		sc.close();
		return array;
	} catch(Exception e) {
		System.out.println(e);
		}
	return null;
	}
	/**Connection with Data Base. Needs username, password and url or path for identification. */
	public static Connection getConnection(String Url,String Username, String Password) throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			//Data Base path,Logins = Database Name(jdbc:mysql://localhost:3306/logins or population)
			String url = Url; 
			// User name.
			String username = Username;
			//Database password
			String password = Password;
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected to Database. ");
			return conn;
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
}
