package thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程有几种状态，new -> ready -> running -> terminated，其中还有等待锁的blocked，调用wait,join,park后的waiting状态，以及sleep的TimeWaiting状态
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class ThreadSleepYieldJoin {

    private static final Object lock = new Object();

    /**
     * sleep 是让当前线程休眠一段时间，在此过程中不释放锁资源
     */
    static void sleep(){
        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println("Sleep A" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println("Sleep B" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * yield 会让当前线程让出CPU资源，线程进入队列等待操作系统进行调度，但是仍然有可能被立即重新进入RUNNING状态
     */
    static void yield(){
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Yield" + i);
                if (i % 10 == 0)
                    Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("-------------B" + i);
                if (i % 10 == 0){
                    Thread.yield();
                }
            }
        }).start();
    }

    /**
     * 谁调用谁等待，这里t2线程调用了t1的join，因此t2需要等t1完成后才执行
     */
    static void join(){
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread A" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("Thread B" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }


    public static void main(String[] args) {
        //sleep();
        //yield();
        join();
    }
}
