package lee.concurrent.communcation.Consumer;

public class Medium {
    private int num = 0;
    public static final int TOTAL = 100;
    //获取生产数据
    public synchronized void put() throws InterruptedException {
        //判断库存是否已满
        if (num<TOTAL){
            //如果不是，那就通知生产者生产，在通知消费者
            System.out.println("新增操作-----当前库存="+ num++);
            notifyAll();
        }else {
            //如果已满，生产者就进行等待
            System.out.println("新增操作-----库存已满"+ num);
            wait();
        }

    }
    //获取消费数据
    public synchronized void take() throws InterruptedException {
        //判断当前库存是否已满
        if (num>0){
            //如果库存充足，先通知消费者消费再通知生产者生产
            System.out.println("消费者----当前库存"+ num--);
            notifyAll();
        }else {
            //如果库存不足，消费者进行等待
            System.out.println("生产者库存不足---当前库存"+num);
            wait();
        }


    }
}
