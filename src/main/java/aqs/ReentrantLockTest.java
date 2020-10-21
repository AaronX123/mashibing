package aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class ReentrantLockTest {
    private static volatile int i = 0;

    private static Lock lock = new ReentrantLock();

    private static void set(int v){
        try {
            lock.lock();
            i = v;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }
}
