package geekForgeeks;

import java.util.*;

public class TopoSortDFS {

    public static void main(String[] args) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2,new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.put(4,new ArrayList<>());
        map.put(5,new ArrayList<>());
        map.put(6,new ArrayList<>());
        map.put(7,new ArrayList<>());

        map.get(1).add(2);
        map.get(1).add(3);

        map.get(2).add(4);
        map.get(3).add(5);

        map.get(4).add(6);
        map.get(5).add(6);

        map.get(6).add(2);
        map.get(6).add(7);


        List<Integer> res = getTopoSort(map);

        for(Integer node : res) {
            System.out.println(node);
        }
    }

    public static List<Integer> getTopoSort(Map<Integer,List<Integer>> map) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for(Integer node : map.keySet()) {
            if (!visited.contains(node)) {
               dfsTraverse(map,node,res,visited);
            }
        }

        return res;
    }


    public static void dfsTraverse(Map<Integer,List<Integer>> map, Integer node, List<Integer> res,Set<Integer> visited) {



        visited.add(node);
        for(Integer neighbour : map.get(node)) {
            if (!visited.contains(neighbour)) {
                dfsTraverse(map,neighbour,res,visited);
            }
        }


    }
}
