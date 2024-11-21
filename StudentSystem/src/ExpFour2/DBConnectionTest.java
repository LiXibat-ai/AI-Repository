package ExpFour2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest extends JFrame {
    private JButton testConnectionButton;

    public DBConnectionTest() {
        setTitle("�������ݿ�����");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        testConnectionButton = new JButton("�������ݿ�����");
        testConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testConnection();
            }
        });

        add(testConnectionButton);
    }

    private void testConnection() {
        try {
            Connection conn = DBConnection.getConnection();
            if (conn != null && !conn.isClosed()) {
                JOptionPane.showMessageDialog(this,
                        "���ݿ����ӳɹ���",
                        "�ɹ�",
                        JOptionPane.INFORMATION_MESSAGE);
                conn.close(); // �ر�����
            } else {
                JOptionPane.showMessageDialog(this,
                        "���ݿ�����ʧ�ܣ����Ӷ���Ϊnull���ѹرա�",
                        "ʧ��",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "���ݿ�����ʧ�ܣ�" + ex.getMessage(),
                    "ʧ��",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DBConnectionTest frame = new DBConnectionTest();
            frame.setVisible(true);
        });
    }
}
