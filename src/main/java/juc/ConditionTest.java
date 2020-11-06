package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-27
 */
public class ConditionTest {
    private static Lock lock = new ReentrantLock();
    private static Condition producer = lock.newCondition();
    private static Condition consumer = lock.newCondition();

    private static volatile int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Producer(),"producer " + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(),"consumer " + i).start();
        }
    }

    static class Producer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    while (count == 10){
                        producer.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + ": 生产，剩余: " + count);
                    consumer.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    while (count == 0){
                        consumer.await();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + ": 消费，剩余: " + count);
                    producer.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(  300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
