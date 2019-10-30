package GraphsCoursera;

import java.util.*;

public class Reverse {

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[5];

        for(int i = 0;i<5;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(1);
        graph[0].add(2);
        graph[2].add(3);
        graph[3].add(4);

     //   print(graph);
        ArrayList<Integer>[] reverse = reverseGraph(graph);
      //  print(reverse);
    }

    public static ArrayList[] reverseGraph(ArrayList<Integer>[] graph){
        if(graph==null || graph.length==0){
            return graph;
        }

        ArrayList<Integer>[] reverse = new ArrayList[graph.length];
        initializeGraph(reverse);

        for(int nodeCount = 0;nodeCount<graph.length;nodeCount++){
            ArrayList<Integer> edges = graph[nodeCount];
            for(int node : edges){
                reverse[node].add(nodeCount);
            }
        }

        return reverse;
    }

    private static void print(ArrayList<Integer>[] graph){
        for(int i = 0;i<graph.length;i++){
            System.out.print(i + " -> ");

             for(int j : graph[i]){
                 System.out.print( j+",");
             }
            System.out.println();
        }
    }

    private static void initializeGraph(ArrayList<Integer>[] graph){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
    }
}
