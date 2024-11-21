package ExpThree;
public class Student extends User {
//    private String userDataFile ;
    private String studentId; // 学号
    private String name; // 姓名
    private String gender; // 性别
    private String birthDate; // 出生年月
    private String entryYear; // 入学年份
    private String college; // 所属学院

    // 构造函数
    public Student(String username, String password, String userDataFile,String studentId, String name, String gender, String birthDate, String entryYear, String college) {
        super(username, password,userDataFile);
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.entryYear = entryYear;
        this.college = college;
    }
    public Student(String username, String password, String userDataFile) {

        super(username, password, userDataFile);
    }

    // 默认构造函数
    public Student() {
        super();
    }

    // Getter 和 Setter 方法
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    // 可以添加其他与学生相关的功能方法
}
