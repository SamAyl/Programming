package AlgoExpert;

import java.util.HashSet;
import java.util.*;

public class IterativeTreeTraversal {

    public static void main(String[] args) {
        Node1 n1 = new Node1(1);
        Node1 n2 = new Node1(2);
        Node1 n3 = new Node1(3);
        Node1 n4 = new Node1(4);
        Node1 n6 = new Node1(6);
        Node1 n7 = new Node1(7);
        Node1 n9 = new Node1(9);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        n3.left = n6;
        n3.right = n7;

        n4.right = n9;


        n1.parent = null;
        n2.parent = n1;
        n3.parent = n1;
        n4.parent = n2;
        n6.parent = n3;
        n7.parent = n3;
        n9.parent = n4;


        Node1 root = n1;

        Set<Node1> visited = new HashSet<>();

        while (root != null) {

            if ((root.left != null && visited.contains(root.left) || root.left == null)) {
                if (!visited.contains(root)) {
                    System.out.println(root.v);
                    visited.add(root);
                }

                if (root.right == null) {
                    root = root.parent;
                } else if (root.right != null && visited.contains(root.right)) {
                    root = root.parent;
                } else if (root.right != null && !visited.contains(root.right)) {
                    root = root.right;
                }

            } else if (root.left != null && !visited.contains(root.left)) {
                root = root.left;
            }
        }
    }


}
class Node1 {
    int v;
    Node1 left;
    Node1 right;
    Node1 parent;

    public Node1(int v){
        this.v = v;
    }
}