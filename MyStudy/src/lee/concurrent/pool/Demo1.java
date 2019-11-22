package lee.concurrent.pool;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingDeque<Runnable> runnables = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,10,3L, TimeUnit.SECONDS,runnables);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i <20 ; i++) {
            Future<?> submit = executor.submit(() ->  1);
            System.out.println(submit.get());
        }
    }
}
