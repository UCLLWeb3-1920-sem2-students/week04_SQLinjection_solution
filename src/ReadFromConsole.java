import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromConsole {
    protected static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static String askPassword() throws IOException {
        System.out.println("Give wachtwoord");
        String oldPassword = bufferedReader.readLine();
        if (oldPassword.trim().isEmpty())
            oldPassword = "j";
        System.out.println("You wrote oldPassword = " + oldPassword);
        return oldPassword;
    }

    static String askEmail() throws IOException {
        System.out.println("Give email");
        String email = bufferedReader.readLine();
        if (email.trim().isEmpty()) email = "jan@jan.be";
        System.out.println("You wrote email = " + email);
        return email;
    }
}
