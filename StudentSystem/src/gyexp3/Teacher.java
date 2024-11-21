package gyexp3;

// 子类 Teacher 继承自 Person
public class Teacher extends Person {
    private String subject;

    // 构造方法
    public Teacher(String name, int age, String id, String subject) {
        super(name, age, id);  // 调用父类构造方法
        this.subject = subject;
    }

    // 获取科目
    public String getSubject() {
        return subject;
    }

    // 设置科目
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // 重写父类的显示信息方法
    @Override
    public void displayInfo() {
        super.displayInfo();  // 调用父类方法
        System.out.println("Subject: " + subject);
    }

    // 教师特有方法
    public void teach() {
        System.out.println(getName() + " is teaching " + subject + ".");
    }
}
