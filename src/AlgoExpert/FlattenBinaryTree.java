package AlgoExpert;


import java.util.*;

public class FlattenBinaryTree {

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(1);
        BinaryTree leftNode = new BinaryTree(2);

        root.left = leftNode;

       BinaryTree rt = flattenBinaryTree(root);
    }

    public static BinaryTree flattenBinaryTree(BinaryTree root) {

        Stack<BinaryTree> stk = new Stack<>();
        Set<BinaryTree> visited = new HashSet<>();

        stk.push(root);
        leftTraverse(root,stk);


        BinaryTree curr = null;
        BinaryTree str = null;
        while(!stk.isEmpty()) {
            BinaryTree temp = stk.pop();

            if (temp.left == null || visited.contains(temp.left)) {
                if (curr == null) {
                    curr = temp;
                    str = temp;
                    str.left = null;

                    visited.add(curr);
                    if (temp.right != null) {
                        stk.push(temp.right);
                    }
                    curr.right = null;
                } else {
                    curr.right = temp;
                    temp.left = curr;
                    curr = temp;
                    if (temp.right != null) {
                        stk.push(temp.right);
                    }
                    curr.right = null;
                    visited.add(curr);
                }
            } else {
                stk.push(temp);
                leftTraverse(temp,stk);
            }
        }


        return str;
    }


    static void leftTraverse(BinaryTree root, Stack<BinaryTree> stk) {
        while(root.left!=null){
            stk.push(root.left);
            root = root.left;
        }
    }
}

class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
        this.value = value;
    }
}