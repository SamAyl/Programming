package AlgoExpert;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class KosarajuGaru {

    public static void main(String[] args) {

          Map<Integer, List<Integer>> grp = makeGrp();
          Stack<Integer> visitedOrder = new Stack<>();
          Set<Integer> visited = new HashSet<>();

          for(Integer node : grp.keySet()) {
              if (!visited.contains(node)){
                  dfs(node,grp,visited,visitedOrder);
              }
          }


          Map<Integer,List<Integer>> grp1 = reverseTheEdges(grp);
          Set<Integer> visitedOrder1 = new HashSet<>();
          List<List<Integer>> connectedComponents = new ArrayList<>();

          while (!visitedOrder.isEmpty()) {
              Integer element = visitedOrder.pop();
               if (!visitedOrder1.contains(element)) {
                    List<Integer> tempCc = new ArrayList<>();
                    visit(element,grp1,visitedOrder1,tempCc);
                    connectedComponents.add(tempCc);
               }
          }


          for(List<Integer> list : connectedComponents) {
              for(Integer i : list) {
                  System.out.print(i + " \t");
              }
              System.out.println();
          }
    }

    public static void visit(Integer element, Map<Integer,List<Integer>> grp,Set<Integer> visited, List<Integer> cc) {
        visited.add(element);
        cc.add(element);
        for(Integer child : grp.get(element)) {
            if (!visited.contains(child)) {
                visit(child,grp,visited,cc);
            }
        }
    }

    public static void dfs(int strNode, Map<Integer,List<Integer>> grp, Set<Integer> visited, Stack<Integer> visitedOrder) {


        visited.add(strNode);
        for(Integer child : grp.get(strNode)) {
            if (!visited.contains(child)) {
                dfs(child,grp,visited,visitedOrder);
            }
        }
       visitedOrder.push(strNode);
    }

    public static Map<Integer,List<Integer>> reverseTheEdges(Map<Integer,List<Integer>> grp) {

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(Map.Entry<Integer,List<Integer>> entry : grp.entrySet()) {
            int strNode = entry.getKey();

            for (Integer childNode : entry.getValue()) {
                  if (map.containsKey(childNode)) {
                      map.get(childNode).add(strNode);
                  } else {
                      List<Integer> list = new ArrayList<>();
                      list.add(strNode);
                      map.put(childNode,list);
                  }
            }
        }

        return map;
    }


    public static Map<Integer,List<Integer>> makeGrp() {
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>());
        map.put(1,new ArrayList<>());
        map.put(2,new ArrayList<>());
        map.put(3,new ArrayList<>());
        map.put(4,new ArrayList<>());

        map.get(0).add(1);
        map.get(1).add(2);
        map.get(1).add(3);
        map.get(2).add(0);
        map.get(3).add(4);


       return map;
    }

}
