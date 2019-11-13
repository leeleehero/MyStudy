package lee.concurrent.Lok;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private boolean isHung = false;

    private Thread thread = null;

    private int num = 0;

    @Override
    public  synchronized void lock() {
        if (isHung && thread != Thread.currentThread()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread = new Thread();
        isHung = true;
        num++;
    }

    @Override
    public  synchronized void unlock() {
        if (thread==Thread.currentThread()){
            notify();
            if (num == 0){
                isHung = false;
                num--;
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
