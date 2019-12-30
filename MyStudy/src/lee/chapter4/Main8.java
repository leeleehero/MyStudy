package lee.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main8 {
    public static void main(String[] args) {
        List<Main7.Student1> student1s = Arrays.asList(new Main7.Student1("南京", "23"), new Main7.Student1("南京", "23"),
                new Main7.Student1("镇江", "23"), new Main7.Student1("无锡", "23"), new Main7.Student1("苏州", "23"),
                new Main7.Student1("南京", "23"), new Main7.Student1("南京", "23"), new Main7.Student1("丹阳", "23"),
                new Main7.Student1("成都", "23"));
        Map<String, Long> collect = student1s.stream().collect(Collectors.groupingBy(obj -> obj.getAddress(), Collectors.counting()));
        collect.forEach((key,value)->{
            System.out.println(key+"有"+value);
        });
    }
}
