package AlgoExpert;


import java.util.*;

public class App7 {

    public static void main(String[] args) {
        int[] distanceArray = new int[6];
        Map<Integer,List<Integer>> grp = new HashMap<>();

        // [[0,1],[0,2],[2,3],[2,4],[2,5]]
        grp.put(0,new ArrayList<>());
        grp.put(1,new ArrayList<>());
        grp.put(2,new ArrayList<>());
        grp.put(3,new ArrayList<>());
        grp.put(4,new ArrayList<>());
        grp.put(5,new ArrayList<>());

        grp.get(0).add(1);
        grp.get(1).add(0);

        grp.get(0).add(2);
        grp.get(2).add(0);

        grp.get(2).add(3);
        grp.get(3).add(2);

        grp.get(2).add(4);
        grp.get(4).add(2);

        grp.get(2).add(5);
        grp.get(5).add(2);

        for (int i = 0; i<6;i++) {

            Set<Integer> visited = new HashSet<>();
            int[] dist =  calculateDist( grp, i,visited);
            distanceArray[i] = dist[1];
        }


        for (int dist1 : distanceArray) {
            System.out.println(dist1);
        }
    }


    public static int[] calculateDist(Map<Integer,List<Integer>> grp, int currNode, Set<Integer> visitedNodes) {


        visitedNodes.add(currNode);
        int childrenCount = 1;
        int distance = 0;
        for (Integer children : grp.get(currNode)) {
            if (visitedNodes.contains(children)) continue;
            int[] distchild = calculateDist(grp, children, visitedNodes);
            distance += distchild[1]+ distchild[0];
            childrenCount+=distchild[0];
        }

        int[] dist = new int[2];
        dist[0] = childrenCount;
        dist[1] = distance;
        return dist;
    }
}
