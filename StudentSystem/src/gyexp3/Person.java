package gyexp3;

// ���� Person
public class Person {
    private String name;
    private int age;
    private String id;

    // ���췽��
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // ��ȡ����
    public String getName() {
        return name;
    }

    // ��������
    public void setName(String name) {
        this.name = name;
    }

    // ��ȡ����
    public int getAge() {
        return age;
    }

    // ��������
    public void setAge(int age) {
        this.age = age;
    }

    // ��ȡID
    public String getId() {
        return id;
    }

    // ����ID
    public void setId(String id) {
        this.id = id;
    }

    // ��ʾ������Ϣ
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", ID: " + id);
    }
}
