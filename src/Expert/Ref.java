package Expert;

public class Ref {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6};
        Node root = getTreeBST(arr,0,arr.length-1);
        System.out.println(root.v);
        System.out.println(root.left.v);
    }

    public static Node getTreeBST(int[] arr, int str, int end) {

        if (str>end) {
            return null;
        }

        int mid = (str+end)/2;
        Node temp = new Node(arr[mid]);

        temp.left = getTreeBST(arr,str, mid-1);
        temp.right = getTreeBST(arr,mid+1,end);

        return temp;
    }
}

class Node{
    int v;
    Node left;
    Node right;

    public Node(int v){
        this.v = v;
    }
}
