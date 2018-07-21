package SerializeAndDeserialize;

import RecursiveString.Str;

import java.util.LinkedList;
import java.util.Queue;

public class App {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.l = n2;
        n1.r = n3;

        n3.l = n4;

        System.out.println(serialize(n1));
    }

    public static String serialize(Node root){
        StringBuilder sb = new StringBuilder("[");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.poll();
            sb.append(Integer.toString(temp.v));
            sb.append(",");

            if(temp.l!=null){
                queue.add(temp.l);
            }

            if(temp.r!=null){
                queue.add(temp.r);
            }
        }

        sb.append("]");
        return sb.toString();
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
