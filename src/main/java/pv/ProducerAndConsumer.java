package pv;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class ProducerAndConsumer {
    private final LinkedList<Object> list = new LinkedList<>();
    private final int MAX = 100;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(Object o){
        try {
            lock.lock();
            while (list.size() == MAX){
                producer.await();
            }
            list.add(o);
            count++;
            consumer.signalAll();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object get(){
        Object res = null;
        try {
            lock.lock();
            while (list.size() == 0){
                consumer.await();
            }
            producer.signalAll();
            count--;
            res = list.removeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return res;
    }

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(producerAndConsumer.get());
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    producerAndConsumer.put(Thread.currentThread().getName() + " " + j);
                }
            }).start();
        }
    }
}
