package database;

import java.util.Scanner;

public class DBmain {

		public static void main (String []args) throws Exception {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter URL. ( There are 2 databases. logins and population. E.g. jdbc:mysql://localhost:3306/logins )");
			String Url = sc.next();
			System.out.println("Please enter USERNAME. ");
			String Username = sc.next();
			System.out.println("Pease enter PASSWORD. ");
			String Password = sc.next();
			DBfunctions.getConnection(Url, Username, Password);
			DBfunctions.printResult(Url,Username,Password);
			sc.close();
	}
}

