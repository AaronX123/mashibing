package java2.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 使用Semaphore
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class 监控容器内值4 {
    static class Container{
        volatile List<Object> list = new ArrayList<>();

        public void add(Object o){
            list.add(o);
        }

        public int size(){
            return list.size();
        }
    }

    static Thread t1, t2;
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();
        Semaphore semaphore = new Semaphore(1,true);

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                container.add(new Object());
                if (container.size() == 5){
                    semaphore.release();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
            if (container.size() != 5){
                semaphore.release();
            }
            System.out.println("end");
        });

        t2.start();
        Thread.sleep(100);
        t1.start();
    }
}
