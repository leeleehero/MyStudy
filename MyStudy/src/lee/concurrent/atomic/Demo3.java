package lee.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Demo3 {
    public static void main(String[] args) {
        int [] arr = new int [] {2,3};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        System.out.println(atomicIntegerArray.addAndGet(1, 6));
        System.out.println(atomicIntegerArray.accumulateAndGet(1, 5, ((left, right) -> left * right)));
    }
}
