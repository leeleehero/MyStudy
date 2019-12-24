package lee.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main2 {
    public static void main(String[] args) {
//        Consumer<Integer> consumer = obj ->{
//            System.out.println("consumer");
//        };
        Operator(1,(a)->{
            System.out.println(a);
        });

        List<String> strings = Arrays.asList("aaa", "bbb", "ccc");
        strings.forEach(obj->{
            System.out.println(obj);
        });
    }

    public static void Operator(Integer a,Consumer<Integer> consumer){
        consumer.accept(a);
    }
}
