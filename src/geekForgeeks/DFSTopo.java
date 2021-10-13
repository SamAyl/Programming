package geekForgeeks;

import java.util.*;

public class DFSTopo {

    public static void main(String[] args) {
         Node n0 = new Node(0);
         Node n1 = new Node(1);
         Node n2 = new Node(2);
         Node n3 = new Node(3);
         Node n4 = new Node(4);

         List<Node> list = new ArrayList<>();
         list.add(n0);
         list.add(n1);
         list.add(n2);
         list.add(n3);
         list.add(n4);

         n0.adj.add(n1);
         n1.adj.add(n3);
         n2.adj.add(n3);
         n2.adj.add(n4);
         n3.adj.add(n4);


         printTopo(list);
    }

   static class Node{
        int v;
        List<Node> adj = new ArrayList<>();

        public Node(int v){
            this.v = v;
        }
    }


    public static void printTopo(List<Node> grp){
        Stack<Node> stk = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for(Node n : grp){
            if(!visited.contains(n)) {
                dfs(n, stk, visited);
            }
        }

        Iterator<Node> it = stk.iterator();

        while (!stk.isEmpty()){
            System.out.println(stk.pop().v);
        }
    }

    public static void dfs(Node root, Stack<Node> stk, Set<Node> visited){
        if(visited.contains(root)){
            return;
        } else {
            visited.add(root);
            for(Node neigh : root.adj){
                dfs(neigh,stk,visited);
            }
            stk.push(root);
        }
    }
}
