package lee.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java","spring","c++","springboot","springcloud");
        Map<Boolean, List<String>> collect = list.stream().collect(Collectors.partitioningBy(obj -> obj.length() > 3));
        System.out.println(collect);
    }
}
