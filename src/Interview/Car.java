package Interview;

import java.util.*;
import java.util.concurrent.*;

/**
 * 停车场：100个车位，车辆并发进出，使用生产者-消费者（BlockingQueue）模型
 */
public class Car {
    //BlockingQueue 接口；
    //LinkedBlockingQueue 实现类，有界队列
    /** 停车场 */
    static class ParkingLot {
        //可用车位的阻塞队列：停车take；离开put
        private final BlockingQueue<Integer> availableSpots;
        //已停车：车牌 -> 车位
        private final ConcurrentHashMap<String, Integer> occupied = new ConcurrentHashMap<>();

        public ParkingLot(int capacity) {
            //有界队列限制最大车位数
            this.availableSpots = new ArrayBlockingQueue<>(capacity);
            for (int i = 0; i < capacity; i++) {
                //车位编号
                availableSpots.add(i);
            }
        }

        /** 车辆进入：阻塞直到拿到一个空位 */
        public int park(String plate) throws InterruptedException {
            //没空位阻塞等待
            int spot = availableSpots.take();
            //车牌对应车位
            occupied.put(plate, spot);
            System.out.printf("[IN ] %s 停在车位 #%d，当前已占用：%d%n",
                    plate, spot, occupied.size());
            return spot;
        }

        /** 车辆离开：释放对应车位（若不在场，忽略） */
        public void leave(String plate) throws InterruptedException {
            Integer spot = occupied.remove(plate);
            if (spot != null) {
                //出队，队列空时等待
                availableSpots.put(spot);
                System.out.printf("[OUT] %s 离开车位 #%d，当前已占用：%d%n",
                        plate, spot, occupied.size());
            } else {
                System.out.printf("[WARN] %s 不在停车场，无法出库%n", plate);
            }
        }

        public int totalCapacity() { return availableSpots.size() + occupied.size(); }
        public int occupiedCount() { return occupied.size(); }

    }

    /** 车辆任务：进场 -> 停一会儿 -> 出场 */
    static class CarTask implements Runnable {
        private final String plate;
        private final ParkingLot lot;
        private final int parkMillis; // 停车时间

        public CarTask(String plate, ParkingLot lot, int parkMillis) {
            this.plate = plate;
            this.lot = lot;
            this.parkMillis = parkMillis;
        }

        @Override
        public void run() {
            try {
                lot.park(plate);
                Thread.sleep(parkMillis);  // 模拟停车占用时间
                lot.leave(plate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("[INTERRUPTED] %s%n", plate);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int capacity = 100;
        final ParkingLot lot = new ParkingLot(capacity);

        // 线程池模拟大量车辆并发进出
        ExecutorService pool = Executors.newFixedThreadPool(32);
        Random rnd = new Random();

        // 连续“生产”车辆任务（既是占位消费者，也是释放位的生产者）
        int cars = 300; // 模拟 300 辆车陆续到达
        for (int i = 1; i <= cars; i++) {
            String plate = "粤A-" + String.format("%05d", i);
            int parkTime = 200 + rnd.nextInt(800); // 每辆车停 200~1000ms
            pool.submit(new CarTask(plate, lot, parkTime));

            // 模拟到达间隔（越小并发越大）
            Thread.sleep(10);
        }

        pool.shutdown();
        pool.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("模拟结束。");
    }
}

