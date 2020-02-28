import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlInjection {

    public static void main(String[] args) throws Exception {

        String email = ReadFromConsole.askEmail();

        String oldPassword = ReadFromConsole.askPassword();

        Connection connection = DBConnection.getDbConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM web3.people WHERE email='" + email
                + "' and password='" + oldPassword + "'";
        System.out.println(sql);
        try {
            ResultSet result = statement.executeQuery(sql);
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
