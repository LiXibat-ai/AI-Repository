package ExpThree;

public class Teacher extends User {
    private String employeeId; // 工号
    private String name; // 姓名
    private String gender; // 性别
//    private String courseNumber; // 授课课程号
    private String college; // 所属学院

    // 构造函数
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

    // 默认构造函数
    public Teacher() {
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

    // 可以添加其他与教师相关的功能方法
}
