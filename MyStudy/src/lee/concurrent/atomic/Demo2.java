package lee.concurrent.atomic;

import java.util.concurrent.atomic.LongAccumulator;

public class Demo2 {
    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator((left,right)->
            right>left?right:left,0L
        );
        longAccumulator.accumulate(3L);
        System.out.println(longAccumulator.get());
    }
}
