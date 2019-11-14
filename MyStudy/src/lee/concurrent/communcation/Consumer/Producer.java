package lee.concurrent.communcation.Consumer;

public class Producer implements Runnable {

    private Medium medium;
    Producer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        try {
            while (true){
                medium.put();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
