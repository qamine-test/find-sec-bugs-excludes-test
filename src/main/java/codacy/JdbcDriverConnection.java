//#Patterns: HARD_CODE_PASSWORD, PREDICTABLE_RANDOM
package codacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

public class JdbcDriverConnection {

    private static final String MYSQL_PASSWORD = "h4rDc0de";

    public static void connectionWithHardCodePassword1() throws SQLException {
        //#Err: HARD_CODE_PASSWORD
        Connection conn = DriverManager.getConnection("jdbc:mysql://prod.company.com/production", "root", "lamepassword");
    }

    public static void connectionWithHardCodePassword2() throws SQLException {
        //#Err: HARD_CODE_PASSWORD
        Connection conn = DriverManager.getConnection("jdbc:mysql://prod.company.com/production", "dba", MYSQL_PASSWORD);
    }

    public static void connectionOK(Properties props) throws SQLException {
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        Connection conn = DriverManager.getConnection("jdbc:mysql://prod.company.com/production", username, password);
    }

    public static String generateSecretToken() {
        //#Err: PREDICTABLE_RANDOM
        Random r = new Random();
        return Long.toHexString(r.nextLong());
    }
}