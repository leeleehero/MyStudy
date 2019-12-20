package lee.chapter1;

public class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("dog run");
    }

    @Override
    public void eat() {
        System.out.println("dog eat");
    }
}
