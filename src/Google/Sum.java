package Google;

public class Sum {


    public static void main(String[] args) {
        Sum s = new Sum();
        System.out.println(s.rangeSumBST(s.getRoot(),7,15));
    }

    public TreeNode getRoot(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(18);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;

        return n1;
    }
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {

        rangeSumBSTs(root,L,R);
        return sum;

    }


    public void rangeSumBSTs(TreeNode root, int L, int R) {
        if(root.left!=null) {
            rangeSumBSTs(root.left,L,R);
        }

        if(root.val == L){
            sum+=L;
        } else if(sum!=0){
            sum+=root.val;
        }else if(root.val == R){
            sum+=R;
            return;
        }

        if(root.right != null){
            rangeSumBSTs(root.right,L,R);
        }


    }
}
