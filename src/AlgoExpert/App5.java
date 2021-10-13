package AlgoExpert;

import java.util.PriorityQueue;

public class App5 {

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("abc");
        pq.add("aac");
        pq.add("c");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }


}
