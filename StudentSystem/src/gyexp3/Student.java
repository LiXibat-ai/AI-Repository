package gyexp3;

// 子类 Student 继承自 Person
public class Student extends Person {
    private String major;

    // 构造方法
    public Student(String name, int age, String id, String major) {
        super(name, age, id);  // 调用父类构造方法
        this.major = major;
    }

    // 获取专业
    public String getMajor() {
        return major;
    }

    // 设置专业
    public void setMajor(String major) {
        this.major = major;
    }

    // 重写父类的显示信息方法
    @Override
    public void displayInfo() {
        super.displayInfo();  // 调用父类方法
        System.out.println("Major: " + major);
    }

    // 学生特有方法
    public void study() {
        System.out.println(getName() + " is studying.");
    }
}
