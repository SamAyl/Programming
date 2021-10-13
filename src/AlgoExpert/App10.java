package AlgoExpert;

import java.util.*;

public class App10 {

    public static void main(String[] args) {
        int[][] edg  = {{2,1},{3,2},{4,1},{5,1},{6,4},{7,1},{8,7}};
        App10 app10 = new App10();
        double a = app10.frogPosition(1,edg,7,7);
        System.out.println(a);
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer,Set<Integer>> grp = new HashMap<>();
        makeGraph(grp,edges);
        int[] pNode = new int[grp.size()+1];

        getPath(grp,1,new HashSet<>(),target, new Stack<Integer>(),pNode);

        double denomitator = 1;
        double numerator = 1;
        if (t > path.size()) {

            for (int node : path) {
                denomitator*= pNode[node];
            }
        } else {
            for (int i = 0; i<t; i++) {
                denomitator*=pNode[i];
            }
        }

        return numerator/denomitator;
    }


    List<Integer> path = new ArrayList<>();

    public boolean getPath(Map<Integer,Set<Integer>> grp, int currNode, Set<Integer> visited, int target, Stack<Integer> stk, int[] pNode ) {

        if (currNode ==  target) {
            stk.add(currNode);
            pNode[currNode] = 1;
            path.addAll(stk);
            stk.pop();
            return true;
        }


        Set<Integer> possibleVisits = grp.get(currNode);
        possibleVisits.removeAll(visited);
        pNode[currNode] = possibleVisits.size();
        stk.add(currNode);
        visited.add(currNode);
        boolean found = false;

        for (Integer child : possibleVisits) {
            found = getPath(grp,child, visited, target, stk,pNode);
            if (found) {
                break;
            }
        }

        stk.pop();
        return found;
    }

    public void makeGraph(Map<Integer,Set<Integer>> grp, int[][] edges) {

        for (int i = 0; i< edges.length; i++) {
            int[] singleEdge = edges[i];

            if (grp.containsKey(singleEdge[0])) {
                (grp.get(singleEdge[0])).add(singleEdge[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(singleEdge[1]);

                grp.put(singleEdge[0],set);
            }


            if (grp.containsKey(singleEdge[1])) {
                grp.get(singleEdge[1]).add(singleEdge[0]);
            } else {
                Set<Integer> set1 = new HashSet<>();
                set1.add(singleEdge[0]);
                grp.put(singleEdge[1],set1);
            }
        }
    }
}
