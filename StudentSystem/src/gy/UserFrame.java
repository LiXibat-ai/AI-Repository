package gy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserFrame extends JFrame {
    private String role;
    private String username;
    private JPanel dataPanel;

    public UserFrame(String role, String username) {
        this.role = role;
        this.username = username;

        // 设置窗口标题和大小
        setTitle("用户界面 - " + role);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 顶部信息面板
        JPanel topPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("欢迎, " + username + " (" + role + ")");
        topPanel.add(welcomeLabel);
        add(topPanel, BorderLayout.NORTH);

        // 数据显示面板
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(0, 2, 10, 10)); // 使用 GridLayout 展示数据
        loadData(); // 加载数据
        add(new JScrollPane(dataPanel), BorderLayout.CENTER); // 将数据面板添加到滚动面板中

        // 底部按钮面板
        JPanel bottomPanel = new JPanel();
        JButton logoutButton = new JButton("登出");
        logoutButton.addActionListener(this::logout); // 绑定登出按钮事件
        bottomPanel.add(logoutButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 设置窗口居中
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadData() {
        // 根据角色动态选择数据表
        String tableName = role.equals("学生") ? "student" : role.equals("老师") ? "teacher" : "admin";

        // 数据库连接和查询
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM `" + tableName + "` WHERE uid = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dataPanel.removeAll(); // 清空之前的数据

                // 动态加载查询到的每一列数据
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    String columnValue = rs.getString(i);

                    dataPanel.add(new JLabel(columnName + ":")); // 列名
                    dataPanel.add(new JLabel(columnValue != null ? columnValue : "N/A")); // 列值
                }

                dataPanel.revalidate(); // 更新界面
                dataPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "未找到对应用户数据！");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "加载数据失败: " + ex.getMessage());
        }
    }

    private void logout(ActionEvent e) {
        // 弹出登出提示框
        JOptionPane.showMessageDialog(this, "已登出！");
        new LoginFrame(); // 返回登录界面
        this.dispose(); // 销毁当前窗口
    }
}
