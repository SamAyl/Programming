package DP;

import java.util.HashSet;
import java.util.Set;

public class MaxEdges {

    public static void main(String[] args) {

        Node2 root = new Node2(1);
        Node2 n2 = new Node2(2);
        Node2 n3 = new Node2(3);
        Node2 n4 = new Node2(4);
        Node2 n5 = new Node2(5);
        Node2 n6 = new Node2(6);
        Node2 n7 = new Node2(7);

        root.left = n2;
        root.right = n3;

        n3.left = n4;
        n3.right = n5;


        n2.left = n6;
        n6.left = n7;


        Set<Integer> visited = new HashSet<>();
        int val = getCount(root,visited);
        System.out.println(val);
    }

    public static int getCount(Node2 root, Set<Integer> visited) {

        if (root == null) {
            return 0;
        }



        int leftCount = 0;
        int rightCount = 0;

        int count = 0;

        if (!visited.contains(root.v)) {
            //take left edge
            if (root.left != null) {
                    visited.add(root.v);
                    visited.add(root.left.v);
                    leftCount =  1 + getCount(root.left,visited) + getCount(root.right,visited);
                    visited.remove(root.left.v);
                    visited.remove(root.v);
            }



            //take right edge

            if (root.right != null) {
                visited.add(root.v);
                visited.add(root.right.v);
                rightCount = 1 + getCount(root.left,visited) + getCount(root.right,visited);
                visited.remove(root.right.v);
                visited.remove(root.v);
            }

            count = Math.max(leftCount,rightCount);

        } else {
            count = getCount(root.left,visited) + getCount(root.right,visited);
        }

        return count;
    }
}

class Node2 {

    int v;
    Node2 left;
    Node2 right;

    public Node2(int v) {
        this.v = v;
    }

}
