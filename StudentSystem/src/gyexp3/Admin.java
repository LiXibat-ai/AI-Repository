package gyexp3;

// ���� Admin �̳��� Person
public class Admin extends Person {
    private String role;

    // ���췽��
    public Admin(String name, int age, String id, String role) {
        super(name, age, id);  // ���ø��๹�췽��
        this.role = role;
    }

    // ��ȡ��ɫ
    public String getRole() {
        return role;
    }

    // ���ý�ɫ
    public void setRole(String role) {
        this.role = role;
    }

    // ��д�������ʾ��Ϣ����
    @Override
    public void displayInfo() {
        super.displayInfo();  // ���ø��෽��
        System.out.println("Role: " + role);
    }

    // ����Ա���з���
    public void manage() {
        System.out.println(getName() + " is managing the system as " + role + ".");
    }
}
