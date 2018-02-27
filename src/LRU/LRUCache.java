package LRU;

import java.util.*;

class LRUCache {

    private Map<Integer,Integer> cache = new HashMap<>();
    private   Map<Integer,KeyStatistic> keyStatisticMap = new HashMap<>();

    private int count = 0;
    public int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            keyStatisticMap.get(key).set(System.nanoTime());
            return cache.get(key);
        }else{
            return -1;
        }

    }

    public void evict(){
        long time=-1;
        int key = -1;
        for(Map.Entry<Integer,KeyStatistic> entry : keyStatisticMap.entrySet()){
            time = entry.getValue().time ;
            key = entry.getKey();
            break;
        }



        for(Map.Entry<Integer,KeyStatistic> map : keyStatisticMap.entrySet()){
            if(map.getValue().time<time){
               time = map.getValue().time;
               key = map.getKey();
            }
        }

//        Collections.sort(list);
//        int keyRemoved = list.get(0).key;
        keyStatisticMap.remove(key);
        cache.remove(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            keyStatisticMap.get(key).setTime(System.nanoTime());
        }else {
            if (count < capacity) {
                cache.put(key, value);
                keyStatisticMap.put(key, new KeyStatistic(key, System.nanoTime()));
                count++;
            } else {
                evict();
                cache.put(key, value);
                keyStatisticMap.put(key, new KeyStatistic(key, System.nanoTime()));
            }
        }
    }
}

class KeyStatistic implements Comparable<KeyStatistic>{
    int key;
    int hits = 0;
    long time;

    public KeyStatistic(int key,long time){
        this.key = key;
        this.time = time;
        hits++;
    }

    public void set(long time){
        this.time = time;
        hits++;
    }


    public void setTime(long time){
        this.time = time;
    }


    public int compareTo(KeyStatistic k){
//        if(this.time != k.time){
            return (int)(this.time - k.time);
//        }else {
//            return  (this.hits - k.hits);
//        }
    }


    @Override
    public int hashCode(){
        return key;
    }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        else if(getClass() != o.getClass()) return false;
        else if(this == o) return true;
        else return this.key == ((KeyStatistic)o).key;
    }




}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */