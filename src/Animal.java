import java.util.Calendar;

public abstract class  Animal {
    private String name;
    private int birthYear;
    private int age;
    private int allPoint = 0;
    private int beautyPoint=0;
    private int bahaviourPoint=0;
    private int startNum;


    public Animal(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = calculateAge();
    }
    private int calculateAge(){
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        return actualYear-birthYear;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setBeautyPoint(int beautyPoint) {
        this.beautyPoint = beautyPoint;
        calculateAllPoint();
    }

    public void setBahaviourPoint(int bahaviourPoint) {
        this.bahaviourPoint = bahaviourPoint;
        calculateAllPoint();
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public void calculateAllPoint(){
        allPoint=bahaviourPoint+beautyPoint;
    }
}
