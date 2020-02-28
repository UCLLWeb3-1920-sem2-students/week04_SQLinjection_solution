import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class SqjInjectionPrepared {

    public static void main(String[] args) throws Exception {
        String email = ReadFromConsole.askEmail();

        String oldPassword = ReadFromConsole.askPassword();

        Connection connection = DBConnection.getDbConnection();
        String sql = "SELECT * FROM web3.people WHERE email = ? and password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, oldPassword);
            System.out.println(statement);
            ResultSet result = statement.executeQuery();
            result.next();
            String password = result.getString("password");
            System.out.println("Your password: " + password);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        connection.close();
    }

}
