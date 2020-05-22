package MCA2;

import java.util.*;

public class DFS {

    static Set<Node2> visited = new HashSet<>();

    public static void main(String[] args) {
        Node2 n0 = new Node2(0);
        Node2 n1 = new Node2(1);
        Node2 n2 = new Node2(2);
        Node2 n3 = new Node2(3);
        Node2 n4 = new Node2(4);
        Node2 n5 = new Node2(5);
        Node2 n6 = new Node2(6);

        n0.adj.add(n1);
        n0.adj.add(n4);

        n1.adj.add(n2);
        n2.adj.add(n3);

        n4.adj.add(n5);
        n4.adj.add(n6);

        dfs(Arrays.asList(n0,n1,n2,n3,n4,n5,n6));
    }


    public static void dfs(List<Node2> nodes){

        for(Node2 node2 :  nodes){
            if(!visited.contains(node2)){
                visited.add(node2);
                dfsPerNode(node2);
            }
        }
    }

    public static void dfsPerNode(Node2 node2) {

        System.out.print(node2.v + "\t");

        for(Node2 adjacent : node2.adj) {
            if(!visited.contains(adjacent)) {
                visited.add(adjacent);
                dfsPerNode(adjacent);
            }
        }

    }

}


class Node2 {
    int v;
    List<Node2> adj = new ArrayList<>();

    public Node2(int v){
        this.v = v;
    }

}