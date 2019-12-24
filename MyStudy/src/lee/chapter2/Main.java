package lee.chapter2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer,Integer> function = P->{
            System.out.println("function函数");
            return P*1000;
        };
        Integer apply = function.apply(100);
        System.out.println(apply);

        System.out.println(Operator(6,5,(a,b)->a*b));
    }

    public static Integer Operator(Integer a, Integer b, BiFunction<Integer,Integer,Integer> bf){
        return bf.apply(a,b);
    }
}
