package ExpThree;

public class StudentSystem {

    public static void main(String[] args) {
//        Student u1 = new Student("hong11","1234561","d:/students.txt");
//        u1.register(u1.getUsername(),u1.getPassword());
//        u1.login(u1.getUsername(),u1.getPassword());
        Teacher u2= new Teacher("hong11","1234561","d:/teachers.txt");
        u2.register(u2.getUsername(),u2.getPassword());
        u2.login(u2.getUsername(),u2.getPassword());
//        Admin u3 = new Admin("hong11","1234561","d:/admin.txt");
//        u3.register(u3.getUsername(),u3.getPassword());
//        u3.login(u3.getUsername(),u3.getPassword());


    }
}
