package java2.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 使用LockSupport
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class 监控容器内值3 {
    static class Container{
        volatile List<Object> list = new ArrayList<>();

        public void add(Object o){
            list.add(o);
        }

        public int size(){
            return list.size();
        }
    }

    static Thread t1, t2 = null;

    public static void main(String[] args) {


        Container container = new Container();
        t2 = new Thread(() -> {
            System.out.println("t2");
            if (container.size() != 5){
                LockSupport.park();
            }
            LockSupport.unpark(t1);
            System.out.println("end");
        });


        t2.start();

        t1 = new Thread(() -> {
            System.out.println("t1");
            for (int i = 0; i < 10; i++) {
                container.add(new Object());
                System.out.println(i);
                if (i == 5){
                    System.out.println("唤醒t2");
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        t1.start();


    }
}
