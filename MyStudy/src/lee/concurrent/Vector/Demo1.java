package lee.concurrent.Vector;

import java.util.Iterator;
import java.util.Vector;

public class Demo1 {
    public static void main(String[] args) {
        Vector<String> strings = new Vector<>();
        for (int i = 0; i <10 ; i++) {
            strings.add("e"+i);
        }
        Iterator<String> stringIterator = strings.iterator();
        for (int i = 0; i <10 ; i++) {
            synchronized (stringIterator){
                new Thread(()->{
                    while (stringIterator.hasNext()){
                        String next = stringIterator.next();
                        if (next.equals("e3")){
                            stringIterator.remove();
                        }
                    }
                }).start();
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
