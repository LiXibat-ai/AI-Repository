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
        setTitle("�û�ע��");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ��ɫѡ��
        JPanel topPanel = new JPanel();
        roleComboBox = new JComboBox<>(new String[]{"ѧ��", "��ʦ", "����Ա"});
        roleComboBox.addActionListener(this::updateFormFields);
        topPanel.add(new JLabel("ѡ���ɫ:"));
        topPanel.add(roleComboBox);
        add(topPanel, BorderLayout.NORTH);

        // ��̬������
        dynamicPanel = new JPanel();
        dynamicPanel.setLayout(new GridLayout(0, 2, 10, 10));
        add(dynamicPanel, BorderLayout.CENTER);

        // ע�ᰴť
        JButton registerButton = new JButton("ע��");
        registerButton.addActionListener(this::registerUser);
        add(registerButton, BorderLayout.SOUTH);

        // ��ʾ��ʼ��
        updateFormFields(null);

        // ���ô��ھ���
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateFormFields(ActionEvent e) {
        dynamicPanel.removeAll();
        String role = (String) roleComboBox.getSelectedItem();

        if ("ѧ��".equals(role)) {
            fields = new JTextField[6];
            addField("�û���", 0);
            addField("����", 1);
            addField("ѧ��", 2);
            addField("����", 3);
            addField("�Ա�", 4);
            addField("����ѧԺ", 5);
        } else if ("��ʦ".equals(role)) {
            fields = new JTextField[6];
            addField("�û���", 0);
            addField("����", 1);
            addField("����", 2);
            addField("����", 3);
            addField("�Ա�", 4);
            addField("����ѧԺ", 5);
        } else if ("����Ա".equals(role)) {
            fields = new JTextField[4];
            addField("�û���", 0);
            addField("����", 1);
            addField("����", 2);
            addField("�ֹ�ѧԺ", 3);
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
            if ("ѧ��".equals(role)) {
                sql = "INSERT INTO student (uid, upassword, studentId, name, gender, collegeID) VALUES (?, ?, ?, ?, ?, ?)";
            } else if ("��ʦ".equals(role)) {
                sql = "INSERT INTO teacher (uid, upassword, employeeId, name, gender, collegeID) VALUES (?, ?, ?, ?, ?, ?)";
            } else if ("����Ա".equals(role)) {
                sql = "INSERT INTO admin (uid, upassword, employeeId, responsibleCollegeId) VALUES (?, ?, ?, ?)";
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (int i = 0; i < fields.length; i++) {
                    pstmt.setString(i + 1, fields[i].getText());
                }
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "ע��ɹ���");
                dispose(); // �ر�ע�ᴰ��
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ע��ʧ��: " + ex.getMessage(), "����", JOptionPane.ERROR_MESSAGE);
        }
    }
}
