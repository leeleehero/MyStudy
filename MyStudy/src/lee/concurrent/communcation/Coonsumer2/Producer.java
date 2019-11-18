package lee.concurrent.communcation.Coonsumer2;

public class Producer implements Runnable {

    private Medium medium;
    Producer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        while (true){
            medium.put();
        }
    }
}
