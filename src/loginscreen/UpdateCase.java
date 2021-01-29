package loginscreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class UpdateCase {

    private Connection connection;
    private PreparedStatement pstmt;
    Indetifieres item = new Indetifieres();

    // constructor
    public UpdateCase() {
        try {
            connection = DriverManager.getConnection(item.getDATABASE_URL(), item.getUSER(), item.getPASSWORD());
            //creates select statement for Tested table
            pstmt = connection.prepareStatement("UPDATE Tested SET firstName = ?, "
                    + "lastName = ?, dateOfBirth = ?, number = ?, email = ?, "
                    + "location = ? WHERE SSN = ?");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    //* when you click search button*/
    public void updateButtonPerformed(String firstName, String lastName, String dateOfBirth,
                                      String number, String email, String location, String SSN) {
        try {
            // sets ssn
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, dateOfBirth);
            pstmt.setString(4, number);
            pstmt.setString(5, email);
            pstmt.setString(6, location);
            pstmt.setString(7, SSN);
            // executeQuery returns a ResultSet with case's info
            pstmt.executeUpdate();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            close();
        }
    }

    //* closes connection with DB */
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

