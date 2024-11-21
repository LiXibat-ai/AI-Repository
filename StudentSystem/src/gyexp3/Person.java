package gyexp3;

// 父类 Person
public class Person {
    private String name;
    private int age;
    private String id;

    // 构造方法
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 设置姓名
    public void setName(String name) {
        this.name = name;
    }

    // 获取年龄
    public int getAge() {
        return age;
    }

    // 设置年龄
    public void setAge(int age) {
        this.age = age;
    }

    // 获取ID
    public String getId() {
        return id;
    }

    // 设置ID
    public void setId(String id) {
        this.id = id;
    }

    // 显示个人信息
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", ID: " + id);
    }
}
