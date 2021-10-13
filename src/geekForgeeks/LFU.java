package geekForgeeks;


import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class LFU {


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Map<Integer,Integer> map = new TreeMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,3);

        
    }
}
