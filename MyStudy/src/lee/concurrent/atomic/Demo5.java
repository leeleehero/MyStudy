package lee.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class Demo5 {
    public static void main(String[] args) {
        Student student = new Student("1","A");
        Student student1 = new Student("2", "B");
        AtomicReference<Student> ato = new AtomicReference<>();
        ato.set(student);
        boolean b = ato.compareAndSet(student, student1);
        System.out.println(b);
        Student student2 = ato.get();
        System.out.println(student2.getId()+":"+student2.getName());
    }
}

