package lee.concurrent.communcation.Join;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"线程开始");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程结束");
        },"线程1");
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"线程开始");
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程结束");
        },"线程2").start();
    }
}
