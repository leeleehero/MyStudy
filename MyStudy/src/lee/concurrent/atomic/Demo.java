package lee.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

//2 原子更新基本类型
//		发展至JDk1.8，基本类型原子类有以下几个：
//			AtomicBoolean、AtomicInteger、AtomicLong、DoubleAccumulator、DoubleAdder、
//			LongAccumulator、LongAdder
//		大致可以归为3类
//			AtomicBoolean、AtomicInteger、AtomicLong  元老级的原子更新，方法几乎一模一样
//			DoubleAdder、LongAdder  对Double、Long的原子更新性能进行优化提升
//			DoubleAccumulator、LongAccumulator  支持自定义运算
public class Demo {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void inCreate(){
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j <100 ; j++) {
                    inCreate();
                }
            }).start();
        }
    }
}
