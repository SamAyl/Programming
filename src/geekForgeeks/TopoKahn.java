package geekForgeeks;

import java.util.*;

public class TopoKahn {

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


//       List<Integer> ans = getTopoSort(map);
//       for(Integer node : ans) {
//           System.out.println(node);
//       }

        System.out.println(getTopoSort(map));
    }


    public static List<Integer> getTopoSort(Map<Integer,List<Integer>> graph) {
        Map<Integer,Integer> indegreeMap = getIndegreeMap(graph);

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : indegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int element = queue.remove();
            list.add(element);


            for (Integer child : graph.get(element)) {
                int indegreeCount = indegreeMap.get(child);
                indegreeCount--;
                 if (indegreeCount == 0) {
                     queue.add(child);
                 }

                 indegreeMap.put(child,indegreeCount);
            }
        }

        return list;
    }


    public static Map<Integer,Integer> getIndegreeMap(Map<Integer,List<Integer>> grp) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> entry : grp.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                map.put(entry.getKey(),0);
            }

            for (Integer child : entry.getValue()) {
                if (map.containsKey(child)) {
                    int indegreeCount = map.get(child);
                    indegreeCount++;
                    map.put(child,indegreeCount);
                } else {
                    map.put(child,1);
                }
            }
        }


        return map;
    }


}
