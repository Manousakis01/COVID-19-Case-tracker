package CovidTracker.CovidTracker;

public class Indetifieres {
	private final String USER = "appuser";
	private final String PASSWORD = "!Test12!";
	//private final String DATABASE_URL = "jdbc:mysql://covidlog.servebbs.com:52386/CovidDB";
	final String DATABASE_URL = "jdbc:mysql://10.10.1.3:3306/CovidDB";
	public String getUSER() {
		return USER;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public String getDATABASE_URL() {
		return DATABASE_URL;
	}

}
