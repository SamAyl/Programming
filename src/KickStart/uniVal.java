package KickStart;

public class uniVal {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);

        n1.left = n2;
        n1.right = n3;


        int[] c = new int[1];
        findSingleValueTrees(n1,c);
        System.out.println(c[0]);

    }

    static Integer findSingleValueTrees(Node n, int[] c) {
        if (n.left == null && n.right == null) {
            c[0] += 1;
            return n.val;
        }

        boolean leftCheck = true;
        boolean rightCheck = true;


        if (n.left != null) {
            Integer left = findSingleValueTrees(n.left, c);
            if (left != null && new Integer(n.val) != left) {
                leftCheck = false;
            } else if (left == null) {
                leftCheck = false;
            } else if (left == n.val) {
                leftCheck = true;
            }
        }


        if (n.right != null) {
            Integer right = findSingleValueTrees(n.right, c);
            if (right != null && new Integer(n.val) != right) {
                rightCheck = false;
            } else if (right == null) {
                rightCheck = false;
            } else if (right == n.val) {
                rightCheck = true;
            }
        }

        if (leftCheck && rightCheck) {
            c[0] += 1;
            return n.val;
        } else {
            return null;
        }
    }


}

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}