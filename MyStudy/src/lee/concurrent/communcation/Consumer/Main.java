package lee.concurrent.communcation.Consumer;

public class Main {
    public static void main(String[] args) {
        Medium medium = new Medium();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();



        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();
    }
}
