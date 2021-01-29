package loginscreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SearchCase {
    Indetifieres in = new Indetifieres();
    private Connection connection;
    private PreparedStatement selectViaAmka;
    private ResultSet resultSet = null;


    /**
     * The constructor after connecting with database, create a prepareStatement to be executed to the called method.
     */
    public SearchCase() {
        try {
            connection = DriverManager.getConnection(in.getDATABASE_URL(), in.getUSER(), in.getPASSWORD());

            //creates SELECT WHERE statement for Tested table
            selectViaAmka = connection.prepareStatement("SELECT * FROM Tested WHERE  "
                    + " SSN = ?");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }

    }


    /**
     * Execute search in Tested table, query.
     *
     * @param SSN Social Security Number, primare Key
     */
    public ResultSet executeSearch(String SSN) {
        try {
            // sets ssn
            selectViaAmka.setString(1, SSN);

            // executeQuery returns a ResultSet with case's info
            resultSet = selectViaAmka.executeQuery();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return resultSet;
    }


    /**
     * Close connection with Database, MySQL Workbench.
     */
    public void close() {
        try {
            connection.close();
            resultSet.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

}
