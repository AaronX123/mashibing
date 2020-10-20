package juc;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class AtomicIntegerTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public AtomicIntegerTest() throws ClassNotFoundException {
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(atomicInteger.get());
    }
}
