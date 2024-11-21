package gyexp3;

// ���� Student �̳��� Person
public class Student extends Person {
    private String major;

    // ���췽��
    public Student(String name, int age, String id, String major) {
        super(name, age, id);  // ���ø��๹�췽��
        this.major = major;
    }

    // ��ȡרҵ
    public String getMajor() {
        return major;
    }

    // ����רҵ
    public void setMajor(String major) {
        this.major = major;
    }

    // ��д�������ʾ��Ϣ����
    @Override
    public void displayInfo() {
        super.displayInfo();  // ���ø��෽��
        System.out.println("Major: " + major);
    }

    // ѧ�����з���
    public void study() {
        System.out.println(getName() + " is studying.");
    }
}
