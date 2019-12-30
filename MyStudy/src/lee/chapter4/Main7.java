package lee.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) {
        List<Student1> student1s = Arrays.asList(new Student1("南京", "23"), new Student1("南京", "23"),
                new Student1("镇江", "23"), new Student1("无锡", "23"), new Student1("苏州", "23"),
                new Student1("南京", "23"), new Student1("南京", "23"), new Student1("丹阳", "23"),
                new Student1("成都", "23"));
        Map<String, List<Student1>> collect = student1s.stream().collect(Collectors.groupingBy(student1 -> student1.getAddress()));
        collect.forEach((key,value)->{
            System.out.println("============");
            System.out.println(key);
            value.forEach(obj->{
                System.out.println(obj.getAge());
            });
        });
    }
    static class Student1{
        private String address;
        private String age;

        public Student1(){};
        public Student1(String address,String age){
            this.address = address;
            this.age = age;
        }
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}

