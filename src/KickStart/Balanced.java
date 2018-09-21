package KickStart;

public class Balanced {

    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;


       TreeNode treeNode = build_balanced_bst(a);
        System.out.println(treeNode.val);

    }


    static TreeNode build_balanced_bst(int[] a)
    {

        TreeNode node = new TreeNode(a[(a.length-1)/2]);
        build_balanced_bst(a,0,a.length-1,node);
        return node;

    }

    static void build_balanced_bst(int[] a,int str,int end,TreeNode node){
        if(str==end){
            return;
        }

        int mid = str + (end - str)/2;
        TreeNode left;
        TreeNode right;



        int leftL =  str + (mid - str)/2;
        left = new TreeNode(a[leftL]);


        int delta = (end-mid)/2;
        if(delta==0){
            delta++;
        }
        int rightL = mid + delta ;
        right = new TreeNode(a[rightL]);


        node.left_ptr = left;
        node.right_ptr = right;

        build_balanced_bst(a,str,mid-1,left);
        build_balanced_bst(a,mid+1,end,right);
    }
}


class TreeNode{
    int val;
    TreeNode left_ptr;
    TreeNode right_ptr;

    TreeNode(int val){
        this.val = val;
    }
}