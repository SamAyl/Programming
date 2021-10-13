package MCA2.Graphs;

import java.util.*;

public class ShortestPathUnweightedGraph {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        List<Integer> arr0 = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> arr3 = new ArrayList<>();

        arr0.add(1);
        arr0.add(2);

        arr1.add(0);
        arr1.add(2);
        arr1.add(3);

        arr2.add(1);
        arr2.add(3);
        arr2.add(0);

        arr3.add(2);
        arr3.add(1);

        adj.add(arr0);
        adj.add(arr1);
        adj.add(arr2);
        adj.add(arr3);

       print(shortestDist(adj,0));
    }

    public static int[] shortestDist(List<List<Integer>> adj, int src) {
        //boundary conditions;
        int[] nodes = new int[adj.size()];
        nodes[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        Set<Integer> visited = new HashSet<>();
        visited.add(src);

        int dist = 0;

        while (!queue.isEmpty()) {

            int currNode = queue.poll();

            List<Integer> neighbors = adj.get(currNode);
            for(Integer neighbor : neighbors){
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                    nodes[neighbor] = nodes[currNode]+1;
                    visited.add(neighbor);
                }
                dist++;
            }
        }

        return nodes;

    }


    private static void print(int[] nodes){
        for(int i : nodes){
            System.out.print(i+"\t");
        }
        System.out.println();

    }


}
