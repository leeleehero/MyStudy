package lee.chapter4;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 5);
        List<Integer> collect = list.stream().collect(Collectors.toList());
        LinkedHashSet<Integer> col = list.stream().collect(Collectors.toCollection(LinkedHashSet::new));

    }
}
