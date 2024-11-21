package ExpThree;

public class Teacher extends User {
    private String employeeId; // ����
    private String name; // ����
    private String gender; // �Ա�
//    private String courseNumber; // �ڿογ̺�
    private String college; // ����ѧԺ

    // ���캯��
    public Teacher(String username, String password, String userDataFile, String employeeId, String name, String gender,  String college) {
        super(username, password, userDataFile);
        this.employeeId = employeeId;
        this.name = name;
        this.gender = gender;
//        this.courseNumber = courseNumber;
        this.college = college;
    }
    public Teacher (String username, String password, String userDataFile) {
        super(username, password, userDataFile);

    }

    // Ĭ�Ϲ��캯��
    public Teacher() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public String getCourseNumber() {
//        return courseNumber;
//    }
//
//    public void setCourseNumber(String courseNumber) {
//        this.courseNumber = courseNumber;
//    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    // ��������������ʦ��صĹ��ܷ���
}
