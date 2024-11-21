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
        setTitle("测试数据库连接");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        testConnectionButton = new JButton("测试数据库连接");
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
                        "数据库连接成功！",
                        "成功",
                        JOptionPane.INFORMATION_MESSAGE);
                conn.close(); // 关闭连接
            } else {
                JOptionPane.showMessageDialog(this,
                        "数据库连接失败，连接对象为null或已关闭。",
                        "失败",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "数据库连接失败：" + ex.getMessage(),
                    "失败",
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
