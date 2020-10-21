package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier用于控制线程个数，当一定线程完成工作后触发CyclicBarrier中的Runnable线程
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(20,() -> System.out.println("满了"));

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
