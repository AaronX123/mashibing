package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class 监控容器内值2 {
    static class Container{
        volatile List<Object> list = new ArrayList<>();

        public void add(Object o){
            list.add(o);
        }

        public int size(){
            return list.size();
        }
    }

    public static void main(String[] args) {
        Container container = new Container();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            System.out.println("T1");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                container.add(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (container.size() == 5){
                    countDownLatch.countDown();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2");
            try {
                countDownLatch.await();
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t1.start();
        t2.start();
    }
}
