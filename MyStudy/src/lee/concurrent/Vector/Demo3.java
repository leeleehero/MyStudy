package lee.concurrent.Vector;

import java.util.concurrent.LinkedBlockingDeque;
/**
 * 		并发容器
 * 			CopyOnWrite、Concurrent、BlockingQueue
 * 			根据具体场景进行设计，尽量避免使用锁，提高容器的并发访问性。
 * 			ConcurrentBlockingQueue：基于queue实现的FIFO的队列。队列为空，取操作会被阻塞
 * 			ConcurrentLinkedQueue，队列为空，取得时候就直接返回空
 *
 *
 * LinkedBlockingQueue的使用及其源码探秘
 * 			在并发编程中，LinkedBlockingQueue使用的非常频繁。因其可以作为生产者消费者的中间商
 *
 * 			add  实际上调用的是offer，区别是在队列满的时候，add会报异常
 * 			offer  对列如果满了，直接入队失败
 * 			put("111"); 在队列满的时候，会进入阻塞的状态
 *
 *
 *         	remove(); 直接调用poll，唯一的区别即使remove会抛出异常，而poll在队列为空的时候直接返回null
 *         	poll(); 在队列为空的时候直接返回null
 *         	take(); 在队列为空的时候，会进入等待的状态
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>(10);
        deque.add("lee1");
        deque.offer("lee2");
        deque.put("lee3");
    }
}
