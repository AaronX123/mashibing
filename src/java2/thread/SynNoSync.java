package java2.thread;

/**
 * 同步方法是否可以调用非同步方法
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class SynNoSync {
    public synchronized void A() {
        System.out.println(Thread.currentThread().getName() + " A start...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " A end...");
    }

    public void B() {
        System.out.println(Thread.currentThread().getName() + " B start...");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " B end...");
    }

    public static void main(String[] args) {
        SynNoSync synNoSync = new SynNoSync();

        new Thread(synNoSync::A,"A").start();
        new Thread(synNoSync::B,"B").start();
    }
}
