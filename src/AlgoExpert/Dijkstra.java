package AlgoExpert;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Map<Integer,List<Integer>> grp = new HashMap<>();
        grp.put(1,new ArrayList<>());
        grp.put(2,new ArrayList<>());
        grp.put(3,new ArrayList<>());
        grp.put(4,new ArrayList<>());
        grp.put(5,new ArrayList<>());
        grp.put(0,new ArrayList<>());


        grp.get(0).add(1);
        grp.get(1).add(2);
        grp.get(2).add(3);
        grp.get(3).add(4);
        grp.get(4).add(5);
        grp.get(5).add(2);
        grp.get(5).add(3);

        Dijkstra djk = new Dijkstra();
        boolean cycleCheckForGrp = djk.cycleDetection(grp);
        System.out.println(cycleCheckForGrp);


        Map<Integer,List<Integer>> grp1 = new HashMap<>();
        grp1.put(1,new ArrayList<>());
        grp1.put(2,new ArrayList<>());
        grp1.put(3,new ArrayList<>());
        grp1.put(4,new ArrayList<>());
        grp1.put(5,new ArrayList<>());
        grp1.put(6, new ArrayList<>());
        grp1.put(7,new ArrayList<>());

        grp1.get(1).add(2);
        grp1.get(1).add(3);

        grp1.get(2).add(6);

        grp1.get(3).add(6);
        grp1.get(3).add(4);

        grp1.get(4).add(5);

        grp1.get(6).add(7);
        grp1.get(7).add(5);

        String topoSort = djk.topoSort(grp1);
        System.out.println(topoSort);
    }

    // Cycle detection for Directed Graph
    public boolean cycleDetection(Map<Integer,List<Integer>> grp) {


        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer,List<Integer>> node : grp.entrySet()) {
            if (visited.contains(node.getKey())) {
                continue;
            }
            boolean checkCycle = dfs(grp, node.getKey(), visited,new Stack());
            if (checkCycle) {
                return checkCycle;
            }
        }

        return false;
    }


    //Cycle detection for directed graph
    public boolean dfs(Map<Integer,List<Integer>> grp, Integer node, Set<Integer> visited, Stack<Integer> stk) {

        visited.add(node);
        stk.push(node);
        for(Integer child : grp.get(node)) {
            if (!stk.contains(child)) {
                boolean checkForCycleInChildren = dfs(grp,child,visited,stk);
                if(checkForCycleInChildren) {
                    return checkForCycleInChildren;
                }
            } else if(stk.contains(child)) {
                return true;
            }
        }

        stk.pop();
        return false;
    }


    public String topoSort(Map<Integer,List<Integer>> grp) {

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> sb = new Stack<Integer>();
        for (Map.Entry<Integer,List<Integer>> entry : grp.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                topoSortDFS(grp,sb,entry.getKey(),visited);
            }
        }

        StringBuilder sb1 = new StringBuilder();
        while(!sb.isEmpty()) {
            sb1.append(sb.pop());
            sb1.append("\t");
        }

        return sb1.toString();
    }
    //TopoLogical Sorting Using DFS
    public void topoSortDFS(Map<Integer,List<Integer>> grp, Stack<Integer> sb, int idx,Set<Integer> visited) {

        visited.add(idx);
        for (Integer child : grp.get(idx)) {
            if (!visited.contains(child)) {
                topoSortDFS(grp,sb,child,visited);
            }
        }
        sb.push(idx);

    }
}
