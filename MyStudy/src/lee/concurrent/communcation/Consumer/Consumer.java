package lee.concurrent.communcation.Consumer;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

public class Consumer implements Runnable{
    private Medium medium;
    Consumer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        try {
            while (true){
                medium.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
