package ExpTwo;

import java.io.*;
import java.util.Scanner;

public class User {
    private static final String USER_DATA_FILE = "d:/users.txt";
    private String username;
    private String password;

    // ���캯��
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(){

    }

    // Getter �� Setter ����
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
        System.out.println("��ӭ����ѧ������ϵͳע��ҳ��");
        return registerNewUser(username, password);
    }

    // ��¼����
    public boolean login(String username, String password) {
        System.out.println("��ӭ����ѧ������ϵͳ��¼ҳ��");
        return validateUser(username, password);
    }

    public static boolean registerNewUser(String username, String password) {
        if (!usernameExists(username)) {
            try (PrintWriter out = new PrintWriter(new FileWriter(USER_DATA_FILE, true))) {
                out.println(username + ":" + password);
                System.out.println("ע��ɹ�����ӭ " + username + "��");
                return true;
            } catch (IOException e) {
                System.out.println("ע��ʧ��: " + e.getMessage());
            }
        } else {
            System.out.println("���û����Ѵ��ڣ���ѡ�������û�����");
        }
        return false;
    }



    // ��֤�û�
    public static boolean validateUser(String username, String password) {
        File file = new File(USER_DATA_FILE);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(":");
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    System.out.println("��¼�ɹ�����ӭ����"+username);
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("�û��ļ�δ�ҵ�: " + e.getMessage());
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
            System.out.println("�û��ļ�δ�ҵ�: " + e.getMessage());
        }
        return false;
    }

}
