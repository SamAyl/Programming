package AlgoExpert.Grph;

import java.util.*;
import java.util.Objects;


/**
 *
 *
 *
 * [
 *   [1, 2, 5],
 *   [0, 2],
 *   [0, 1, 3],
 *   [2, 4, 5],
 *   [3, 5],
 *   [0, 3, 4]
 * ]
 *
 *
 *
 *
 *
 *
 *
 */
public class TwoEdgeConnectedGraph {


    public static void main(String[] args){
       // int[][] edges = {{1, 2, 5}, {0,2}, {0,1,3}, {2,4,5}, {3,5},{0,3,4}};
        int[][] edges = {{1},{0,2,3},{1,3,0},{1,2}};
        //int[][] edges = {{1, 2, 3},{0, 2},{0, 1},{0, 4, 5},{3, 5},{3, 4}};
        //int[][] edges = {{1},{0}};
       // int[][] edges = {{1, 2},{0, 2, 3},{1, 0, 4},{1, 4},{3, 2}};
        System.out.println(is2EdgeConnectedGraph(edges));
    }
    public static boolean isTwoEdgeConnectedGraph(int[][] grp) {
        Set<Edge> allEdges = new HashSet<>();
        Set<Edge> connectedEdges = new HashSet<>();
        for(int i = 0; i<grp.length;i++) {
          for(int j = 0; j<grp[i].length;j++) {
            allEdges.add(new Edge(i,grp[i][j]));
          }
       }


       Set<Integer> visited = new HashSet<>();
       for(int i = 0; i< grp.length; i++) {
           if (!visited.contains(i)) {
               explore(i,grp,connectedEdges,allEdges,visited);
           }
       }

       if (allEdges.size() != 0) {
           return true;
       } else {
           return false;
       }
    }


    public static boolean is2EdgeConnectedGraph(int[][] edges) {
        if (connected(edges)) {
            Set<Integer> visited = new HashSet<>();
      //      return explore(0, edges, visited);
            int[] bEdge = new int[edges.length];
            return explore(0,0,edges,visited,bEdge,1);
        }

        return false;
    }


    public static boolean connected(int[][] edges) {

        Set<Integer> visited = new HashSet<>();
        dfsExplore(edges,0,visited);
        if (visited.size() == edges.length) {
            return true;
        }

        return false;
    }


    public static void dfsExplore(int[][] edges, int str, Set<Integer> visited) {


        visited.add(str);

        for(int singleChild : edges[str]) {

            if (!visited.contains(singleChild)) {
                dfsExplore(edges,singleChild,visited);
            }
        }




    }

    public static boolean explore(int str, int[][] edges, Set<Integer> visited) {

        visited.add(str);
        int[] children = edges[str];

        boolean ans = true;
        boolean allChildrenTraversed = true;
        for(int singleChild : children) {
            if (!visited.contains(singleChild)) {
                ans = ans && explore(singleChild,edges,visited);
                allChildrenTraversed = false;
            }
        }

        if(allChildrenTraversed) {
            for(int singleChilde : children) {
                if (singleChilde == 0) {
                    return true;
                }
            }

            return false;
        }

        return ans;

    }

    public static boolean explore(int str,int par, int[][] edges, Set<Integer> visited, int[] backEdge,int count) {
        visited.add(str);
        backEdge[str] = count;
        boolean ans = true;
        boolean allVisitedAtThisNode = true;

        for(int child : edges[str]) {
            if (child != par && backEdge[child] != 0) {
                backEdge[str] = Math.min(backEdge[str],backEdge[child]);
            }
        }


        for(int child : edges[str]) {

            if (visited.contains(child)) {
               continue;
            } else {
                count++;
                ans = ans && explore(child, str, edges, visited, backEdge, count);
                allVisitedAtThisNode = false;
            }
        }


        if (allVisitedAtThisNode) {
            return backEdge[str] == 1 ? true : false;
        }

        return ans;
    }

    public static void explore(int node, int[][] grp, Set<Edge> connectedEdge, Set<Edge> allEdges, Set<Integer> visited) {

        if (!visited.contains(node)) {
            visited.add(node);
            int[] childNodes = grp[node];

            for(int singleChildNode : childNodes) {
                Edge temp = new Edge(node,singleChildNode);
                if (!visited.contains(singleChildNode)) {
                    connectedEdge.add(temp);
                    allEdges.remove(temp);
                    explore(singleChildNode,grp,connectedEdge,allEdges,visited);
                }
            }
        }
    }
}

class Edge {

    int n1;
    int n2;

    public Edge(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public int hashCode() {
       if (n1 > n2) {
           return Objects.hash(n1,n2);
       } else {
           return Objects.hash(n2,n1);
       }
    }

    @Override
    public boolean equals(Object o) {
        Edge e = (Edge)o;

         return (n1 == e.n1 &&  n2 == e.n2) || (n1 == e.n2 && n2 == e.n1);
    }
}
