package reference;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class MyObject {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("回收了");
    }
}
