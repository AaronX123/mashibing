package java2.thread;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class Volatile {
    private static volatile int a = 0;

    public void funcA(){
        for (int i = 0; i < 10000; i++) {
            a++;
        }
    }

    public void funcB(){
        for (int i = 0; i < 10000; i++) {
            a++;
        }
    }


    public static void funcC(){
        for (int i = 0; i < 100000; i++) {
            a++;
        }
    }

    public static void funcD(){
        for (int i = 0; i < 100000; i++) {
            a++;
        }
    }

//    public static void main(String[] args) throws InterruptedException {
////        Volatile v = new Volatile();
////        Thread ta = new Thread(v::funcA);
////        Thread tb = new Thread(v::funcB);
////        ta.start();
////        tb.start();
////        ta.join();
////        tb.join();
////        System.out.println(a);
//
//        new Thread(Volatile::funcC).start();
//        new Thread(Volatile::funcD).start();
//
//        Thread.sleep(2000);
//        System.out.println(a);
//    }


    // ---------------------------------------------------------------------//


    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("oooo");
            while (flag){
            }
            System.out.println("oooo");
        });

        thread.start();

        Thread.sleep(500);
        System.out.println("flag set to false");
        flag = false;

    }

}
