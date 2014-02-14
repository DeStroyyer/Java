package ua.com.consolenotebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TAI on 07.02.14.
 */
public class ShowContacts extends AbstractCommand {
    public void abstractCommand () {
        Connection con;
        String url = "jdbc:mysql://localhost/CONSOLENOTEBOOK" +
                "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
        String name = "root";
        String password = "3232";
        try {
            con = DriverManager.getConnection(url, name, password);
            java.sql.Statement statement = con.createStatement();
            String query = "SELECT USERNAME, PHONE FROM NOTEBOOK";
            ResultSet rs = statement.executeQuery(query);
            String username, phone;
            while (rs.next()) {
                username = rs.getString("username");
                phone = rs.getString("phone");
                System.out.println("******************************");
                System.out.println("username: " + username);
                System.out.println("phone: " + phone);
                System.out.println("******************************");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
