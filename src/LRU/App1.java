package LRU;

public class App1 {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));

//        lruCache.get(1);
//        lruCache.get(1);
//        lruCache.get(2);
//        lruCache.put(4,4);

//        System.out.println(lruCache.cache);
    }

}
