package BST;



import  java.util.*;

public class App {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);


        n1.left = n2;
        n2.right = n3;



        check(n1);

        System.out.println(n1);

    }

    public static void check(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        getNodes(root,list,tempList);


        Collections.sort(tempList);

        for(int i  = 0;i<list.size();i++){
            if(tempList.get(i)!=list.get(i).val){
                list.get(i).val = tempList.get(i);
            }
        }

    }


    public  static void getNodes(TreeNode root, List<TreeNode> list, List<Integer> tempList){
        if(root.left!=null){
            getNodes(root.left,list,tempList);
        }
        list.add(root);
        tempList.add(root.val);

        if(root.right!=null){
            getNodes(root.right,list,tempList);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
