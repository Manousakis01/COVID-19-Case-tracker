package loginscreen;

import java.sql.SQLException;

public class FakeMain {
    public static void main(String[] args) {
        try {
            Main.main(args);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
