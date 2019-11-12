package lee.concurrent.Syn;

public class LazySingleton {

    public static volatile LazySingleton instance = null;

    public static LazySingleton getInstance() throws InterruptedException {
        Thread.sleep(5000L);
        if (null==instance) {
            synchronized (LazySingleton.class) {
                if (null == instance) {
                     instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    private LazySingleton(){};

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    System.out.println(LazySingleton.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
