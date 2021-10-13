package geekForgeeks;

import java.util.*;

public class CycleDetectDirectedGraph {

    public static void main(String[] args) {

        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);


        n0.neighbours.add(n1);
        n1.neighbours.add(n3);
        n2.neighbours.add(n1);


        System.out.println(findCycle(n0));
       // findCycle(n0);

    }


    public static boolean findCycle(Node root) {
        return findCycle(root,new HashSet<>());
    }

    public static boolean findCycle(Node root,Set<Integer> visited){
        if(visited.contains(root.v)){
            return true;
        } else {
            visited.add(root.v);
            for(Node node : root.neighbours){
              if(findCycle(node,visited)){
                  return true;
              }
            }

            return false;
        }
    }


}

class Node{
    int v;
    List<Node> neighbours = new ArrayList<>();

    public Node(int v){
        this.v = v;
    }

}