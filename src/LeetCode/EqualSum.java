package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualSum {

    public static void main(String[] args){
        Map<Node2,Node2> map = new HashMap<>();

        Node2 n1 = new Node2(1);
        Node2 n2 = new Node2(3);

        Node2 n3 = new Node2(4);

        map.put(n1,n2);
        map.put(n3,n2);

        if(map.get(n1) == map.get(n3)){
            System.out.println("I am the way");
            System.out.println(n1.hashCode());
        }


        Set<Integer> integerSet = new HashSet<>();

        for(int i =0;i<Integer.MAX_VALUE;i++){
            integerSet.add(n1.hashCode());
            integerSet.add(n2.hashCode());
        }

        System.out.println(integerSet.size());

    }


}

class Node2{
    int v;

    Node2(int v){
        this.v = v;
    }
}
