package lee.concurrent.communcation;
// 不安全的线程 一个线程依赖于另一个线程做出改变
public class Demo {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(!flag){
                System.out.println("flag="+flag);
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(flag);
            }
        }).start();

        Thread.sleep(5000l);
        new Thread(()->{
            flag = true;
            System.out.println(flag);
        }).start();
    }
}
