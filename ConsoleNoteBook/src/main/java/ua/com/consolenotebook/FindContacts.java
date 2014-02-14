package ua.com.consolenotebook;

import java.sql.*;

/**
 * Created by TAI on 07.02.14.
 */
public class FindContacts extends AbstractCommand {
    Connection con;

    public void abstractCommand (String FindPhone) {
        String url = "jdbc:mysql://localhost/CONSOLENOTEBOOK" +
                "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
        String name = "root";
        String password = "3232";
        try {
            con = DriverManager.getConnection(url, name, password);
            PreparedStatement statement = con.prepareStatement("SELECT PHONE FROM NOTEBOOK WHERE USERNAME=?");
            statement.setString(1, FindPhone);
            ResultSet rs = statement.executeQuery();
            String phone = String.valueOf(0);
            while (rs.next()) {
                phone = rs.getString("phone");
            }
            System.out.println("phone: " + phone);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
