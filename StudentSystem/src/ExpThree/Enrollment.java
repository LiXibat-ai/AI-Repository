package ExpThree;

public class Enrollment {
    private static final String USER_DATA_FILE = "d:/Enrollment.txt";
    private String studentId; // ѧ��
    private String courseNumber; // �γ̺�
    private double score; // �ɼ�

    // ���캯��
    public Enrollment(String studentId, String courseNumber, double score) {
        this.studentId = studentId;
        this.courseNumber = courseNumber;
        this.score = score;
    }

    // Ĭ�Ϲ��캯��
    public Enrollment() {
    }

    // Getter �� Setter ����
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

    // �������������ѡ����صĹ��ܷ���
}
