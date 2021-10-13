package Netflix;

import java.util.*;

public class Prob1 {

    public static void main(String[] args) {
       Node n5 = new Node(5);
       Node n3 = new Node(3);
       Node n8 = new Node(8);
       Node n1 = new Node(1);

       n5.left = n3;
       n5.right = n8;

       n3.left = n1;

       List<Integer> list = new ArrayList<>();
       checkSum(n5,list);
        System.out.println(findVal(list,11));
    }


    public static void checkSum(Node root, List<Integer> list) {

        if (root.left != null) {
            checkSum(root.left,list);
        }

        list.add(root.v);

        if (root.right != null) {
           checkSum(root.right,list);
        }

        return;


    }

    public static boolean findVal (List<Integer> arr, int target) {

        int left = 0;
        int right = arr.size()-1;

        while (left<right) {
            if (arr.get(left) + arr.get(right) > target) {
                right--;
            } else if (arr.get(left) + arr.get(right) < target) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }
}

class Node {
    int v;
    Node left;
    Node right;

    public Node(int v) {
        this.v = v;
    }
}
