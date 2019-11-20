package lee.concurrent.countdown;

import java.util.concurrent.Exchanger;

public class Demo4 {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        String s1 = "old";
        String s2 = "new";
        new Thread(()->{
            try {
                String exchange = stringExchanger.exchange(s1);
                System.out.println(Thread.currentThread().getName()+"==="+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start(); new Thread(()->{
            try {
                String exchange = stringExchanger.exchange(s2);
                System.out.println(Thread.currentThread().getName()+"==="+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();
        new Thread(()->{
            try {
                String exchange = stringExchanger.exchange(s1);
                System.out.println(Thread.currentThread().getName()+"==="+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程3").start();
    }
}
