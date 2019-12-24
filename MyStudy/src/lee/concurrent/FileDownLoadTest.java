package lee.concurrent;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FileDownLoadTest {


    private static final int TCOUNT = 10;

    private CountDownLatch latch = new CountDownLatch(TCOUNT);

    private long completeLength = 0;

    private long fileLength;
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        long begin = System.currentTimeMillis();
        new FileDownLoadTest().download("http://test1.com");
        System.out.println(System.currentTimeMillis() - begin);
    }


    public void download(String address) throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(TCOUNT);
        URL url = new URL(address);
        URLConnection cn = url.openConnection();
        cn.setRequestProperty("Referer", "http://www.test.com");
        fileLength = cn.getContentLength();
        long packageLength = fileLength/TCOUNT;
        long leftLength = fileLength%TCOUNT;
        RandomAccessFile file = new RandomAccessFile("test.rar","rw");
        //计算每个线程请求文件的开始和结束位置
        long pos = 0;
        long endPos = pos + packageLength;
        for(int i=0; i<TCOUNT; i++){
            if(leftLength >0){
                endPos ++;
                leftLength--;
            }
            service.execute(new DownLoadThread(url, file, pos, endPos));
            pos = endPos;
        }
        latch.await();
    }

    class DownLoadThread implements Runnable{

        private URL url;
        private RandomAccessFile file;
        private long from;
        private long end;

        DownLoadThread(URL url, RandomAccessFile file, long from, long end){
            this.url = url;
            this.file = file;
            this.from = from;
            this.end = end;
        }


        public void run() {
            long pos = from;
            byte[] buf = new byte[512];
            try {
                HttpURLConnection cn = (HttpURLConnection) url.openConnection();
                cn.setRequestProperty("Range", "bytes=" + from + "-" + end);
                if(cn.getResponseCode() != 200 && cn.getResponseCode()!=206){
                    run();
                    return;
                }
                BufferedInputStream bis = new BufferedInputStream(cn.getInputStream());
                int len ;
                while((len = bis.read(buf)) != -1){
                    synchronized(file){
                        file.seek(pos);
                        file.write(buf, 0, len);
                    }
                    pos += len;
                    completeLength +=len;
                    System.out.println(completeLength * 100 /fileLength + "%");
                }
                cn.disconnect();
                latch.countDown();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}