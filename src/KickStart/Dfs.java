package KickStart;

import java.util.*;

public class Dfs {

    public static void main(String[] args) {

        Node1 n1 = new Node1(1);
        Node1 n2 = new Node1(2);
        Node1 n3 = new Node1(3);
        Node1 n4 = new Node1(4);

        n1.neighbours.add(n2);
        n1.neighbours.add(n3);

        n2.neighbours.add(n1);
        n2.neighbours.add(n4);

        n3.neighbours.add(n1);
        n3.neighbours.add(n4);


      //  dfs(n1);
        bfs(n1);
    }



    public static void dfs(Node1 n){
        StringBuilder sb = new StringBuilder();
        dfs(n,new HashSet<>(),sb);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

    }


    public static void dfs(Node1 n, Set<Node1> visited, StringBuilder sb){


        if(visited.contains(n)){
            return;
        }else {
            sb.append(n.v+"->");
            visited.add(n);
            for(Node1 child : n.neighbours){
                dfs(child,visited,sb);
            }

        }
    }


    public static void bfs(Node1 n1){

        Queue<Node1> queue = new LinkedList<>();
        queue.add(n1);

        Set<Node1> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
           Node1 temp = queue.poll();
           if(!visited.contains(temp)){
               sb.append(temp.v + "->");
               queue.addAll(temp.neighbours);
               visited.add(temp);
           }
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());
    }
}




 class Node1{

    int v;
    List<Node1> neighbours=new ArrayList<>();

    Node1(int v){
        this.v = v;
    }
}
