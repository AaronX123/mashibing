package java2.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-22
 */
public class PhantomReferenceTest {
    private static final List<Object> list = new LinkedList<>();
    private static final ReferenceQueue<MyObject> queue = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<MyObject> phantomReference = new PhantomReference(new MyObject(new byte[0]),queue);
        new Thread(() -> {
            while (true) {
                list.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference poll = queue.poll();
                if (poll != null){
                    System.out.println("--------------虚引用被回收" + poll);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
