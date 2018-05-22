package BSTIterator;

import java.util.Stack;

public class App {

   public static Node root = new Node(-1);
   public static Stack<Node> stack = new Stack();

    public static void main(String[] args) {


    }


    public static int next(){
        Node temp = stack.pop();
        int tempV = temp.v;

        if(temp.R!=null){
          add(temp.R);
        }


        return tempV;
    }


    public static void add(Node root){
        Node temp = root;

        while (temp.L!=null){
            stack.push(temp);
            temp = temp.L;
        }


    }




    public static boolean hasNext(){
        if(!stack.isEmpty()){
            return true;
        }

        return false;
    }
}

class Node{
    int v;
    Node L;
    Node R;

    public Node(int v){
        this.v = v;
    }
}


