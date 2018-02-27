package Tree;

import Lambdas.Functional.Int;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {


    public void add(int value,Node root){
        if(root.value == -1) {
            root.value = value;
            return;
        }

        if(root.value > value){
            if(root.left == null){
                Node node = new Node(value);
                root.left = node;
            }else {
                add(value,root.left);
            }

            return;
        }else {
            if(root.right == null){
                Node node = new Node(value);
                root.right = node;
            }else {
                add(value,root.right);
            }


        }

    }


    public void print(Node root){
        if(root.left == null ){
            System.out.println(root.value);
            return;
        }

        print(root.left);
        System.out.println(root.value);
        print(root.right);
        if(root.right==null){
            System.out.println(root.value);
        }


    }



    public int height(Node root){
        if(root.left == null && root.right == null){
            return 1;
        }else {
            return  1 + Integer.max(height(root.left),height(root.right));
        }
    }


    public String serialize(Node root){
        int height = height(root);
        if(height==0){
            return "[null]";
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while(height!=0){
         Stack<Node> tempStack = new Stack<>();

            while (!stack.isEmpty()){
                Node node = stack.pop();
                if(node!=null){
                    sb.append(Integer.toString(node.value));
                    sb.append(",");

                    tempStack.add(node.right);
                    tempStack.add(node.left);
                }else {
                    sb.append("null,");
                    tempStack.add(null);
                    tempStack.add(null);
                }


            }

            stack = tempStack;
            height--;
        }


        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        return sb.toString();
    }


    public Node deserialize(String s){
        s = s.substring(1,s.length()-1);
        if( s == "null"){
            return null;
        }



        return null;
    }
}
