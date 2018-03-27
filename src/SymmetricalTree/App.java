package SymmetricalTree;

import Lambdas.Functional.Int;

public class App {

    public static void main(String[] args){
        Node root1 = new Node(Integer.MIN_VALUE);
        Node root2 = new Node(Integer.MIN_VALUE);
        Tree tree = new Tree();
        tree.insert(10,root1);
        tree.insert(5,root1);
        tree.insert(12,root1);

        tree.insert(10,root2);
        tree.insert(5,root2);
        tree.insert(12,root2);
        tree.insert(14,root2);
        tree.insert(18,root2);

        System.out.println(tree.findSymmetry(root1,root2));
    }
}
