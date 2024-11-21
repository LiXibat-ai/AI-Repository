package ExpThree;

public class Admin extends User {
    private String employeeId; // 工号
    private String name; // 姓名
    private String responsibleCollege; // 分管学院

    // 构造函数
    public Admin(String username, String password, String userDataFile, String employeeId, String name, String responsibleCollege) {
        super(username, password, userDataFile);
        this.employeeId = employeeId;
        this.name = name;
        this.responsibleCollege = responsibleCollege;
    }
    public Admin(String username, String password,String userDataFile) {
        super(username, password, userDataFile);

    }

    // 默认构造函数
    public Admin() {
        super();
    }

    // Getter 和 Setter 方法
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

    // 可以添加其他与管理员相关的功能方法
}
