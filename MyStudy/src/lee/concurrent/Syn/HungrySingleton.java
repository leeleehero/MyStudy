package lee.concurrent.Syn;
// 饿汉式--本身线程安全
// 在类加载的时候，就已经进行实例化，无论之后用不用到。如果该类比较占内存，之后又没用到，就白白浪费了资源。
public class HungrySingleton {
    private HungrySingleton(){
    }
    public static HungrySingleton instance = new HungrySingleton();
    public static HungrySingleton getInstance(){
        return instance;
    }
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                System.out.println(HungrySingleton.getInstance());
            }).start();
        }
    }
}
