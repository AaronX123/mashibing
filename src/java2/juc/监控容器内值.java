package java2.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里使用synchronized ，wait notify，其中notify不释放锁，wait释放锁
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class 监控容器内值 {
    static class NotifyHoldLock {
        private volatile List<Object> list = new ArrayList<>();

        public void add(Object o){
            list.add(o);
        }

        public int size(){
            return list.size();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NotifyHoldLock notifyHoldLock = new NotifyHoldLock();
        final Object lock = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    notifyHoldLock.add(new Object());
                    System.out.println(i);
                    if (notifyHoldLock.size() == 5){
                        lock.notify();
                        // 释放锁
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {

                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2");
            synchronized (lock){
                if (notifyHoldLock.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("end");
            }
            lock.notify();
        });

        t2.start();

        Thread.sleep(1000);
        t1.start();
    }
}
