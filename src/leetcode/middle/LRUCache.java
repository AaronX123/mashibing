package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final Map<Integer, Cache> map;
    final int capacity;
    Cache head = new Cache();
    Cache tail = new Cache();
    class Cache {
        int key;
        int val;
        Cache pre;
        Cache next;

        public Cache() {
        }

        public Cache(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Cache cache = map.get(key);
        if (cache != null) {
            moveToHead(cache);
            return cache.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Cache cache = map.get(key);
        if (cache != null) {
            cache.val = value;
            moveToHead(cache);
        } else {
            Cache newCache = new Cache(key, value);
            map.put(key, newCache);
            addToHead(newCache);
            if (map.size() > capacity) {
                // 此时需要淘汰tail指向的元素
                int tailKey = removeTail();
                map.remove(tailKey);
            }
        }
    }

    private void moveToHead(Cache cache) {
        remove(cache);
        addToHead(cache);
    }

    private void remove(Cache cache) {
        cache.pre.next = cache.next;
        cache.next.pre = cache.pre;
    }

    private void addToHead(Cache cache) {
        cache.pre = head;
        cache.next = head.next;
        head.next.pre = cache;
        head.next = cache;
    }

    private int removeTail() {
        Cache cache = tail.pre;
        remove(cache);
        return cache.key;
    }

    public static void main(String[] args) {
        LRUCache n = new LRUCache(2);
        n.get(2);
        n.put(2,1);
        n.put(2,2);
        n.get(2);
        n.put(1,1);
        n.put(4,1);
        System.out.println(n.get(2));
    }
}
