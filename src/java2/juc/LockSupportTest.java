package java2.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5){
                    System.out.println("park");
                    LockSupport.park();
                }
                if (i == 8){
                    System.out.println("park");
                    LockSupport.park();
                }
            }
        });

        t.start();
        System.out.println("unpark");
        LockSupport.unpark(t);

        Thread.sleep(5000);
        System.out.println("unpark");
        LockSupport.unpark(t);
    }
}
