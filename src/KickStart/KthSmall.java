//package KickStart;
//
//public class KthSmall {
//
//    public static void main(String[] args) {
//
//        TreeNode n1 = new TreeNode(4);
//        TreeNode n2 = new TreeNode(3);
//        TreeNode n3 = new TreeNode(2);
//        TreeNode n4 = new TreeNode(1);
//        TreeNode n5 = new TreeNode(5);
//        TreeNode n6 = new TreeNode(2);
//
//        n1.left_ptr = n2;
//        n2.left_ptr = n3;
//        n3.left_ptr = n4;
//        n4.right_ptr = n5;
//
//
//        int[] count = new int[2];
//        kth_smallest_element(n1,count);
//
//
//    }
//
//
//    static void kth_smallest_element(TreeNode root,int[] count){
//        if(count[0]==0){
//            count[1] = root.val;
//            return;
//        }
//
//
//        if(root.left_ptr!=null){
//            kth_smallest_element(root.left_ptr,count);
//        }
//
//        count[0] = count[0]-1;
//
//        if(root.right_ptr!=null){
//            kth_smallest_element(root.right_ptr,count);
//        }
//    }
//
//}
//
//class TreeNode{
//    int val;
//    TreeNode left_ptr;
//    TreeNode right_ptr;
//
//    TreeNode(int _val)
//    {
//        val = _val;
//        left_ptr = null;
//        right_ptr = null;
//    }
//}
