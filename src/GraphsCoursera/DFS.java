package GraphsCoursera;

import java.util.*;

public class DFS {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.child.add(n2);
        n1.child.add(n3);

        n2.child.add(n4);
        n2.child.add(n3);

        n3.child.add(n4);


        printDFS(n1);
        printBFS(n1);

    }


    public static void printDFS(Node n){

        System.out.println("am printing in Depth First Order");
        Set<Node> visited = new HashSet<>();
        print(n,visited);

    }

    public static void printBFS(Node n){

        System.out.println("am printing in Breadth First Order");
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);

        Set<Node> visited = new HashSet<>();


        while (!queue.isEmpty()){
            Node c = queue.poll();
            if(!visited.contains(c)){
                System.out.println(c.v);
                queue.addAll(c.child);
                visited.add(c);
            }
        }

    }


    private static void print(Node n,Set<Node> visited){

        if(!visited.contains(n)){
            System.out.println(n.v);
            visited.add(n);
            for(Node c : n.child){
                print(c,visited);
            }
        }
    }
}

 class Node{
    int v;
    List<Node> child;


    public Node(int v){
        this.v = v;
        child = new ArrayList<>();
    }
}
