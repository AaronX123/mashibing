package leetcode.middle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * LRU
 */
public class no146 {
    Map<Integer, Cache> map;
    int capacity;
    static AtomicInteger timeStamp = new AtomicInteger(1);
    class Cache {
        int val;
        int timestamp;

        public Cache() {
        }

        public Cache(int val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    public no146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity, 1);
    }

    public int get(int key) {
        if (map == null) return -1;
        if (map.containsKey(key)) {
            Cache cache = map.get(key);
            cache.timestamp = timeStamp.getAndIncrement();
            map.put(key, cache);
            return cache.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map == null) return;
        if (map.containsKey(key)) {
            Cache cache = map.get(key);
            cache.val = value;
            cache.timestamp = timeStamp.getAndIncrement();
            map.put(key, cache);
        } else {
            if (map.size() == capacity) {
                int lastKey = 0;
                int minTimeStamp = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Cache> integerCacheEntry : map.entrySet()) {
                    if (integerCacheEntry.getValue().timestamp < minTimeStamp) {
                        minTimeStamp = integerCacheEntry.getValue().timestamp;
                        lastKey = integerCacheEntry.getKey();
                    }
                }
                Iterator<Map.Entry<Integer, Cache>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getKey() == lastKey) {
                        iterator.remove();
                        break;
                    }
                }
            }
            map.put(key, new Cache(value, timeStamp.getAndIncrement()));
        }
    }

    public static void main(String[] args) {
        no146 n = new no146(2);
        n.put(2,1);
        n.put(1,1);
        System.out.println(n.get(2));
        n.put(4,1);
        System.out.println(n.get(1));
        System.out.println(n.get(2));
    }
}
