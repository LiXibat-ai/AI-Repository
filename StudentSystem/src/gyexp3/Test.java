package gyexp3;

// 测试类 Test
public class Test {
    public static void main(String[] args) {
        // 创建对象
        Person student = new Student("Alice", 20, "S001", "Computer Science");
        Person teacher = new Teacher("Mr. Smith", 45, "T001", "Mathematics");
        Person admin = new Admin("Ms. Johnson", 35, "A001", "System Administrator");

        // 使用多态调用 displayInfo 方法
        student.displayInfo();
        teacher.displayInfo();
        admin.displayInfo();

        // 通过向下转型调用特有方法
        if (student instanceof Student) {
            ((Student) student).study();
        }
        if (teacher instanceof Teacher) {
            ((Teacher) teacher).teach();
        }
        if (admin instanceof Admin) {
            ((Admin) admin).manage();
        }
    }
}
