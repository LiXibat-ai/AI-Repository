package gy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterFrame extends JFrame {
    private JComboBox<String> roleComboBox;
    private JPanel dynamicPanel;
    private JTextField[] fields;

    public RegisterFrame() {
        setTitle("用户注册");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // 角色选择
        JPanel topPanel = new JPanel();
        roleComboBox = new JComboBox<>(new String[]{"学生", "老师", "管理员"});
        roleComboBox.addActionListener(this::updateFormFields);
        topPanel.add(new JLabel("选择角色:"));
        topPanel.add(roleComboBox);
        add(topPanel, BorderLayout.NORTH);

        // 动态表单区域
        dynamicPanel = new JPanel();
        dynamicPanel.setLayout(new GridLayout(0, 2, 10, 10));
        add(dynamicPanel, BorderLayout.CENTER);

        // 注册按钮
        JButton registerButton = new JButton("注册");
        registerButton.addActionListener(this::registerUser);
        add(registerButton, BorderLayout.SOUTH);

        // 显示初始表单
        updateFormFields(null);

        // 设置窗口居中
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateFormFields(ActionEvent e) {
        dynamicPanel.removeAll();
        String role = (String) roleComboBox.getSelectedItem();

        if ("学生".equals(role)) {
            fields = new JTextField[6];
            addField("用户名", 0);
            addField("密码", 1);
            addField("学号", 2);
            addField("姓名", 3);
            addField("性别", 4);
            addField("所属学院", 5);
        } else if ("老师".equals(role)) {
            fields = new JTextField[6];
            addField("用户名", 0);
            addField("密码", 1);
            addField("工号", 2);
            addField("姓名", 3);
            addField("性别", 4);
            addField("所属学院", 5);
        } else if ("管理员".equals(role)) {
            fields = new JTextField[4];
            addField("用户名", 0);
            addField("密码", 1);
            addField("工号", 2);
            addField("分管学院", 3);
        }

        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }

    private void addField(String label, int index) {
        dynamicPanel.add(new JLabel(label));
        fields[index] = new JTextField();
        dynamicPanel.add(fields[index]);
    }

    private void registerUser(ActionEvent e) {
        String role = (String) roleComboBox.getSelectedItem();
        String username = fields[0].getText();
        String password = fields[1].getText();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://1.94.104.154:3306/examination_system", "admin", "Aa@123456")) {

            String sql = "";
            if ("学生".equals(role)) {
                sql = "INSERT INTO student (uid, upassword, studentId, name, gender, collegeID) VALUES (?, ?, ?, ?, ?, ?)";
            } else if ("老师".equals(role)) {
                sql = "INSERT INTO teacher (uid, upassword, employeeId, name, gender, collegeID) VALUES (?, ?, ?, ?, ?, ?)";
            } else if ("管理员".equals(role)) {
                sql = "INSERT INTO admin (uid, upassword, employeeId, responsibleCollegeId) VALUES (?, ?, ?, ?)";
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (int i = 0; i < fields.length; i++) {
                    pstmt.setString(i + 1, fields[i].getText());
                }
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "注册成功！");
                dispose(); // 关闭注册窗口
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "注册失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
