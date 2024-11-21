package ExpThree;

public class Admin extends User {
    private String employeeId; // ����
    private String name; // ����
    private String responsibleCollege; // �ֹ�ѧԺ

    // ���캯��
    public Admin(String username, String password, String userDataFile, String employeeId, String name, String responsibleCollege) {
        super(username, password, userDataFile);
        this.employeeId = employeeId;
        this.name = name;
        this.responsibleCollege = responsibleCollege;
    }
    public Admin(String username, String password,String userDataFile) {
        super(username, password, userDataFile);

    }

    // Ĭ�Ϲ��캯��
    public Admin() {
        super();
    }

    // Getter �� Setter ����
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsibleCollege() {
        return responsibleCollege;
    }

    public void setResponsibleCollege(String responsibleCollege) {
        this.responsibleCollege = responsibleCollege;
    }

    // ����������������Ա��صĹ��ܷ���
}
