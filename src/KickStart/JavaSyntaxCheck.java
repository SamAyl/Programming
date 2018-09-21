package KickStart;

import java.util.*;
public class JavaSyntaxCheck {

//    public static void main(String[] args) {
//       Long[] a = {-100000000000000,-100000000000000, -800000000000000, -300000000000000, -1800000000000000, 1100000000000000, 600000000000000};
//        System.out.println(check_if_sum_possible(a,-15));
//
//    }
//


    public static void main(String[] args) {

        int[] a = {-4 ,-2, 2 ,4};
        TreeNode n =  build_balanced_bst(a);
        System.out.println(n.val);

    }

    static TreeNode build_balanced_bst(int[] a)
    {

        int mid = (a.length-1)/2;
        TreeNode root = new TreeNode(a[mid]);
        build_balanced_bst(a,0,mid-1,mid+1,a.length-1,root);
        return root;
    }

    static void build_balanced_bst(int[] a,int l1,int r1,int l2, int r2,TreeNode root){

        if(l1<=r1){
            int mid = (l1+r1)/2;
            TreeNode temp = new TreeNode(a[mid]);
            root.left_ptr = temp;
            build_balanced_bst(a,l1,mid-1,mid+1,r1,temp);
        }

        if(l2<=r2){
            int mid1 = (l2+r2)/2;
            TreeNode temp = new TreeNode(a[mid1]);
            root.right_ptr = temp;
            build_balanced_bst(a,l2,mid1-1,mid1+1,r2,temp);
        }




    }
}