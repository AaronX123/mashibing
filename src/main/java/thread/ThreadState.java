package thread;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class ThreadState {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("当前线程的状态是:" + getState());
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();

        System.out.println("after new thread " + t.getState());

        t.start();

        System.out.println("after invoke start() " + t.getState());

        // 这里join是让main线程等待t线程结束
        t.join();

        System.out.println("after invoke join()" + t.getState());


    }
}
