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

        // ���ô��ڱ���ʹ�С
        setTitle("�û����� - " + role);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ������Ϣ���
        JPanel topPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("��ӭ, " + username + " (" + role + ")");
        topPanel.add(welcomeLabel);
        add(topPanel, BorderLayout.NORTH);

        // ������ʾ���
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(0, 2, 10, 10)); // ʹ�� GridLayout չʾ����
        loadData(); // ��������
        add(new JScrollPane(dataPanel), BorderLayout.CENTER); // �����������ӵ����������

        // �ײ���ť���
        JPanel bottomPanel = new JPanel();
        JButton logoutButton = new JButton("�ǳ�");
        logoutButton.addActionListener(this::logout); // �󶨵ǳ���ť�¼�
        bottomPanel.add(logoutButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // ���ô��ھ���
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadData() {
        // ���ݽ�ɫ��̬ѡ�����ݱ�
        String tableName = role.equals("ѧ��") ? "student" : role.equals("��ʦ") ? "teacher" : "admin";

        // ���ݿ����ӺͲ�ѯ
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM `" + tableName + "` WHERE uid = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dataPanel.removeAll(); // ���֮ǰ������

                // ��̬���ز�ѯ����ÿһ������
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    String columnValue = rs.getString(i);

                    dataPanel.add(new JLabel(columnName + ":")); // ����
                    dataPanel.add(new JLabel(columnValue != null ? columnValue : "N/A")); // ��ֵ
                }

                dataPanel.revalidate(); // ���½���
                dataPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "δ�ҵ���Ӧ�û����ݣ�");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "��������ʧ��: " + ex.getMessage());
        }
    }

    private void logout(ActionEvent e) {
        // �����ǳ���ʾ��
        JOptionPane.showMessageDialog(this, "�ѵǳ���");
        new LoginFrame(); // ���ص�¼����
        this.dispose(); // ���ٵ�ǰ����
    }
}
