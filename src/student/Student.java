package student;

public class Student {
    private int id;
    private String name;
    private String money;
    private String date;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMoney() {
        return money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Student() {}
    public Student(String name,String money, String date) {
        this.name = name;
        this.money=money;
        this.date=date;
    }
    public Student(int id,String name,String money, String date) {
        this.id=id;
        this.name = name;
        this.money=money;
        this.date=date;
    }
}