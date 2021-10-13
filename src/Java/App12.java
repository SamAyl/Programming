package Java;

import java.util.*;

public class App12 {

    public static void main(String[] args) {
        String s = "1.2.3.4";
        String[] s1 = s.split("\\.");
        System.out.println(s1.length);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.add(100);
        pq.add(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }
}
