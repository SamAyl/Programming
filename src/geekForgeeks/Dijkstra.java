package geekForgeeks;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
      int[] dist = findShortestPath(0,getGraph());
      int count = 0;
      for(int i : dist){
          System.out.println(count+"---"+i);
          count++;
      }

        System.out.println(getTopoSort(getGraph()));

      List<Integer> list = new ArrayList<>();

    }


    public static int[] findShortestPath(int src, Map<Integer,List<int[]>> graph){
        int[] dist = new int[graph.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] > o2[2]) {
                    return 1;
                } else if (o1[2] < o2[2]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        visited.add(0);
        pq.addAll(graph.get(0));

      while (visited.size()!=graph.size()) {

         int[] node = pq.remove();
         dist[node[1]] = dist[node[0]] + node[2];
         pq.addAll(graph.get(node[1]));
         visited.add(node[1]);

      }

      return dist;
    }


    public static Map<Integer,List<int[]>> getGraph(){
        int[] e01 = {0,1,5};
        int[] e02 = {0,2,4};
        int[] e13 = {1,3,2};
        int[] e14 = {1,4,1};
        int[] e24 = {2,4,2};
        int[] e26 = {2,6,3};
        int[] e45 = {4,5,1};

        Map<Integer,List<int[]>> graph = new HashMap<>();

        for(int i = 0;i<7;i++){
            graph.put(i,new ArrayList<>());
        }

        graph.get(0).add(e01);
        graph.get(0).add(e02);

        graph.get(1).add(e13);
        graph.get(1).add(e14);

        graph.get(2).add(e24);
        graph.get(2).add(e26);

        graph.get(4).add(e45);

        return graph;
    }


    public static String getTopoSort(Map<Integer,List<int[]>> graph){
        Set<Integer> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i : graph.keySet()) {
            if(!visited.contains(i)){
                explore(i,graph,sb,visited);
            }
        }

        return sb.reverse().toString();
    }



    public static void explore(int src,Map<Integer,List<int[]>> graph,StringBuilder sb,Set<Integer> visited){


        if(!visited.contains(src)){
            for(int[] node : graph.get(src)){
                explore(node[1],graph,sb,visited);
            }
            sb.append("-------->"+src);
            visited.add(src);
        }

    }

}
