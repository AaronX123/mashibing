package java2.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * readLock中是acquireShared, writeLock中是acquire
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class ReadWriteLockTest {
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static int value;

    static Lock lock = new ReentrantLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();


    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v){
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable read = () -> read(readLock);
        Runnable write = () -> write(writeLock,1);

        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(write).start();
        }
    }

}
