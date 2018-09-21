package BFSandDFS;

import java.util.*;

public class App {

    public static void main(String[] args) {


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.child.add(n2);
        n1.child.add(n3);

        n2.child.add(n4);
        n4.child.add(n1);


        bfs(n1);
        dfs(n1);
    }

    public static void bfs(Node root){
        if(root==null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Set<Node> visited = new HashSet<>();
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(!visited.contains(temp)) {
                System.out.println(temp.v);
                visited.add(temp);
                queue.addAll(temp.child);
            }
        }


    }

    public static void dfs(Node root){

       if(root == null){
           return;
       }

       Set<Node> visited = new HashSet<>();


       dfs(root,visited);
    }


    public static void dfs(Node root,Set<Node> visited){
        if(root==null || visited.contains(root)){
            return;
        }


        System.out.println(root.v);
        List<Node> list = root.child;
        visited.add(root);

        for(Node n : list){
            dfs(n,visited);
        }

    }




}

 class Node{
    int v;
    List<Node> child;

    Node(int v){
        this.v = v;
        child = new ArrayList<>();
    }

}
