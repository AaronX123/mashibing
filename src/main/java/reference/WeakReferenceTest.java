package reference;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * 在GC的时候就会回收
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-22
 */
public class WeakReferenceTest {
    public static void main(String[] args) throws IOException {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject(new byte[1024]));

        System.gc();

        System.out.println("gaga");

        System.in.read();
    }
}
