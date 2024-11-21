package gyexp3;

// 子类 Admin 继承自 Person
public class Admin extends Person {
    private String role;

    // 构造方法
    public Admin(String name, int age, String id, String role) {
        super(name, age, id);  // 调用父类构造方法
        this.role = role;
    }

    // 获取角色
    public String getRole() {
        return role;
    }

    // 设置角色
    public void setRole(String role) {
        this.role = role;
    }

    // 重写父类的显示信息方法
    @Override
    public void displayInfo() {
        super.displayInfo();  // 调用父类方法
        System.out.println("Role: " + role);
    }

    // 管理员特有方法
    public void manage() {
        System.out.println(getName() + " is managing the system as " + role + ".");
    }
}
