package java2.reference;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-10-21
 */
public class MyObject {
    private byte[] data;


    public MyObject(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("回收了, 回收线程为：" + Thread.currentThread().getName());
    }
}
