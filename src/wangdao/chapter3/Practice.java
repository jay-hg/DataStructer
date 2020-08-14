package wangdao.chapter3;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 每次10辆车 客车和货车
 * 先到先上
 * 客车先于货车
 * 4辆客车配一辆货车
 * 等待客车不足4辆，以货车替代
 * 没有货车等待，客车都上船
 */
public class Practice {
    java.util.Queue<String> carQueue = new ConcurrentLinkedQueue<>();
    java.util.Queue<String> truckQueue = new ConcurrentLinkedQueue<>();
    java.util.Queue<String> trafficQueue = new ConcurrentLinkedQueue<>();
    int carCount = 0;

    public void in(String vehicle) {
        switch (vehicle) {
            case "car":
                carQueue.offer(vehicle);
                break;
            case "truck":
                truckQueue.offer(vehicle);
                break;
        }

        //上4辆客车
        while (trafficQueue.size() < 10 && carCount < 4 && carQueue.size() > 0) {
            trafficQueue.offer(carQueue.poll());
            carCount++;
        }

        //客车数量不足4辆，货车替代
        while (trafficQueue.size() < 10 && carCount < 4 && carQueue.size() == 0) {
            trafficQueue.offer(truckQueue.poll());
            carCount ++;
        }

        //上一辆货车
        while (trafficQueue.size() < 10 && truckQueue.size() > 0) {
            trafficQueue.offer(truckQueue.poll());
            carCount = 0;
        }

        //没有货车，客车全上
        if (trafficQueue.size() == 0) {
            while (trafficQueue.size() < 10 && carQueue.size() > 0) {
                trafficQueue.offer(carQueue.poll());
                carCount++;
            }
        }
    }
}
