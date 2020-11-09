package java2.juc;

import java.util.concurrent.Semaphore;

/**
 * 主要是限制同时执行的线程个数，限流用
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2,false);
        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T1 running...");
                Thread.sleep(500);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T2 running...");
                Thread.sleep(500);
                System.out.println("T2 running...");
                s.release();

            } catch (InterruptedException e){

            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T3 running...");
                Thread.sleep(500);
                System.out.println("T3 running...");
                s.release();

            } catch (InterruptedException e){

            }
        }).start();
    }
}
