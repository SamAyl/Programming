package AlgoExpert.Grph;


import java.util.*;

public class Basic1 {

    public static void main(String[] args) {
        Map<Integer,List<Integer>> grp = new HashMap<>();
        for(int i = 1; i<= 9;i++) {
            grp.put(i,new ArrayList<>());
        }

        grp.get(1).add(2);
        grp.get(1).add(6);

        grp.get(2).add(3);
        grp.get(2).add(1);
        grp.get(2).add(4);

        grp.get(3).add(2);

        grp.get(4).add(2);
        grp.get(4).add(5);

        grp.get(5).add(4);

        grp.get(6).add(1);
        grp.get(6).add(7);
        grp.get(6).add(8);


        grp.get(7).add(6);
        grp.get(7).add(9);

        grp.get(8).add(6);

        grp.get(9).add(7);

        Basic1 b1 = new Basic1();
        try {
            System.out.println("====== DFS in Action ======");
            b1.printDFS(grp);
            System.out.println("======= BFS in Action ======");
            b1.bfs(grp,1);
        } catch (Exception e) {

        }
    }

    public void printDFS(Map<Integer,List<Integer>> map) throws Exception {
        if (map == null || map.isEmpty()) {
            System.out.println("The map is empty");
        }

        Set<Integer> visited = new HashSet<>();

        for(Integer singleNode : map.keySet()) {
            if ( !visited.contains(singleNode)) {
                explore(singleNode,map,visited);
            }
        }
    }


    public void explore(int singleNode, Map<Integer,List<Integer>> map, Set<Integer> visited) {


        if (!visited.contains(singleNode)) {
            System.out.println(singleNode);

            visited.add(singleNode);
            if (!map.get(singleNode).isEmpty()) {
                 for (int childNode : map.get(singleNode)) {
                       explore(childNode,map,visited);
                 }
             }
         }

    }

    public void bfs(Map<Integer,List<Integer>> grp, int root) {

        Queue<Integer> queue = new LinkedList<>();


        queue.add(root);
        Set<Integer> visited = new HashSet<>();


        while (!queue.isEmpty()) {
            int node = queue.remove();

            if (!visited.contains(node)) {
                System.out.println(node);
                visited.add(node);
                for(int childNode : grp.get(node)) {
                    if (!visited.contains(childNode)) {
                        queue.add(childNode);
                    }
                }
            }

        }
    }

}
