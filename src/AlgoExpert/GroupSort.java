package AlgoExpert;

import java.util.*;

public class GroupSort {
    public static void main(String[] args) {
             int[] grp = {-1,-1,1,0,0,1,-1};
             List<List<Integer>> beforeItems = new ArrayList<>();
             beforeItems.add(Arrays.asList(3));
             beforeItems.add(new ArrayList<>());
             beforeItems.add(new ArrayList<>());
             beforeItems.add(new ArrayList<>());
             beforeItems.add(Arrays.asList(3));
             beforeItems.add(Arrays.asList(2));
             beforeItems.add(Arrays.asList(1));
             List<Integer> list = sortItems(7,2,grp,beforeItems);

             for (int i  : list) {
                 System.out.print(i + "\t");
             }
    }

    public static List<Integer> sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {


              Map<Integer,List<Integer>> groupMap = new HashMap<>();
              Map<Integer,Map<Integer,List<Integer>>> elementMap = new HashMap<>();

              for (int i = -1; i<m;i++){
                  groupMap.put(i,new ArrayList<>());
                  elementMap.put(i,new HashMap<>());
              }

              for (int i = 0; i<group.length;i++) {
                  int groupId = group[i];
                  elementMap.get(groupId).put(i,new ArrayList<>());
              }

               for (int i = 0; i< beforeItems.size(); i++) {
                   if (beforeItems.get(i) != null && beforeItems.size() != 0) {
                       for (int beforeElement : beforeItems.get(i)) {
                           if (group[beforeElement] == group[i]) {
                                elementMap.get(group[beforeElement]).get(beforeElement).add(i);
                           } else {

                               groupMap.get(group[beforeElement]).add(group[i]);
                           }
                       }
                   }
               }


              List<Integer> groupSort =  topoSortElements(groupMap);
               List<Integer> elementSort = new ArrayList<>();
               for (int grp : groupSort) {
                        elementSort.addAll(topoSortElements(elementMap.get(grp)));
               }

               return elementSort;
    }

    public static List<Integer> topoSort(Map<Integer,List<Integer>> map, int strElement, int size) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = strElement ; i< size; i++) {
            if (!visited.contains(i)) {
              //  dfs(map,list,visited,i);
            }
        }

        return list;
    }

    public static List<Integer> topoSortElements(Map<Integer,List<Integer>> map) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                dfs(map, list, visited, entry.getKey());
            }
        }

        Collections.reverse(list);
        return list;
    }

    public static void dfs(Map<Integer,List<Integer>> map, List<Integer> list, Set<Integer> visited,int currElement) {

        visited.add(currElement);
        List<Integer> elements = map.get(currElement);

        if (elements != null && elements.size() != 0) {
            for (int  singleElement : elements) {
                if (!visited.contains(singleElement)) {
                    dfs(map,list,visited,singleElement);
                }
            }

            list.add(currElement);
        } else {
            list.add(currElement);
        }

        return;
    }
}


