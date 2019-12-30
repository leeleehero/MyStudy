package lee.chapter4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main5 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 55);
        String collect = Stream.of("1", "2").collect(Collectors.joining());
        System.out.println(collect);
    }
}
