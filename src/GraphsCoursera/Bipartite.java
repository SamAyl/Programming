package GraphsCoursera;

import java.util.*;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
      Queue<Integer> queue = new LinkedList<>();
      ((LinkedList<Integer>) queue).add(0);

      Map<Integer,Integer> layerMap = new HashMap<>();
      layerMap.put(0,0);
      boolean check = true;

      Set<Integer> visited = new HashSet<>();


      while (!queue.isEmpty()){
          int element = queue.poll();
          if(!visited.contains(element)){
              visited.add(element);
              check = addElementsInNextLayer(adj[element],element,queue,visited,layerMap);

              if(!check){
                  break;
              }
          }
      }

      return check?1:0;
    }


    private static boolean addElementsInNextLayer(ArrayList<Integer> neighbours,int parent,Queue<Integer> queue,Set<Integer> visited,Map<Integer,Integer> layerMap){

        int parentLayer = layerMap.get(parent);
        for(int node : neighbours){
            if(visited.contains(node) || layerMap.containsKey(node)){
                int nodeLayer = layerMap.get(node);
                if(nodeLayer == parentLayer){
                    return false;
                }
            } else {
                queue.add(node);
                layerMap.put(node,parentLayer+1);

            }
        }

        return true;
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


        adj[0].add(3);

        adj[1].add(3);
        adj[1].add(4);

        adj[2].add(3);

        adj[3].add(2);
        adj[3].add(0);
        adj[3].add(1);

        adj[4].add(1);


//        adj[0].add(1);
//        adj[0].add(2);
//        adj[0].add(3);
//
//        adj[1].add(0);
//        adj[1].add(2);
//
//        adj[2].add(0);
//        adj[2].add(1);
//
//        adj[3].add(0);

        System.out.println(bipartite(adj));
    }
}
