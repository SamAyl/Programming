package GraphsCoursera;

import Lambdas.Functional.Int;

import java.util.*;

public class BFS {

    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
         Queue<Integer> queue = new LinkedList<Integer>();
        ((LinkedList<Integer>) queue).add(s);

       Map<Integer,Integer> layerMap = new HashMap<>();
       layerMap.put(s,0);

       Set<Integer> visited = new HashSet<>();


        while (!queue.isEmpty()){
         if(layerMap.containsKey(t)){
             break;
         }
         int element = queue.poll();
         if(!visited.contains(element)) {
             visited.add(element);
             addElementsInQueue(adj[element],layerMap,layerMap.get(element),queue);
         }



        }
        return layerMap.containsKey(t)?layerMap.get(t):-1;
    }



    private static void addElementsInQueue(ArrayList<Integer> neighbours,Map<Integer,Integer> layerMap,int parentNodeLayer,Queue<Integer> queue){

        for(Integer node : neighbours){
             if(!layerMap.containsKey(node)){
                 queue.add(node);
                 layerMap.put(node,parentNodeLayer+1);
             }
         }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            adj[i] = new ArrayList<Integer>();
        }
//        for (int i = 0; i < m; i++) {
//            int x, y;
//            x = scanner.nextInt();
//            y = scanner.nextInt();
//            adj[x - 1].add(y - 1);
//            adj[y - 1].add(x - 1);
//        }
//        int x = scanner.nextInt() - 1;
//        int y = scanner.nextInt() - 1;


        adj[2].add(3);
        adj[2].add(0);
        adj[3].add(2);
        adj[3].add(0);

        adj[0].add(2);
        adj[0].add(3);

        adj[4].add(1);
        adj[1].add(4);





        System.out.println(distance(adj, 0, 3));
    }
}
