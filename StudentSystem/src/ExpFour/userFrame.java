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
        setTitle("个人信息补充 - " + role);
        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.CLOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));
        if (role.equals("学生")) {
            // 添加字段
            addField("学号:");
            addField("姓名:");
            addField("性别:");
            addField("出生年月:");
            addField("入学年份:");
            addField("所属学院:");
        }
        else if (role.equals("老师")) {
            addField("工号:");
            addField("姓名:");
            addField("性别:");
//            addField("授课课程号:");
            addField("所属学院:");

        } else if (role.equals("管理员")) {
            addField("工号:");
            addField("分管学院:");

        }

        // 保存按钮
        saveButton = new JButton("保存");
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
        String userDataFile = role.equals("学生") ? "d:/students.txt" : role.equals("老师") ? "d:/teachers.txt" : "d:/admins.txt";
        // 假设已在登录界面获取用户名
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名未设置或为空！");
            return;
        }
        String info = username;

        for (Map.Entry<String, JTextField> entry : fields.entrySet()) {
            info += "#" + entry.getValue().getText();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(userDataFile, true))) {
            out.println(info);
            JOptionPane.showMessageDialog(null, "信息保存成功！");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "保存失败: " + ex.getMessage());
        }
        this.dispose(); // 关闭窗口
    }
}
