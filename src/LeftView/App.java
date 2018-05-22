package LeftView;

import RBT.Node;

public class App {

    public static void main(String[] args) {

        NodeLV n1 = new NodeLV(1);
        NodeLV n2 = new NodeLV(2);
        NodeLV n3 = new NodeLV(3);
        NodeLV n4 = new NodeLV(5);
        NodeLV n5 = new NodeLV(6);
        NodeLV n6 = new NodeLV(7);
        NodeLV n7 = new NodeLV(8);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n4.right = n5;
        n5.left = n6;
        n6.right = n7;

        printLV(n1);
    }

    public static void printLV(NodeLV root){
        if(root!=null){
            System.out.println(root.val);
        }else {
            return;
        }

        if(root.left!=null){
            printLV(root.left);
        }else if(root.left==null && root.right!=null){
            printLV(root.right);
        }
    }
}

class NodeLV{
    int val;
    NodeLV right;
    NodeLV left;

    public NodeLV(int val){
        this.val = val;
    }
}
