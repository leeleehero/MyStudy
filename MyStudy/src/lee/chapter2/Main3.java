package lee.chapter2;

import java.util.function.Supplier;

public class Main3 {
    public static void main(String[] args) {

    }

    public static Student makeStudnet(){
        Supplier<Student> stu = () -> {
            Student student1 = new Student();
            student1.setName("li");
            return student1;
        };
        return stu.get();
    }

    static class Student{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
