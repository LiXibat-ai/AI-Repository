package gyexp3;

// ������ Test
public class Test {
    public static void main(String[] args) {
        // ��������
        Person student = new Student("Alice", 20, "S001", "Computer Science");
        Person teacher = new Teacher("Mr. Smith", 45, "T001", "Mathematics");
        Person admin = new Admin("Ms. Johnson", 35, "A001", "System Administrator");

        // ʹ�ö�̬���� displayInfo ����
        student.displayInfo();
        teacher.displayInfo();
        admin.displayInfo();

        // ͨ������ת�͵������з���
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
