package BFS;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.child.add(n2);
        n1.child.add(n3);

        n2.child.add(n4);
        n2.child.add(n5);

        n2.child.add(n1);
        n5.child.add(n2);

        Queue<Node> queue = new LinkedList<>();
        queue.add(n1);
        Set<Node> visited = new HashSet<>();

     //   printBFS(queue,visited);
        printDFS(visited,n1);


    }

    public static void printBFS(Queue<Node> queue,Set<Node> visited) {
        Queue<Node> temp = new LinkedList<>();
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            visited.add(tempNode);
            System.out.println(tempNode.v);

            for(Node n : tempNode.child){
                if(!visited.contains(n)){
                    temp.add(n);
                }
            }
        }

        queue.addAll(temp);
        if(!queue.isEmpty()){
         printBFS(queue,visited);
        }
    }


    public static void printDFS(Set<Node> visited,Node node){
        visited.add(node);
        System.out.println(node.v);

        for(Node childNode : node.child){
            if(!visited.contains(childNode)){
                printDFS(visited,childNode);
            }
        }
    }

}



 class Node{
    int v;
    List<Node> child = new ArrayList<>();

    public Node(int v){
        this.v = v;
    }
}
