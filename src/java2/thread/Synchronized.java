package java2.thread;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-20
 */
public class Synchronized {
    // -------------------------------这里演示锁对象---------------------------------//
    private static final Object LOCK = new Object();

    public void functionA(){
        synchronized (LOCK){
            for (int i = 0; i < 100; i++) {
                System.out.println("a got lock");
            }
        }
    }

    public void functionB(){
        synchronized (LOCK){
            for (int i = 0; i < 100; i++) {
                System.out.println("b got lock");
            }
        }
    }

    // -------------------------------这里演示锁自身-------------------------------------//

    public void functionC(){
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println("c got lock");
            }
        }
    }

    public synchronized void functionD(){
        for (int i = 0; i < 100; i++) {
            System.out.println("d got lock");
        }
    }


    // --------------------------------这里演示锁Class对象-------------------------------------//


    public static synchronized void functionE(){
        for (int i = 0; i < 100; i++) {
            System.out.println("e got lock");
        }
    }

    public void functionF(){
        synchronized (Synchronized.class){
            for (int i = 0; i < 100; i++) {
                System.out.println("f got lock");
            }
        }
    }



    // --------------------------------------------------------------------------------------//


    public static void main(String[] args) {
        Synchronized s = new Synchronized();
        Thread a = new Thread(s::functionA);

        Thread b = new Thread(s::functionB);

        Thread c = new Thread(s::functionC);

        Thread d = new Thread(s::functionD);

        Thread e = new Thread(Synchronized::functionE);

        Thread f = new Thread(s::functionF);

        //a.start();
        //b.start();
        //c.start();
        //d.start();
        e.start();
        f.start();
    }
}
