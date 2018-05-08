package KLargest;

public class App {

    public static void main(String[] args){

    }

    public Node Klargest(Node root,int k){

        Node left = null;
        Node right = null;
        if(root.l!=null){
         left =    Klargest(root.l,k);
        }

        k--;
        if(k==0){
            return root;
        }

        if(root.r!=null){
          right =   Klargest(root.r,k);
        }

        return left!=null?left:right;
    }
}

class Node{
    int val;
    Node r;
    Node l;
}
