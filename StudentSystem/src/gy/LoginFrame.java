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
        setTitle("用户登录");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("用户名:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("角色:"));
        roleComboBox = new JComboBox<>(new String[]{"学生", "老师", "管理员"});
        add(roleComboBox);

        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(this::performLogin);
        add(loginButton);

        JButton registerButton = new JButton("注册");
        registerButton.addActionListener(e -> new RegisterFrame());
        add(registerButton);

        JButton testButton = new JButton("测试数据库连接");
        testButton.addActionListener(this::testDatabaseConnection);
        add(testButton);

        setLocationRelativeTo(null); // 设置窗口居中
        setVisible(true);
    }

    private void performLogin(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String role = roleComboBox.getSelectedItem().toString();
        String table;

        switch (role) {
            case "学生":
                table = "student";
                break;
            case "老师":
                table = "teacher";
                break;
            case "管理员":
                table = "admin";
                break;
            default:
                JOptionPane.showMessageDialog(this, "角色无效！", "登录失败", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(this, "登录成功！");
                        new UserFrame(role, username);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "用户名或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "登录失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void testDatabaseConnection(ActionEvent e) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://1.94.104.154:3306/examination_system", "admin", "Aa@123456")) {
            JOptionPane.showMessageDialog(this, "数据库连接成功！");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "数据库连接失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
