package java2.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 start");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            } finally {
                lock.unlock();
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }finally {
                lock.unlock();
            }
        });

        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();
    }
}
