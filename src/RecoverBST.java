public class RecoverBST {


    public static void main(String[] args) {
        Node1 n1 = new Node1(1);
        Node1 n2  = new Node1(2);
        Node1 n3 = new Node1(3);

        n1.left = n3;
        n3.right = n2;

        correct(n1);

        System.out.println(n1.v);
        System.out.println(n1.left.v);
        System.out.println(n1.left.right.v);
    }

    public static void correct(Node1 root) {

        if (root == null) {
            return;
        }

         if (root.left != null) {

             if (root.v >= root.left.v) {
                 correct(root.left);
             } else {
                 swap(root,root.left);
                 return;
             }
         }

         if (root.right != null) {
             if (root.v < root.right.v) {
                 correct(root.right);
             } else {
                 swap(root,root.right);
                 return;
             }
         }

    }


    public static void swap(Node1 n1, Node1 n2) {
        int v = n1.v;
        n1.v = n2.v;
        n2.v = v;
        return;
    }

}

class Node1{
    int v;
    Node1 left;
    Node1 right;

    public Node1(int v){
        this.v = v;
    }
}
