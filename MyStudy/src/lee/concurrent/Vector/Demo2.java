package lee.concurrent.Vector;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo2 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add("demo"+i);
        }
        for (int i = 0; i <4 ; i++) {
            new Thread(()->{
                list.forEach(e->{
                    if (e.equals("demo2")){
                        list.remove(e);
                    }
                });
            }).start();
        }

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String next = (String)iterator.next();
//            if (next.equals("demo2")){
//                iterator.remove();
//            }
//        }
    }
}
