package ExpFour;

import java.awt.*;
import ExpThree.*;
import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton;
    private JButton registerButton;
    private User user;


    public LoginFrame() {
        setTitle("ѧ����Ϣ����ϵͳ��¼����");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // ����������ڷ����������
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // �û�����ǩ���ı��ֶ�
        JLabel usernameLabel = new JLabel("�û���:");
        usernameLabel.setHorizontalAlignment(JLabel.RIGHT);
        usernameField = new JTextField(20);
        panel.add(usernameLabel);
        panel.add(usernameField);

        // �����ǩ���ı��ֶ�
        JLabel passwordLabel = new JLabel("����:");
        passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
        passwordField = new JPasswordField(20);
        panel.add(passwordLabel);
        panel.add(passwordField);

        // ��ɫ������
        JLabel roleLabel = new JLabel("��ɫ:");
        roleLabel.setHorizontalAlignment(JLabel.RIGHT);
        String[] roles = {"ѧ��", "��ʦ", "����Ա"};
        roleComboBox = new JComboBox<>(roles);
        panel.add(roleLabel);
        panel.add(roleComboBox);

        // ��¼��ť
        loginButton = new JButton("��¼");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // ����û����������Ƿ�Ϊ��
            if (username.trim().isEmpty() || password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ����������룡", "�������", JOptionPane.ERROR_MESSAGE);
            } else {
               user = roles();
                // ���� login ����������֤
                boolean loginSuccess = user.login(username, password);
                if (loginSuccess) {
                    JOptionPane.showMessageDialog(null, username+"��¼�ɹ���", "��¼���", JOptionPane.INFORMATION_MESSAGE);
                    // ���������ӵ�¼�ɹ�����߼�
                } else {
                    JOptionPane.showMessageDialog(null, "�û���������������������룡", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        // ע�ᰴť
        registerButton = new JButton("ע��");
        // ע�ᰴť���߼����Ը�����Ҫ���
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // ����û����������Ƿ�Ϊ��
            if (username.trim().isEmpty() || password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ����������룡", "�������", JOptionPane.ERROR_MESSAGE);
            } else {
                user = roles();
                // ���� register ��������ע��
                boolean registerSuccess = user.register(username, password);
                if (registerSuccess) {
                    JOptionPane.showMessageDialog(null, username + "ע��ɹ����벹�������Ϣ��", "ע����", JOptionPane.INFORMATION_MESSAGE);
                    new userFrame((String) roleComboBox.getSelectedItem(),username);
                    // ����������ע��ɹ�����߼�
                } else {
                    JOptionPane.showMessageDialog(null, "�û��Ѵ��ڣ������Ի���ϵ����Ա��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(registerButton);

        // �����嵽�����
        add(panel);

        // ���ý���ɼ�
        setVisible(true);
    }
    public User roles(){
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        switch ((String) roleComboBox.getSelectedItem()) {
            case "ѧ��":
                user = new Student(username, password, "d:/students.txt");
                break;
            case "��ʦ":
                user = new Teacher(username, password, "d:/teachers.txt");
                break;
            case "����Ա":
                user = new Admin(username, password, "d:/admins.txt");
                break;
        }
        return user;
    }



    public static void main(String[] args) {
        // ����Swing�����look and feelΪϵͳĬ��
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new LoginFrame();
    }
}
