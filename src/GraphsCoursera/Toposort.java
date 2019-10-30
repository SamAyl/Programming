package GraphsCoursera;
import Lambdas.Functional.Int;

import java.util.*;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();

       for(int i=0;i<adj.length;i++){
               dfs(adj,used,order,i);
       }
       Collections.reverse(order);
       return order;
    }


//    private static ArrayList<Integer> reverse(ArrayList<Integer> order){
//        ArrayList<Integer> order1 = new ArrayList<>();
//        if(!order.isEmpty()){
//            order.
//        }
//    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
        //write your code here
        if(used[s]!=1) {
            used[s] = 1;

            ArrayList<Integer> adjacentNodes = adj[s];

            for(Integer node : adjacentNodes){
                dfs(adj,used,order,node);
            }

            order.add(s);

        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            adj[i] = new ArrayList<Integer>();
//        }
//        for (int i = 0; i < m; i++) {
//            int x, y;
//            x = scanner.nextInt();
//            y = scanner.nextInt();
//            adj[x - 1].add(y - 1);
//        }
//        ArrayList<Integer> order = toposort(adj);
//        for (int x : order) {
//            System.out.print((x + 1) + " ");
//        }
//    }

//        5 10
//        4 5
//        3 1
//        2 1
//        2 3
//        5 1
//        2 5
//        4 1
//        2 4
//        3 4
//        3 5


        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[5];
                for (int i = 0; i < 5; i++) {
            adj[i] = new ArrayList<Integer>();
        }



        adj[1].add(0);adj[1].add(2); adj[1].add(4); adj[1].add(3);
        adj[2].add(0);adj[2].add(3);adj[2].add(4);
        adj[3].add(4);adj[3].add(0);
        adj[4].add(0);

        System.out.println(toposort(adj));
    }
}


