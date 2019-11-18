package lee.concurrent.communcation.ThreadLocal;

/**
 * 5 ThreadLocal的使用
 * 线程变量，是一个以ThreadLocal对象为键、任意对象为值的存储结构。为每个线程单独存放一份变量副本，也就是说一个线程可以根据一个ThreadLocal对象查询到绑定在这个线程上的一个值。
 * 只要线程处于活动状态并且ThreadLocal实例可访问，那么每个线程都拥有对其本地线程副本的隐式引用变量一个线程消失后，它的所有副本线程局部实例受垃圾回收（除非其他存在对这些副本的引用）
 * <p>
 * 一般用的比较多的是
 * 1、ThreadLocal.get: 获取ThreadLocal中当前线程共享变量的值。
 * 2、ThreadLocal.set: 设置ThreadLocal中当前线程共享变量的值。
 * 3、ThreadLocal.remove: 移除ThreadLocal中当前线程共享变量的值。
 * 4、ThreadLocal.initialValue: ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值。
 **/

public class ThreadLocalDemo {
    ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);

    public void inCrete() throws InterruptedException {
        Integer cnt = num.get();
        cnt++;
        Thread.sleep(10000L);
        System.out.println(Thread.currentThread().getName() + "===" + cnt);
        num.set(cnt);
    }
    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    try {
                        threadLocalDemo.inCrete();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(finalI * 5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }


}
