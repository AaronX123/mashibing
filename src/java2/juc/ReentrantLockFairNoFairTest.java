package java2.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class ReentrantLockFairNoFairTest {
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName() + "get lock");
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "get lock");
                }finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
