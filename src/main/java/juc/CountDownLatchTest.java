package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class CountDownLatchTest {
    private static void funcA(){
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 100; j++) {
                    result += j;
                }
                System.out.println(result);
                countDownLatch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    private static void funcB(){
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
                System.out.println(result);
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        funcA();
        //funcB();
    }

}
