package lee.concurrent;

public class MyRunnable implements Runnable {
//    thread.interrupt() 是设置线程中断标志位 stop()方法已经弃用
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.setName("happy boy");
        thread.start();
        Thread.sleep(5000L);
        thread.interrupt();

    }
}
