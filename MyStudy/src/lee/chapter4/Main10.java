package lee.chapter4;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main10 {
    public static void main(String[] args) {
        List<VideoOrder> videoOrders1 = Arrays.asList(new VideoOrder("20190242812", "springboot", 3),new VideoOrder("20194350812", "ۓ๐ஙSpringCloud", 5),new VideoOrder("20190814232", "Redisරᑕ", 9), new VideoOrder("20190523812", "ᑕරݎ୏ᶭᗑ", 9),new VideoOrder("201932324", "౴ਫݎଚӡጯNetty", 9));
        List<VideoOrder> videoOrders2 = Arrays.asList(new VideoOrder("2019024285312", "springboot", 3),new VideoOrder("2019081453232", "Redisරᑕ", 9),new VideoOrder("20190522338312", "ᑕරݎ୏ᶭᗑ", 9),new VideoOrder("2019435230812", "Jmeterᦶၥێܴ", 5), new VideoOrder("2019323542411", "Git+Jenkins೮ᖅᵞ౮", 7),new VideoOrder("2019323542424", "Ideaᑕරॺق", 21));
        List<VideoOrder> videoOrders = new ArrayList<>();
        //1.
        List<VideoOrder> collect = videoOrders1.stream().filter(videoOrders2::contains).collect(Collectors.toList());
        for (VideoOrder videoOrder : collect) {
            System.out.println(videoOrder.getTitle());
        }
        double v = videoOrders1.stream().collect(Collectors.averagingInt(VideoOrder::getMoney)).doubleValue();
        System.out.println("1.平均值"+v);
        double v1 = videoOrders2.stream().collect(Collectors.averagingInt(VideoOrder::getMoney)).doubleValue();
        System.out.println("2.平均值"+v1);
        long sum = videoOrders1.stream().collect(Collectors.summarizingInt(VideoOrder::getMoney)).getSum();
        System.out.println("1.商品求和"+sum);
        long sum1 = videoOrders2.stream().collect(Collectors.summarizingInt(VideoOrder::getMoney)).getSum();
        System.out.println("2.商品求和"+sum1);
    }
    public static class VideoOrder {
        private String tradeNo;
        private int money;
        private String title;
        public VideoOrder(String tradeNo,String title, int money ){        this.tradeNo = tradeNo;        this.title = title;        this.money = money;    }    public String getTradeNo() {        return tradeNo;    }
        public void setTradeNo(String tradeNo) {        this.tradeNo = tradeNo;    }
        public int getMoney() {        return money;    }
        public void setMoney(int money) {        this.money = money;    }
        public String getTitle() {        return title;    }
        public void setTitle(String title) {        this.title = title;    }
    }
}
