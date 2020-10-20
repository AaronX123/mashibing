package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-09-29
 */
public class CreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread say : hello!");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("MyRun say : running!");
        }
    }

    static class MyCall implements Callable{
        @Override
        public Object call() throws Exception {
            System.out.println("MyCall say : on call");
            return "MyCall result";
        }
    }

    public static void main(String[] args) {
        new MyThread().run();
        new Thread(new MyRun()).start();
        new Thread(new FutureTask<String>(new MyCall())).start();
        new Thread(()->System.out.println("匿名Runnable接口实现类")).start();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> System.out.println("匿名线程池中Runnable接口实现类"));
    }
}
