package ExpFour;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
public class userFrame extends JFrame {
    private Map<String, JTextField> fields = new HashMap<>();
    private JButton saveButton;
    private String role;
    private String username;

    public userFrame(String role,String username) {
        this.role = role;
        this.username = username;
        setTitle("������Ϣ���� - " + role);
        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.CLOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));
        if (role.equals("ѧ��")) {
            // ����ֶ�
            addField("ѧ��:");
            addField("����:");
            addField("�Ա�:");
            addField("��������:");
            addField("��ѧ���:");
            addField("����ѧԺ:");
        }
        else if (role.equals("��ʦ")) {
            addField("����:");
            addField("����:");
            addField("�Ա�:");
//            addField("�ڿογ̺�:");
            addField("����ѧԺ:");

        } else if (role.equals("����Ա")) {
            addField("����:");
            addField("�ֹ�ѧԺ:");

        }

        // ���水ť
        saveButton = new JButton("����");
        saveButton.addActionListener(this::saveInfo);
        add(new JLabel());
        add(saveButton);

        setVisible(true);
    }

    private void addField(String label) {
        add(new JLabel(label));
        JTextField textField = new JTextField(20);
        fields.put(label, textField);
        add(textField);
    }

    private void saveInfo(ActionEvent e) {
        String userDataFile = role.equals("ѧ��") ? "d:/students.txt" : role.equals("��ʦ") ? "d:/teachers.txt" : "d:/admins.txt";
        // �������ڵ�¼�����ȡ�û���
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "�û���δ���û�Ϊ�գ�");
            return;
        }
        String info = username;

        for (Map.Entry<String, JTextField> entry : fields.entrySet()) {
            info += "#" + entry.getValue().getText();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(userDataFile, true))) {
            out.println(info);
            JOptionPane.showMessageDialog(null, "��Ϣ����ɹ���");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "����ʧ��: " + ex.getMessage());
        }
        this.dispose(); // �رմ���
    }
}
