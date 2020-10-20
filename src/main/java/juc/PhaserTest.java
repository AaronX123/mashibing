package juc;

import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class PhaserTest {
    static ThreadLocalRandom random = ThreadLocalRandom.current();
    static PhaserDemo phaserDemo = new PhaserDemo();

    static class PhaserDemo extends Phaser{
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println("阶段0 " + registeredParties);
                    return false;
                case 1:
                    System.out.println("阶段1 " + registeredParties);
                    return false;
                case 2:
                    System.out.println("阶段2 " + registeredParties);
                    return false;
                case 3:
                    System.out.println("阶段完成 " + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Work implements Runnable{

        public void func0() throws InterruptedException {
            Thread.sleep(random.nextInt(1000));
            phaserDemo.arriveAndAwaitAdvance();
        }

        public void func1() throws InterruptedException {
            Thread.sleep(random.nextInt(1000));
            phaserDemo.arriveAndAwaitAdvance();
        }

        public void func2() throws InterruptedException {
            Thread.sleep(random.nextInt(1000));
            phaserDemo.arriveAndAwaitAdvance();
        }

        public void func3() throws InterruptedException {
            Thread.sleep(random.nextInt(1000));
            phaserDemo.arriveAndAwaitAdvance();

        }

        @Override
        public void run() {
            try {
                func0();
                func1();
                func2();
                func3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        phaserDemo.bulkRegister(7);
        for (int i = 0; i < 7; i++) {
            new Thread(new Work()).start();
        }
    }
}
