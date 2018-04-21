package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TreeConstruct {

    public static void main(String[] args) {
        int[] post = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        /*
        [3,9,20,15,7]
[9,3,15,20,7]
         */
        Node3 n = getTree(post, inorder, 0, inorder.length - 1, map);
        System.out.println();
    }

    public static Node3 getTree(int[] pre, int[] inorder, int start, int end, Map<Integer, Integer> map) {

        if (start == end) {
            Node3 temp = new Node3(pre[start]);
            return temp;
        } else if (start > end || start < 0 || start > inorder.length - 1 || end < 0 || end > inorder.length - 1) {
            return null;
        } else {
            Node3 temp = new Node3(pre[start]);
            int p1 = map.get(pre[start]);

            int deltaL = getDelta(pre,start,end,map);


            if(p1==0 && p1!=inorder.length-1){
                temp.right = getTree(pre,inorder,start+deltaL+1,end,map);
            } else if(p1!=0 && p1==inorder.length-1){
                temp.left = getTree(pre,inorder,start+1,start+deltaL,map);
            }else{
                temp.left = getTree(pre,inorder,start+1,start+deltaL,map);
                temp.right = getTree(pre,inorder,start+deltaL+1,end,map);
            }

            return temp;

        }
    }


    public static int getDelta(int[] pre,int start,int end,Map<Integer,Integer> map){
        int ref = map.get(pre[start]);
        int count=0;
        for(int i = start+1;i<=end;i++){
            int position  = map.get(pre[i]);
            if(position<ref){
                count++;
            }else{
                break;
            }
        }

        return  count;
    }

}


class Node3{
    int val;
    Node3 left;
    Node3 right;

    public Node3(int val){
        this.val = val;
    }
}

