package ua.com.consolenotebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by TAI on 07.02.14.
 */
public class DeleteContact extends AbstractCommand{
    private Connection con;

    public void abstractCommand (String DeleteContact) {
        String url = "jdbc:mysql://localhost/CONSOLENOTEBOOK" +
                "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
        String name = "root";
        String password = "3232";
        try {
            con = DriverManager.getConnection(url, name, password);
            PreparedStatement statement = con.prepareStatement("DELETE FROM NOTEBOOK WHERE USERNAME = '" + DeleteContact + "'");
            statement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
