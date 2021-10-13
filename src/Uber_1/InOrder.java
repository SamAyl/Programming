package Uber_1;

import java.util.*;

public class InOrder {

    public static void main(String[] args) {
        Node1 n1 = new Node1(1);
        Node1 n2 = new Node1(2);
        Node1 n3 = new Node1(3);
        Node1 n4 = new Node1(4);
        Node1 n5 = new Node1(5);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        Stack<Node1> stk = new Stack<>();
        Set<Node1> removedNodesFromStack = new HashSet<>();
        stk.push(n1);

        while (!stk.isEmpty()) {
            Node1 temp = stk.peek();
            if (temp.left == null) {
                System.out.println(temp.v);
                removedNodesFromStack.add(stk.pop());
                if (temp.right != null) {
                    stk.push(temp.right);
                }
            } else if (removedNodesFromStack.contains(temp.left)) {
                System.out.println(temp.v);
                removedNodesFromStack.add(stk.pop());

                if (temp.right != null) {
                    stk.push(temp.right);
                }
            } else {
                stk.push(temp.left);
            }
        }

    }



}

 class Node1 {
    int v;
    Node1 left;
    Node1 right;

    public Node1(int v) {
        this.v = v;
    }
}
