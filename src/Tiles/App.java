package Tiles;

public class App {

    public static int count;
    public static Node root = new Node(-1);
    public static void main(String[] args){

        countPath(5,root);
        System.out.println(count);
    }

    public static void countPath(int n,Node root){
        if(n==1){
           count = 1;
           return;
        }

        if(n==2){
            count = 2;
            return;
        }


        root.left = new Node(1);
        root.left.total = root.total + root.left.value;


        root.right = new Node(2);
        root.right.total = root.total + root.right.value;

        if(root.left.total<n){
            countPath(n,root.left);
        }else if(root.left.total == n){
            count++;
        }

        if(root.right.total<n){
            countPath(n,root.right);
        }else if(root.right.total == n){
            count++;
        }



    }


    public static class Node{
        int value;
        Node left;
        Node right;
        int total = 0;

        Node(int value){
            this.value = value;
        }
    }
}
