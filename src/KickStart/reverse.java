package KickStart;

import java.util.*;

public class reverse {

    public static void main(String[] args) {

        Node2 n1 = new Node2(1);
        Node2 n2 = new Node2(2);
        Node2 n3 = new Node2(3);

        n1.neighbours.add(n2);
        n2.neighbours.add(n3);
        n3.neighbours.add(n1);


     Node2 n11 =  otherGraph(n1);
        System.out.println(n11.neighbours.get(0).v);
        System.out.println(n11.neighbours.get(0).neighbours.get(0).v);

    }

    static Node2 otherGraph(Node2 n){


        Queue<Node2> queue = new LinkedList<>();
        queue.add(n);

        Set<Node2> visited = new HashSet<>();
        Map<Integer,Node2> map = new HashMap<>();

        while (!queue.isEmpty()){
            Node2 temp = queue.poll();
            if(!visited.contains(temp)){
                Node2 tempParent = null;
                if(map.containsKey(temp.v)){
                    tempParent = map.get(temp.v);
                }else {
                   tempParent = new Node2(temp.v);
                    map.put(temp.v,tempParent);
                }


                for(Node2 child : temp.neighbours){
                    if(map.containsKey(child.v)){
                        map.get(child.v).neighbours.add(tempParent);
                    }else {
                        Node2 tempChild = new Node2(child.v);
                        tempChild.neighbours.add(tempParent);
                        map.put(child.v,tempChild);
                    }

                    queue.add(child);
                }

                visited.add(temp);
            }

        }



        return map.get(1);


    }



    static void build_other_graph(Node2 node, Set<Node2> visited) {


        if (!visited.contains(node)) {
            List<Node2> list = new ArrayList<>();
            list.addAll(node.neighbours);

            visited.add(node);

            for (Node2 n : list) {
                n.neighbours.add(node);
                node.neighbours.remove(n);
                build_other_graph(n, visited);
            }


        }

    }

}


class Node2{

    int v;
    Vector<Node2> neighbours = new Vector<>();

    Node2(int v){
        this.v = v;
    }
}