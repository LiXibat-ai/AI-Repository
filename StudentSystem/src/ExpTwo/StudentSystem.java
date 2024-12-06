package ExpTwo;
import java.util.Scanner;

public class StudentSystem {

    public static void main(String[] args) {
        User u1 = new User("hong12","1234561");
        u1.register(u1.getUsername(),u1.getPassword());
        u1.login(u1.getUsername(),u1.getPassword());


    }
}

/*
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        User u1 = new User(username,password);*/