package SpanningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        Node n5 = new Node(5);


        n1.neighbours.add(n2);
        n1.neighbours.add(n3);
        n1.neighbours.add(n4);

        n2.neighbours.add(n1);
        n2.neighbours.add(n3);
        n2.neighbours.add(n4);


        n3.neighbours.add(n1);
        n3.neighbours.add(n2);
        n3.neighbours.add(n4);

        n4.neighbours.add(n1);
        n4.neighbours.add(n2);
        n4.neighbours.add(n3);

        n2.neighbours.add(n5);
        n4.neighbours.add(n5);

        makeSPT(n1,new HashSet<>());

        System.out.println(n2.parent.v);
        System.out.println(n3.parent.v);
        System.out.println(n4.parent.v);

        System.out.println(n5.parent.v);

    }

    public static void makeSPT(Node root,Set<Node> visited){

        visited.add(root);
        for(Node n : root.neighbours){
            if(n.parent==null){
                n.parent = root;
            }
        }

        for(Node n : root.neighbours){
            if(!visited.contains(n)) {
                makeSPT(n,visited);
            }
        }
    }


    public static void print(Node root) {


    }
}

class Node{
    int v;
    List<Node> neighbours = new ArrayList<>();
    Node parent;

    public Node(int v){
        this.v = v;
    }
}
