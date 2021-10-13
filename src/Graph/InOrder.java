package Graph;

public class InOrder {

    public static void main(String[] args) {
     Node1 n1 = new Node1(1);
     Node1 n2 = new Node1(2);
     Node1 n3 = new Node1(3);
     Node1 n4 = new Node1(4);
     Node1 n5 = new Node1(5);
     Node1 n6 = new Node1(6);
     Node1 n7 = new Node1(7);

     n1.left = n2;
     n1.right = n3;

     n2.left = n4;
     n2.right = n5;

     n3.left = n6;
     n3.right = n7;


     printInOrder(n1);
//     printPreOrder(n1);
//     printPostOrder(n1);

    }

    public static void printInOrder(Node1 root) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            printInOrder(root.left);
        }

        System.out.println(root.v);

        if (root.right != null) {
            printInOrder(root.right);
        }

    }


    public static void printPreOrder(Node1 root) {
        if (root == null) {
            return;
        }

        System.out.println(root.v);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }


    public static void printPostOrder(Node1 root) {
        if (root == null) {
            return;
        }

         printPostOrder(root.left);
         printPostOrder(root.right);
         System.out.println(root.v);


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
