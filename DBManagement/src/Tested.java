package database;

public class Tested {

	private int AMKA;
	private String lastName;
	private String firstName;
	private String email;
	private String number;
	private String location;
	private String dateOfTest;
	private String dateOfBirth;

	public Tested() {
		// TODO Auto-generated constructor stub
	}
	
	public Tested(int AMKA, String firstName, String lastName,
			String dateOfBirth, String dateOfTest, String location, String email, String number) {
		setAMKA(AMKA);
		setfirstName(firstName);
		setlastName(lastName);
		setdateOfBirth(dateOfBirth);
		setdateOfTest(dateOfTest);
		setlocation(location);
		setemail(email);
		setnumber(number);
	}
	
	//sets AMKA
	public void setAMKA(int AMKA) {
		this.AMKA = AMKA;
	}
	
	//sets first name
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//sets last name
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	//sets dateOfBirth
	public void setdateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	//sets dateOfTestdateOfBirth
	public void setdateOfTest(String dateOfTest) {
		this.dateOfTest = dateOfTest;
	}
	
	//sets location
	public void setlocation(String location) {
		this.location = location;
	}
	
	//sets email
	public void setemail(String email) {
		this.email = email;
	}
	
	// sets number
	public void setnumber(String number) {
		this.number = number;
	}
	
	//gets AMKA
	public int getAMKA() {
		return AMKA;
	}
	
	//gets first name
	public String getfirstName() {
		return firstName;
	}
	
	//gets last name
	public String getlastName() {
		return lastName;
	}
	
	//gets dateOfBirth
	public String getdateOfBirth() {
		return dateOfBirth;
	}
	
	//gets dateOfTestdateOfBirth
	public String getdateOfTest() {
		return dateOfTest;
	}
	
	//sets location
	public String getlocation() {
		return location;
	}
	
	//gets email
	public String getemail() {
		return email;
	}
	
	// gets number
	public String getnumber() {
		return number;
	}

}
