package ExpTwo;
import java.util.Scanner;

public class StudentSystem {

    public static void main(String[] args) {
        User u1 = new User("hong12","1234561");
        u1.register(u1.getUsername(),u1.getPassword());
        u1.login(u1.getUsername(),u1.getPassword());


    }
}
