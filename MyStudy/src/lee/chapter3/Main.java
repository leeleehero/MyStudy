package lee.chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("vvvasda", "bsasd", "lqeasd","aaaaaaaaaaa");
//        List<String> collect = list.stream().map(obj -> "name" + obj).collect(Collectors.toList());
//        collect.forEach(obj-> System.out.println(obj));
//
//        List<String> collect1 = list.stream().sorted(Comparator.comparing(obj -> obj.length(),Comparator.reverseOrder())).collect(Collectors.toList());
//        collect1.forEach(obj-> System.out.println(obj));

        List<String> collect2 = list.stream().sorted(Comparator.comparing(String::length).reversed()).limit(2).collect(Collectors.toList());
        collect2.forEach(obj-> System.out.println(obj));


        boolean b = list.stream().allMatch(obj -> obj.length() > 1);
        System.out.println(b);
    }
}
