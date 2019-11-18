package lee.concurrent.communcation.Coonsumer2;

public class Consumer implements Runnable{
    private Medium medium;
    Consumer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        while (true){
            medium.take();
        }
    }
}
