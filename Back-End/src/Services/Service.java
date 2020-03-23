package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wizard
 */
public class Service {

    protected Connection connection;

    public Service() {
        connection = null;
    }

    protected void Connect() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LAB_MATRICULA", "LAB_MATRICULA1234");
    }

    protected void Disconnect() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }
}
