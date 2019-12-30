package lee.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(44), new Student(33), new Student(22), new Student(11));
//        Optional<Student> max = students.stream().max((a, b) -> {
//            return Integer.compare(a.getAge(), b.getAge());
//        });
//        Student student = max.get();
//        System.out.println(student.getAge());
        Optional<Student> min = students.stream().min((a, b) -> {
            return Integer.compare(a.getAge(), b.getAge());
        });
        Student student = min.get();
        System.out.println(student.getAge());
    }
}
class Student{
    private int age;

    public Student(int age){
        this.age = age ;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}