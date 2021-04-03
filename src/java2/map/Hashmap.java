package java2.map;

import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            map.put(i,i);
        }
        for (int i = 0; i < 5; i++) {
            map.remove(i);
        }
        map.forEach((integer, integer2) -> System.out.println(integer + " val :" + integer2));
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }
        for (int i = 1; i < 100; i+=20) {
            Thread thread = new Thread(new Hashmap().new RemoveTask(i));
            thread.start();
        }
        map.forEach((integer, integer2) -> System.out.println(integer + " val :" + integer2));
    }

    class RemoveTask implements Runnable {
        int id;
        public RemoveTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = id; i < id + 20; i++) {
                map.remove(i);
            }
        }
    }
}
