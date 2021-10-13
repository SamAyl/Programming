package AlgoExpert;

public class MaxPathSum {

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree(1);
        BinaryTree t2 = new BinaryTree(2);
        BinaryTree t3 = new BinaryTree(3);
        BinaryTree t4 = new BinaryTree(4);
        BinaryTree t5 = new BinaryTree(5);
        BinaryTree t6 = new BinaryTree(6);
        BinaryTree t7 = new BinaryTree(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        System.out.println(maxPathSum(t1));
    }

        public static int maxPathSum(BinaryTree tree) {
            if (tree == null) {
                return 0;
            }

            if (tree.right == null && tree.left == null) {
                return tree.value;
            }

            int[] maxSum = new int[1];
            maxSum[0] = Integer.MIN_VALUE;

            getMaxSum(tree, maxSum);
            return maxSum[0];
        }

        public static int getMaxSum(BinaryTree tree, int[] maxSum) {

            int tempSum = tree.value;
            int leftSum = 0;
            int rightSum = 0;

            if (tree.left != null) {
                leftSum =      getMaxSum(tree.left,maxSum);
            }

            if (tree.right != null) {
                rightSum = getMaxSum(tree.right,maxSum);
            }


            int maxPath = (int) Math.max(tempSum+leftSum+rightSum,Math.max(tempSum+rightSum,Math.max(tempSum, tempSum+leftSum)));

            if (maxPath > maxSum[0]) {
                maxSum[0] = maxPath;
            }

            return maxPath;
        }

        static class BinaryTree {
            public int value;
            public BinaryTree left;
            public BinaryTree right;

            public BinaryTree(int value) {
                this.value = value;
            }
        }


}
