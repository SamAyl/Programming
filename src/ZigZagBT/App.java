package ZigZagBT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class App {

    public static void main(String[] args){

        Node root = new Node(3);
        Node n1 = new Node(20);
        Node n2 = new Node(9);
        Node n3 = new Node(15);
        Node n4 = new Node(7);

        root.l = n2;
        root.r = n1;

        n1.l = n3;
        n1.r = n4;

        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
        return;


    }

    public static List<List<Integer>> zigzagLevelOrder(Node root){
        Stack<Node> right = new Stack<>();
        Stack<Node> left = new Stack<>();

        left.push(root);

        List<Integer> list = new ArrayList<>();
        list.add(root.v);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list);

      return   zigzagLevelOrder(left,right,lists);


    }

    public static List<List<Integer>> zigzagLevelOrder(Stack<Node> left,Stack<Node> right,List<List<Integer>> list){
        if(left.isEmpty() && right.isEmpty()){
            return list;
        }

        if(!left.isEmpty() && right.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            while (!left.isEmpty()){
                Node tempNode = left.pop();
                if(tempNode.r!=null){
                    temp.add(tempNode.r.v);
                    right.push(tempNode.r);
                }

                if(tempNode.l!=null){
                    temp.add(tempNode.l.v);
                    right.push(tempNode.l);

                }
            }

            if(temp.size()!=0) {
                list.add(temp);
            }
            return zigzagLevelOrder(left,right,list);
        }else {
            List<Integer> temp = new ArrayList<>();
            while (!right.isEmpty()){
                Node tempNode = right.pop();

                if(tempNode.l!=null){
                    temp.add(tempNode.l.v);
                    left.push(tempNode.l);
                }

                if(tempNode.r!=null){
                    temp.add(tempNode.r.v);
                    left.push(tempNode.r);
                }

            }

            if(temp.size()!=0) {
                list.add(temp);
            }
            return zigzagLevelOrder(left,right,list);
        }


    }
}

class Node{
    int v;
    Node l;
    Node r;

    public Node(int v){
        this.v = v;
    }
}