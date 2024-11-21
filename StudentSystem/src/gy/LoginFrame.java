package gy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public LoginFrame() {
        setTitle("�û���¼");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("�û���:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("����:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("��ɫ:"));
        roleComboBox = new JComboBox<>(new String[]{"ѧ��", "��ʦ", "����Ա"});
        add(roleComboBox);

        JButton loginButton = new JButton("��¼");
        loginButton.addActionListener(this::performLogin);
        add(loginButton);

        JButton registerButton = new JButton("ע��");
        registerButton.addActionListener(e -> new RegisterFrame());
        add(registerButton);

        JButton testButton = new JButton("�������ݿ�����");
        testButton.addActionListener(this::testDatabaseConnection);
        add(testButton);

        setLocationRelativeTo(null); // ���ô��ھ���
        setVisible(true);
    }

    private void performLogin(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String role = roleComboBox.getSelectedItem().toString();
        String table;

        switch (role) {
            case "ѧ��":
                table = "student";
                break;
            case "��ʦ":
                table = "teacher";
                break;
            case "����Ա":
                table = "admin";
                break;
            default:
                JOptionPane.showMessageDialog(this, "��ɫ��Ч��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
                return;
        }

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://1.94.104.154:3306/examination_system", "admin", "Aa@123456")) {

            String sql = "SELECT * FROM " + table + " WHERE uid = ? AND upassword = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "��¼�ɹ���");
                        new UserFrame(role, username);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "�û������������", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "��¼ʧ��: " + ex.getMessage(), "����", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void testDatabaseConnection(ActionEvent e) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://1.94.104.154:3306/examination_system", "admin", "Aa@123456")) {
            JOptionPane.showMessageDialog(this, "���ݿ����ӳɹ���");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "���ݿ�����ʧ��: " + ex.getMessage(), "����", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
