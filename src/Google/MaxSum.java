package Google;

public class MaxSum {

    public static void main(String[] args) {
        MaxSum ms = new MaxSum();
        String[] s = new String[2];


        System.out.println(ms.minDiff(ms.getNodes()));
        System.out.println(ms.diff);
    }


    public TreeNode getNodes(){
        TreeNode root = new TreeNode(98);
        TreeNode n1 = new TreeNode(84);
        TreeNode n2 = new TreeNode(27);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(53);

        root.left = n1;


        n1.left = n2;
        n1.right = n4;

        return root;
    }

    int diff = Integer.MAX_VALUE;

    public int minDiff(TreeNode root){
        if(root.left == null && root.right == null) {
            return root.val;
        }

        int left = 0;
        int right = 0;
        if(root.left!=null){
            left =  minDiff(root.left);
        }

        if(root.right!=null){
            right = minDiff(root.right);
        }

        if(Math.abs(root.val - left) < diff){
            diff = Math.abs(root.val -left);
        }

        if(Math.abs(root.val - right) < diff) {
            diff = Math.abs(root.val - right);
        }


        return getMax(root.val, left, right);
    }

    public int getMax(int mid,int left, int right){
        int max = Math.max(mid,left);
        max = Math.max(max,right);

        return max;
    }
}

class TreeNode{
          int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
