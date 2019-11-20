package lee.concurrent.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 		await(),进入等待的状态
 * 		countDown(),计数器减一
 * 		应用场景：启动三个线程计算，需要对结果进行累加。
 */
public class Demo1 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(8);

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("比赛结束");
        }).start();

        for (int i = 0; i < 8; i++) {
            int finalI = i;

                new Thread(() -> {
                    try {
                        Thread.sleep(finalI * 1000L);
                        System.out.println("第" + finalI + "选手");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }

                }).start();
        }

    }
}
