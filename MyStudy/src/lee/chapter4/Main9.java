package lee.chapter4;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main9 {
    public static void main(String[] args) {
        List<Main7.Student1> student1s = Arrays.asList(new Main7.Student1("南京", "23"), new Main7.Student1("南京", "23"),
                new Main7.Student1("镇江", "23"), new Main7.Student1("无锡", "23"), new Main7.Student1("苏州", "23"),
                new Main7.Student1("南京", "21"), new Main7.Student1("南京", "23"), new Main7.Student1("丹阳", "23"),
                new Main7.Student1("成都", "23"));
        IntSummaryStatistics collect = student1s.stream().collect(Collectors.summarizingInt(obj -> Integer.valueOf(obj.getAge())));
        System.out.println(collect.getAverage());
        System.out.println(collect.getMin());
        System.out.println(collect.getMax());
    }
}
