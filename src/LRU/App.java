//package LRU;
//
//
//
//import java.util.*;
//
//public class App {
//
//
//    public static int count = 0;
//    public static Map<Integer,Integer> cache = new HashMap<>();
//    public static Map<Integer,KeyStatistic> keyStatisticMap = new HashMap<>();
//
//
//
//    public static void main(String[] args){
//        put(1,1);
//        put(2,2);
//        put(3,3);
//
//        get(1);
//        get(1);
//        get(2);
//        put(4,4);
//
//        System.out.println(cache);
//
//    }
//
//    public static void put(int key,int value){
//        if(count<3) {
//            cache.put(key, value);
//            keyStatisticMap.put(key,new KeyStatistic(key,System.currentTimeMillis()));
//            count++;
//        }else {
//            evict();
//            cache.put(key,value);
//            keyStatisticMap.put(key,new KeyStatistic(key,System.currentTimeMillis()));
//        }
//    }
//
//    public static void evict(){
//     List<KeyStatistic> list = new ArrayList<>();
//     for(Map.Entry<Integer,KeyStatistic> entry : keyStatisticMap.entrySet()){
//         list.add(entry.getValue());
//     }
//
//        Collections.sort(list);
//        int keyRemoved = list.get(0).key;
//        keyStatisticMap.remove(keyRemoved);
//        cache.remove(keyRemoved);
//    }
//
//    public static int get(int key){
//        keyStatisticMap.get(key).set(System.currentTimeMillis());
//        return cache.get(key);
//
//    }
//
//}
//
//class KeyStatistic implements Comparable<KeyStatistic>{
//    int key;
//    int hits = 0;
//    long time;
//
//    public KeyStatistic(int key,long time){
//        this.key = key;
//        this.time = time;
//        hits++;
//    }
//
//    public void set(long time){
//        this.time = time;
//        hits++;
//    }
//
//
//    public int compareTo(KeyStatistic k){
//        if(this.hits != k.hits){
//            return this.hits - k.hits;
//        }else {
//            return (int) (this.time - k.time);
//        }
//    }
//
//
//    @Override
//    public int hashCode(){
//        return key;
//    }
//
//    @Override
//    public boolean equals(Object o){
//        if(o==null) return false;
//        else if(getClass() != o.getClass()) return false;
//        else if(this == o) return true;
//        else return this.key == ((KeyStatistic)o).key;
//    }
//
//
//
//
//}
