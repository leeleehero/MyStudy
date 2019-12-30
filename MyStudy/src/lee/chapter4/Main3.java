package lee.chapter4;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {
        Integer res = Stream.of(1, 2, 3, 4, 5, 6).reduce(100, (item1, item2) -> item1 + item2);
        System.out.println(res);
        Integer res2 = Stream.of(1, 2, 3, 4, 5).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        }).get();
        System.out.println(res2);
    }
}
