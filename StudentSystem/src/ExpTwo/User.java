package ExpTwo;

import java.io.*;
import java.util.Scanner;

public class User {
    private static final String USER_DATA_FILE = "d:/users.txt";
    private String username;
    private String password;

    // 构造函数
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(){

    }

    // Getter 和 Setter 方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean register(String username, String password) {
        System.out.println("欢迎来到学生管理系统注册页面");
        return registerNewUser(username, password);
    }

    // 登录函数
    public boolean login(String username, String password) {
        System.out.println("欢迎来到学生管理系统登录页面");
        return validateUser(username, password);
    }

    public static boolean registerNewUser(String username, String password) {
        if (!usernameExists(username)) {
            try (PrintWriter out = new PrintWriter(new FileWriter(USER_DATA_FILE, true))) {
                out.println(username + ":" + password);
                System.out.println("注册成功，欢迎 " + username + "！");
                return true;
            } catch (IOException e) {
                System.out.println("注册失败: " + e.getMessage());
            }
        } else {
            System.out.println("该用户名已存在，请选择其他用户名。");
        }
        return false;
    }



    // 验证用户
    public static boolean validateUser(String username, String password) {
        File file = new File(USER_DATA_FILE);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(":");
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    System.out.println("登录成功！欢迎您！"+username);
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("用户文件未找到: " + e.getMessage());
        }
        return false;
    }


    public static boolean usernameExists(String username) {
        File file = new File(USER_DATA_FILE);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(":");
                if (userData[0].equals(username)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("用户文件未找到: " + e.getMessage());
        }
        return false;
    }

}
