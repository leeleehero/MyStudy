package lee.chapter1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class La {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aaa", "lll", "ccc");
        Collections.sort(strings,(a,b)->a.compareTo(b));
        System.out.println(strings);
        new Thread(()-> System.out.println("123")).start();
    }
}
