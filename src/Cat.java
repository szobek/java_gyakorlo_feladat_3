public class Cat extends Animal{
    boolean box=false;
    public Cat(String name, int birthYear) {
        super(name, birthYear);
    }

    public void setBox(boolean box) {
        this.box = box;
    }
}
