package lee.concurrent.Syn;

import java.util.List;

//修饰普通方法：锁住对象的实例
//修饰静态方法：锁住整个类
// 修饰代码块： 锁住一个对象 synchronized (lock) 即synchronized后面括号里的内容
public class Syn {

    //修饰普通方法：锁住对象的实例
    public synchronized void out() throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println(Thread.currentThread().getName());
    }

    //修饰静态方法：锁住整个类 （建议不要使用会造成死锁）
    public synchronized  static  void staticout() throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println(Thread.currentThread().getName());
    }
    //修饰代码块: 锁住一个对象synchronized (lock) 即synchronized后面括号里的内容
    private Object object = new Object();
    public void syOut() throws InterruptedException {
        synchronized (object){
            Thread.sleep(5000L);
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Syn syn = new Syn();
        new Thread(()->{
            try {
                syn.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        Syn syn2 = new Syn();
        new Thread(()->{
            try {
                syn2.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
