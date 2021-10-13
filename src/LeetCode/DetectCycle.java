package LeetCode;

import java.util.*;

class DetectCycle
{

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> e1 = new ArrayList<>();
//        ArrayList<Integer> e2 = new ArrayList<>();
//        ArrayList<Integer> e3 = new ArrayList<>();

        e1.add(0);
        e1.add(1);

//        e2.add(1);
//        e2.add(2);
//
//        e3.add(2);
//        e3.add(3);

        g.add(e1);
//        g.add(e2);
//        g.add(e3);

        System.out.println(isCyclic(g,4));
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        Map<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<>();

        for(ArrayList<Integer> edge : g) {
            if (map.containsKey(edge.get(0))) {
                map.get(edge.get(0)).add(edge);
            } else {
                ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
                edges.add(edge);
                map.put(edge.get(0), edges);
            }
        }


        Set<Integer> visited = new HashSet<>();

        for(int node : map.keySet()){
            if(!visited.contains(node)){

                if (dfsCycleCheck(map,node,-1, visited) ) {
                    return true;
                }
            }
        }


        return false;
    }


    static boolean dfsCycleCheck(Map<Integer,ArrayList<ArrayList<Integer>>> graph, int currNode,
                                 int parentNode, Set<Integer> visited) {
        boolean checkCycle = false;
        visited.add(currNode);

        if(graph.containsKey(currNode)) {
            for (ArrayList<Integer> edge : graph.get(currNode)) {
                int node = edge.get(1);
                if (node != parentNode) {

                    if (visited.contains(node)) {
                        return true;
                    } else {
                        checkCycle = dfsCycleCheck(graph, node, currNode, visited);
                        if (checkCycle) {
                            return checkCycle;
                        }
                    }
                }
            }


        }
        return checkCycle;

    }



}
