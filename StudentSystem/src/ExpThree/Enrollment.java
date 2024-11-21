package ExpThree;

public class Enrollment {
    private static final String USER_DATA_FILE = "d:/Enrollment.txt";
    private String studentId; // 学号
    private String courseNumber; // 课程号
    private double score; // 成绩

    // 构造函数
    public Enrollment(String studentId, String courseNumber, double score) {
        this.studentId = studentId;
        this.courseNumber = courseNumber;
        this.score = score;
    }

    // 默认构造函数
    public Enrollment() {
    }

    // Getter 和 Setter 方法
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // 可以添加其他与选课相关的功能方法
}
