package java2.reference;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * -Xmx7m -Xms2m -XX:+PrintGCDetails
 * 当内存不足时，软引用会在GC的时候被回收
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws IOException {
        // 申请一个2MB的空间
        SoftReference<MyObject> myObjectSoftReference = new SoftReference<>(new MyObject(new byte[1024 * 2048]));

        System.out.println(myObjectSoftReference.get().getData().length);

        //System.gc();

        SoftReference<MyObject> myObjectSoftReference2 = new SoftReference<>(new MyObject(new byte[1024 * 2048]));
        SoftReference<MyObject> myObjectSoftReference3 = new SoftReference<>(new MyObject(new byte[1024 * 2048]));
        System.in.read();
    }
}
