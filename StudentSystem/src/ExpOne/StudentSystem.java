package ExpOne;
import java.util.Scanner;

public class StudentSystem {
    private static final int MAX_STUDENTS = 100; // ���������100��ѧ��
    private static String[] usernames = new String[MAX_STUDENTS];
    private static String[] passwords = new String[MAX_STUDENTS];
    private static int studentCount = 0; // ��ע��ѧ��������

    // ע�ắ��
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������û���:");
        String username = scanner.nextLine();
        System.out.println("����������:");
        String password = scanner.nextLine();

        // �ж��û��Ƿ�Ϊ�½��û�
        for (int i = 0; i < studentCount; i++) {
            if (usernames[i] != null && usernames[i].equals(username)) {
                System.out.println("���û����Ѵ��ڣ���ѡ�������û�����");
                return;
            }
        }

        // �½��û�
        usernames[studentCount] = username;
        passwords[studentCount] = password;
        studentCount++;
        System.out.println("ע��ɹ�����ӭ " + username + "��");
    }

    // ��¼����
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������û���:");
        String username = scanner.nextLine();
        System.out.println("����������:");
        String password = scanner.nextLine();

        // �ж��û��Ƿ�Ϊ��ע���û�
        for (int i = 0; i < studentCount; i++) {
            if (usernames[i] != null && usernames[i].equals(username) && passwords[i].equals(password)) {
                System.out.println("��¼�ɹ�����ӭ " + username + "��");
                // ���������ӽ����û���Ӧ����Ĵ���
                return;
            }
        }
        System.out.println("�û���������������������롣");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("��ѡ�������1. ע�� 2. ��¼ 3. �˳�");
            int choice = scanner.nextInt();
            scanner.nextLine(); // ���Ļ��з�

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("��лʹ��ѧ����Ϣϵͳ���ټ���");
                    System.exit(0);
                    break;
                default:
                    System.out.println("��Ч��ѡ�����������롣");
                    break;
            }
        }
    }
}
