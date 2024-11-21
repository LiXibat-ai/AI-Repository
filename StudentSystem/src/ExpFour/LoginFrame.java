package ExpFour;

import java.awt.*;
import ExpThree.*;
import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton;
    private JButton registerButton;
    private User user;


    public LoginFrame() {
        setTitle("学生信息管理系统登录界面");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // 创建面板用于放置所有组件
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // 用户名标签和文本字段
        JLabel usernameLabel = new JLabel("用户名:");
        usernameLabel.setHorizontalAlignment(JLabel.RIGHT);
        usernameField = new JTextField(20);
        panel.add(usernameLabel);
        panel.add(usernameField);

        // 密码标签和文本字段
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
        passwordField = new JPasswordField(20);
        panel.add(passwordLabel);
        panel.add(passwordField);

        // 角色下拉框
        JLabel roleLabel = new JLabel("角色:");
        roleLabel.setHorizontalAlignment(JLabel.RIGHT);
        String[] roles = {"学生", "老师", "管理员"};
        roleComboBox = new JComboBox<>(roles);
        panel.add(roleLabel);
        panel.add(roleComboBox);

        // 登录按钮
        loginButton = new JButton("登录");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // 检查用户名和密码是否为空
            if (username.trim().isEmpty() || password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "用户名和密码不能为空，请重新输入！", "输入错误", JOptionPane.ERROR_MESSAGE);
            } else {
               user = roles();
                // 调用 login 函数进行验证
                boolean loginSuccess = user.login(username, password);
                if (loginSuccess) {
                    JOptionPane.showMessageDialog(null, username+"登录成功！", "登录结果", JOptionPane.INFORMATION_MESSAGE);
                    // 这里可以添加登录成功后的逻辑
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！", "登录失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        // 注册按钮
        registerButton = new JButton("注册");
        // 注册按钮的逻辑可以根据需要添加
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // 检查用户名和密码是否为空
            if (username.trim().isEmpty() || password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "用户名和密码不能为空，请重新输入！", "输入错误", JOptionPane.ERROR_MESSAGE);
            } else {
                user = roles();
                // 调用 register 函数进行注册
                boolean registerSuccess = user.register(username, password);
                if (registerSuccess) {
                    JOptionPane.showMessageDialog(null, username + "注册成功！请补充个人信息。", "注册结果", JOptionPane.INFORMATION_MESSAGE);
                    new userFrame((String) roleComboBox.getSelectedItem(),username);
                    // 这里可以添加注册成功后的逻辑
                } else {
                    JOptionPane.showMessageDialog(null, "用户已存在，请重试或联系管理员！", "注册失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(registerButton);

        // 添加面板到主框架
        add(panel);

        // 设置界面可见
        setVisible(true);
    }
    public User roles(){
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        switch ((String) roleComboBox.getSelectedItem()) {
            case "学生":
                user = new Student(username, password, "d:/students.txt");
                break;
            case "老师":
                user = new Teacher(username, password, "d:/teachers.txt");
                break;
            case "管理员":
                user = new Admin(username, password, "d:/admins.txt");
                break;
        }
        return user;
    }



    public static void main(String[] args) {
        // 设置Swing界面的look and feel为系统默认
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new LoginFrame();
    }
}
