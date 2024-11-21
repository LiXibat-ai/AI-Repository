package ExpThree;

public class Course {
    private static final String USER_DATA_FILE = "d:/Course.txt";
    private String courseNumber; // �γ̺�
    private String courseName; // �γ���
    private String teacherEmployeeId; // �ڿ���ʦ����
    private double credits; // ѧ��
    private String semester; // ����ѧ��


    // ���캯��
    public Course(String courseNumber, String courseName, String teacherEmployeeId,double credits, String semester) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.teacherEmployeeId = teacherEmployeeId;
        this.credits = credits;
        this.semester = semester;
    }

    // Ĭ�Ϲ��캯��
    public Course() {
    }

    // Getter �� Setter ����
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

    // �������������γ���صĹ��ܷ���
}
