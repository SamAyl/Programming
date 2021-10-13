package AlgoExpert;

import java.util.*;

public class TreeDP {

    public static void main(String[] args) {
        TreeDP dp = new TreeDP();
        int[][] edges = {{0,3},{3,2},{2,1}};
        int[] ans = dp.sumOfDistancesInTree(4,edges);
        System.out.println(ans);


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(1);
        pq.add(2);
        pq.add(3);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

    }

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            if (N == 0) {
                return null;
            }

            if(edges == null || edges.length == 0) {
                return new int[N];
            }

            Map<Integer,List<Integer>> map = getGraph(edges);

            int[] childNodes = new int[N];
            int[] distNodes = new int[N];

            getDist(map,0,-1,distNodes,childNodes);
            getFinalDistance(map,0,-1,distNodes,childNodes);

            return distNodes;

        }


        public int getDist(Map<Integer,List<Integer>> map,int node,int parentNode, int[] distNodes, int[] childNodes) {

            int distance = 0;
            int childrenCount = 1;
            for (int children : map.get(node)) {
                if (parentNode  != children) {
                    int tempDistance = getDist(map,children, node,distNodes,childNodes);
                    distance+=tempDistance;
                    distance+=childNodes[children];
                    childrenCount+=childNodes[children];
                }
            }

            distNodes[node] = distance;
            childNodes[node] = childrenCount;

            return distance;
        }


        public void getFinalDistance(Map<Integer,List<Integer>> map, int node, int parentNode, int[] distNode, int[] childNodes) {

            for (int children : map.get(node)) {

                if (children == parentNode) continue;
                int parentDist = distNode[node];
                int childrenDist = distNode[children];

                int totChildren = childNodes[children];
                int remainingNodes = map.size()- totChildren;

                parentDist = (parentDist - childrenDist - totChildren);
                parentDist = parentDist+ remainingNodes;

                distNode[children] = childrenDist + parentDist;
                getFinalDistance(map,children,node,distNode,childNodes);
            }

        }

        public Map<Integer,List<Integer>> getGraph(int[][] edges) {
            Map<Integer,List<Integer>> map = new HashMap<>();

            for(int i = 0; i<edges.length;i++) {
                if (map.containsKey(edges[i][0])) {
                    map.get(edges[i][0]).add(edges[i][1]);
                }   else {
                    List<Integer> children = new ArrayList<>();
                    children.add(edges[i][1]);
                    map.put(edges[i][0],children);
                }

                if (map.containsKey(edges[i][1])) {
                    map.get(edges[i][1]).add(edges[i][0]);
                }   else {
                    List<Integer> children1 = new ArrayList<>();
                    children1.add(edges[i][0]);
                    map.put(edges[i][1],children1);
                }
            }

            return map;
        }

}
