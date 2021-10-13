package AlgoExpert;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.*;

public class Pqtest {

    public static void main(String[] args) {
        PriorityQueue<Node3> pq = new PriorityQueue<Node3>();
        Node3 n1 = new Node3(1);
        Node3 n2 = new Node3(2);


        pq.add(n1);
        pq.add(n2);


        n1.v = 4;

        Node3 r =  pq.remove();
        System.out.println(r.v);



        Map<Integer,Integer> map = new HashMap<>();

        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + "  "+ e.getValue());
        }


    }
}

 class Node3 implements Comparable<Node3>{
    int v;

    public Node3(int v) {
        this.v = v;
    }

    @Override
     public int compareTo(Node3 node3) {
        return this.v - node3.v;
    }
}
