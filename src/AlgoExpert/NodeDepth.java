package AlgoExpert;

import java.util.*;

public class NodeDepth {

    public static void main(String[] args) {

        BinaryTree r1 = new BinaryTree(1);
        BinaryTree r2 = new BinaryTree(2);
        BinaryTree r3 = new BinaryTree(3);
        BinaryTree r4 = new BinaryTree(4);
        BinaryTree r5 = new BinaryTree(5);
        BinaryTree r6 = new BinaryTree(6);
        BinaryTree r7 = new BinaryTree(7);
        BinaryTree r8 = new BinaryTree(8);
        BinaryTree r9 = new BinaryTree(9);
        //BinaryTree r2 = new BinaryTree(2);


        r1.left = r2;
        r1.right = r3;

        r2.left = r4;
        r2.right = r5;

        r4.left = r8;
        r4.right = r9;


        r3.left = r6;
        r3.right = r7;


        System.out.println(allKindsOfNodeDepths(r1));
    }

        public static int allKindsOfNodeDepths(BinaryTree root) {
            List<Integer> list = getAllSum(root);
            int sum = 0;
            for (Integer pathsum : list) {
                sum+=pathsum;
            }

            return sum;
        }


        public static List<Integer> getAllSum(BinaryTree root) {

            List<Integer> nodeSum = new ArrayList<>();

            if(root.value == 1) {
                System.out.println("am he");
            }

            if (root.left != null) {
                List<Integer> leftSum = getAllSum(root.left);
                if (leftSum !=null && !leftSum.isEmpty()) {
                    nodeSum.addAll(leftSum);
                    for (Integer leftPathSum : leftSum) {
                        nodeSum.add(leftPathSum+1);
                    }
                }
                    nodeSum.add(1);

            }

            if (root.right != null) {
                List<Integer> rightSum = getAllSum(root.right);

                if (rightSum != null && !rightSum.isEmpty()) {
                    nodeSum.addAll(rightSum);
                    for (Integer rightPathSum : rightSum) {
                        nodeSum.add(rightPathSum + 1);
                    }
                }
                nodeSum.add(1);

            }
            return nodeSum;
        }
        static class BinaryTree {
            int value;
            BinaryTree left;
            BinaryTree right;

            public BinaryTree(int value) {
                this.value = value;
                left = null;
                right = null;
            }
        }
    }


