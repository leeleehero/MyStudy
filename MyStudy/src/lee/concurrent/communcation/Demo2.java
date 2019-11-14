package lee.concurrent.communcation;
// 不安全的线程 一个线程依赖于另一个线程做出改变
// 线程安全
public class Demo2 {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        new Thread(()->{
            while(!flag){
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("flag="+flag);
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(flag);
            }
        }).start();

        Thread.sleep(5000l);
        new Thread(()->{
            synchronized (object){
                flag = true;
                object.notify();
                System.out.println(flag);
            }

        }).start();
    }
}
