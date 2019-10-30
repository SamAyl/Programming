package Educative;

import java.util.*;

public class PQueue {

    public static void main(String[] args) {
        PQueue pQueue = new PQueue();
        PriorityQueue pq = new PriorityQueue(pQueue.new StringComparator());
        pq.add("Amma");
        pq.add("Sai");
        pq.add("Isa");


        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }

    }

    class StringComparator implements Comparator<String>{


        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }


}

