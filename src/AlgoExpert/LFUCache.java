package AlgoExpert;

import java.util.*;

public class LFUCache {



    int capacity = 0;
    Map<Integer,TimeObj> cache = new HashMap<>();
    Map<Integer,LinkedList<Integer>> freqMap = new HashMap<>();
    PriorityQueue<Integer> freqPQ = new PriorityQueue<>();

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(2));
        lfuCache.put(1,1);
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(3));
        lfuCache.put(4,1);
        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(4));
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }

        if (cache.containsKey(key)) {

            TimeObj timeObj = cache.get(key);
            timeObj.latestUsedTime = System.currentTimeMillis();

            freqMap.get(timeObj.freqCount).remove((Object)key);

            timeObj.freqCount++;
            freqPQ.add(timeObj.freqCount);

            if (freqMap.containsKey(timeObj.freqCount)) {
                freqMap.get(timeObj.freqCount).addLast(key);
            } else {
                freqMap.put(timeObj.freqCount,new LinkedList<>());
                freqMap.get(timeObj.freqCount).addLast(key);
            }
            return cache.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            TimeObj timeObj = cache.get(key);
            timeObj.freqCount++;
            timeObj.value = value;
            timeObj.latestUsedTime = System.currentTimeMillis();

            freqMap.get(timeObj.freqCount -1).remove((Object)key);
            if (freqMap.containsKey(timeObj.freqCount)) {
                freqMap.get(timeObj.freqCount).addLast(key);
            } else {
                freqMap.put(timeObj.freqCount,new LinkedList<>());
                freqMap.get(timeObj.freqCount).addLast(key);
            }

            freqPQ.add(timeObj.freqCount);
            return;
        }


        if (cache.size() < capacity) {
            TimeObj timeObj = new TimeObj(value);
            cache.put(key,timeObj);

            if (freqMap.containsKey(1)) {
                freqMap.get(1).addLast(key);
            } else {
                freqMap.put(1, new LinkedList<Integer>());
                freqMap.get(1).addLast(key);
            }

            freqPQ.add(1);
        } else {
            while (!freqPQ.isEmpty()) {
                int freqCount = freqPQ.poll();
                if (freqMap.get(freqCount).size() != 0) {
                    int getEvictKey = freqMap.get(freqCount).removeFirst();
                    cache.remove(getEvictKey);
                    break;
                }
            }

            TimeObj timeObj = new TimeObj(value);
            cache.put(key,timeObj);

            if (freqMap.containsKey(1)) {
                freqMap.get(1).addLast(key);
            } else {
                freqMap.put(1, new LinkedList<Integer>());
                freqMap.get(1).addLast(key);
            }
        }
    }
}

class TimeObj{
    Integer value;
    Integer freqCount;
    Long latestUsedTime;

    public TimeObj(Integer value) {
        this.value = value;
        freqCount = 1;
        latestUsedTime = System.currentTimeMillis();
    }
}
