package ExpThree;

public class Course {
    private static final String USER_DATA_FILE = "d:/Course.txt";
    private String courseNumber; // 课程号
    private String courseName; // 课程名
    private String teacherEmployeeId; // 授课老师工号
    private double credits; // 学分
    private String semester; // 开课学期


    // 构造函数
    public Course(String courseNumber, String courseName, String teacherEmployeeId,double credits, String semester) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.teacherEmployeeId = teacherEmployeeId;
        this.credits = credits;
        this.semester = semester;
    }

    // 默认构造函数
    public Course() {
    }

    // Getter 和 Setter 方法
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherEmployeeId() {
        return teacherEmployeeId;
    }

    public void setTeacherEmployeeId(String teacherEmployeeId) {
        this.teacherEmployeeId = teacherEmployeeId;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    // 可以添加其他与课程相关的功能方法
}
