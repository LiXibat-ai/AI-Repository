package ExpOne;
import java.util.Scanner;

public class StudentSystem {
    private static final int MAX_STUDENTS = 100; // 假设最多有100个学生
    private static String[] usernames = new String[MAX_STUDENTS];
    private static String[] passwords = new String[MAX_STUDENTS];
    private static int studentCount = 0; // 已注册学生的数量

    // 注册函数
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        // 判断用户是否为新建用户
        for (int i = 0; i < studentCount; i++) {
            if (usernames[i] != null && usernames[i].equals(username)) {
                System.out.println("该用户名已存在，请选择其他用户名。");
                return;
            }
        }

        // 新建用户
        usernames[studentCount] = username;
        passwords[studentCount] = password;
        studentCount++;
        System.out.println("注册成功，欢迎 " + username + "！");
    }

    // 登录函数
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        // 判断用户是否为已注册用户
        for (int i = 0; i < studentCount; i++) {
            if (usernames[i] != null && usernames[i].equals(username) && passwords[i].equals(password)) {
                System.out.println("登录成功，欢迎 " + username + "！");
                // 这里可以添加进入用户对应界面的代码
                return;
            }
        }
        System.out.println("用户名或密码错误，请重新输入。");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择操作：1. 注册 2. 登录 3. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("感谢使用学生信息系统，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效的选择，请重新输入。");
                    break;
            }
        }
    }
}
