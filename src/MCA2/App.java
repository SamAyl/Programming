package MCA2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class App {

    public static void main(String[] args) {

       Node n1 = new Node(1);
       Node n2 = new Node(2);
       Node n3 = new Node(3);
       Node n4 = new Node(4);
       Node n5 = new Node(5);
       Node n6 = new Node(6);
       Node n7 = new Node(7);
       Node n8 = new Node(8);

       n1.l = n2;
       n1.r = n3;

       n2.l = n4;
       n2.r = n5;

       n3.l = n6;
       n3.r = n7;

       n4.l = n8;

        System.out.println(levelOrderSuccessor(n1,8));
    }

    public static void levelOrderTraversal(Node root){

        StringBuilder sb = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.poll();
            sb.append(temp.v);

            if(temp.l!=null){
                queue.add(temp.l);
            }

            if(temp.r!=null) {
                queue.add(temp.r);
            }
        }


        System.out.println(sb.toString());
    }


    public static void zigZagOrderTraversal(Node root){

        StringBuilder sb = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        ArrayDeque<Node> tempQueue = new ArrayDeque<>();
        int level = 0;
        while (!queue.isEmpty()){

            tempQueue.addAll(queue);
            queue.clear();
            level++;

            while (!tempQueue.isEmpty()){
                Node temp;
                if(level%2==0){
                    temp = tempQueue.pollFirst();
                }else {
                    temp = tempQueue.pollLast();
                }

                sb.append(temp.v);

                if(temp.l!=null){
                    queue.add(temp.l);
                }

                if(temp.r!=null) {
                    queue.add(temp.r);
                }
            }

        }


        System.out.println(level + " Number of levels");
        System.out.println(sb.toString());
    }

    public static void rightImage(Node root){
        StringBuilder sb = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> temp = new ArrayDeque<>();

        queue.add(root);


        while (!queue.isEmpty()){

            temp.addAll(queue);
            queue.clear();

            sb.append(((ArrayDeque<Node>) temp).peekLast().v);

            while (!temp.isEmpty()){

                Node tempNode = temp.poll();

                if(tempNode.l!=null){
                    queue.add(tempNode.l);
                }

                if(tempNode.r!=null) {
                    queue.add(tempNode.r);
                }
            }
        }

        System.out.println(sb.toString());
    }


    public static Integer levelOrderSuccessor(Node root,int num){

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean found = false;

        while (!q.isEmpty()){

            Queue<Node> temp = new LinkedList<>();
            temp.addAll(q);
            q.clear();



            while (!temp.isEmpty()){

                Node t = temp.poll();
                if(found){
                    return t.v;
                }
                if(t.v == num){
                    found = true;
                }

                if(t.l !=null){
                    q.add(t.l);
                }

                if(t.r!=null){
                    q.add(t.r);
                }
            }
        }

        return null;
    }
}


class Node{
    int v;
    Node l;
    Node r;

    Node(int v){
        this.v = v;
    }
}
