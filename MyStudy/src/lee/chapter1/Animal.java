package lee.chapter1;

public interface Animal {
    void run();
    void eat();
    default void test(){
        System.out.println("default 方法");
    }
    static void test2(){
        System.out.println("static 方法");
    }
}
