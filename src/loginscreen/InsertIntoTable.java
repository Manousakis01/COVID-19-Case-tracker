package loginscreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoTable {

    Indetifieres in = new Indetifieres();
    private Connection connection;
    private PreparedStatement insertTested;
    private PreparedStatement insertPositive;
    private PreparedStatement insertMeth;
    private PreparedStatement insertHealed;
    private PreparedStatement insertDeath;

    /**
     * The constructor after connecting with database, create a prepareStatement to be executed to the called method.
     */
    public InsertIntoTable() {
        try {
            connection = DriverManager.getConnection(in.getDATABASE_URL(), in.getUSER(), in.getPASSWORD());

            //creates insert statement for Tested table
            insertTested = connection.prepareStatement("INSERT INTO Tested "
                    + "(SSN, firstName, lastName, dateOfBirth, dateOfTest, location, email, number) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            //creates insert statement for Positive Table
            insertPositive = connection.prepareStatement(" INSERT INTO Positive"
                    + "(SSN) VALUES (?) ");

            //creates insert statement for Meth Table
            insertMeth = connection.prepareStatement(" INSERT INTO Meth"
                    + "(SSN, dateOfMeth) VALUES (?, ?) ");

            //creates insert statement for Healed Table
            insertHealed = connection.prepareStatement(" INSERT INTO Healed"
                    + "(SSN, dateOfHeal) VALUES (?, ?) ");

            //creates insert statement for death Table
            insertDeath = connection.prepareStatement(" INSERT INTO Death"
                    + "(SSN, dateOfDeath) VALUES (?, ?) ");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * Adds one more row in MySQL Tested table.
     * For each covid test (PCR or Rapid) in Tested table will be added new row.
     * Sets parameters to prepare STatement and the execute query.
     *
     * @param SSN         Social Security Number, primare Key
     * @param firstName   First name of the tested person
     * @param lastName    Last name of the tested person
     * @param dateOfBirth Date of birth
     * @param dateOfTest  Date of the specific test
     * @param location    Living county of the tested person
     * @param email       E-mail of the Tested person, in case them is positive
     *                    a e-mail will be sent
     * @param number      Telephone number of the tested person.
     */
    public void Tested(String SSN, String firstName, String lastName,
                       String dateOfBirth, String dateOfTest, String location, String email, String number) {

        try {
            //sets parameters and then executes insertNewCase query
            insertTested.setString(1, SSN);
            insertTested.setString(2, firstName);
            insertTested.setString(3, lastName);
            insertTested.setString(4, dateOfBirth);
            insertTested.setString(5, dateOfTest);
            insertTested.setString(6, location);
            insertTested.setString(7, email);
            insertTested.setString(8, number);

            insertTested.executeUpdate();


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

    }

    /**
     * Adds new covid-19 case in Positive table.
     * Sets parameters to prepare STatement and the execute query.
     *
     * @param SSN Social Security Number, primary key
     */
    public void Positive(String SSN) {
        try {
            //sets parameters and then executes insertPositive query
            insertPositive.setString(1, SSN);

            insertPositive.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
    }

    /**
     * Adds new case in Meth table, each time a person is added in Intesity Care Unit (ICU).
     * Sets parameters to prepare STatement and the execute query.
     *
     * @param SSN        Social Security Number, primary key
     * @param dateOfMeth The date of entering ICU
     */
    public void Meth(String SSN, String dateOfMeth) {

        try {
            //sets parameters and then executes insertMeth query
            insertMeth.setString(1, SSN);
            insertMeth.setString(2, dateOfMeth);

            insertMeth.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

    }

    /**
     * Adds new case in Healed table, each time someone recover covid-19.
     * Email will be sent after 14 days to test again.
     * Sets parameters to prepare STatement and the execute query.
     *
     * @param SSN        Social Security Number, primary key
     * @param dateOfHeal date of recover.
     */
    public void Healed(String SSN, String dateOfHeal) {
        try {
            //sets parameters and then executes insertHeal query
            insertHealed.setString(1, SSN);
            insertHealed.setString(2, dateOfHeal);

            insertHealed.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

    }

    /**
     * Adds new death case in Death table.
     * Sets parameters to prepare STatement and the execute query.
     *
     * @param SSN         Social Security Number, primary key
     * @param dateOfDeath The last date of a person.
     */
    public void Death(String SSN, String dateOfDeath) {

        try {
            //sets parameters and then executes insertDeath query
            insertDeath.setString(1, SSN);
            insertDeath.setString(2, dateOfDeath);

            insertDeath.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

    }

    /**
     * Close connection with database, MySQL workbench.
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}

