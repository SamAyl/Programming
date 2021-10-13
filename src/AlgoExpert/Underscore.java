package AlgoExpert;

import java.util.*;

public class Underscore {

    public static void main(String[] args) {
        PriorityQueue<Abc> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Abc(1));
        pq.add(new Abc(2));
        pq.add(new Abc(3));


        while (!pq.isEmpty()) {
            System.out.println((pq.remove()).v);
        }




    }
}


class Abc implements Comparable<Abc>{


        int v;
        public Abc(int v) {
            this.v = v;

        }



        @Override
        public int compareTo(Abc o) {
            return v - o.v;
        }


}