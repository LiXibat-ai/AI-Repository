package gyexp3;

// ���� Teacher �̳��� Person
public class Teacher extends Person {
    private String subject;

    // ���췽��
    public Teacher(String name, int age, String id, String subject) {
        super(name, age, id);  // ���ø��๹�췽��
        this.subject = subject;
    }

    // ��ȡ��Ŀ
    public String getSubject() {
        return subject;
    }

    // ���ÿ�Ŀ
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // ��д�������ʾ��Ϣ����
    @Override
    public void displayInfo() {
        super.displayInfo();  // ���ø��෽��
        System.out.println("Subject: " + subject);
    }

    // ��ʦ���з���
    public void teach() {
        System.out.println(getName() + " is teaching " + subject + ".");
    }
}
