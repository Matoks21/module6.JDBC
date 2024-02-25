package task4;


public class YoungestAndEldestWorker {
    private final String name;
    private final String birthday;
    private final int age;


    public YoungestAndEldestWorker(String name, String birthday, int age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }
}
