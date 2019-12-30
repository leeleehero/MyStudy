package lee.chapter4;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        integers.stream().parallel().forEach(System.out::println);

        // arraylist 线程不安全
//        List list = new ArrayList();
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0 ;i < 10 ;i ++){
            IntStream.range(0,100).parallel().forEach(list::add);
        }
        System.out.println(list.size());
    }
}
