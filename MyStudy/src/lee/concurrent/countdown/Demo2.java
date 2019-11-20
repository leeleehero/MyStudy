package lee.concurrent.countdown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier--栅栏
 * 		允许一组线程相互等待达到一个公共的障碍点，之后再继续执行
 *
 * 	跟countDownLatch的区别
 * 		CountDownLatch一般用于某个线程等待若干个其他线程执行完任务之后，它才执行；不可重复使用
 * 		CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；可重用的
 */
public class Demo2 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for (int i = 0; i <8 ; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(finalI*1000l);
                    System.out.println("第"+ finalI +"名选手");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("开始比赛");
            }).start();
        }
    }
}
