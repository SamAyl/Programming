package KickStart;

/**
 * This is a Dijkstra's algorithm using lazy strategy
 */

import java.util.*;
import java.util.PriorityQueue;

public class SPSS {

    public static void main(String[] args) {

        NodeX n0 = new NodeX(0);
        NodeX n1 = new NodeX(1);
        NodeX n2 = new NodeX(2);
        NodeX n3 = new NodeX(3);

        Map<Integer,Integer> map0 = new HashMap<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        map0.put(1,1);
        map0.put(2,1);

        map1.put(3,1);

        map2.put(1,1);
        map2.put(3,5);

        n0.edges = map0;
        n1.edges = map1;
        n2.edges = map2;

        Map<Integer,NodeX> map = new HashMap<>();
        map.put(0,n0);
        map.put(1,n1);
        map.put(2,n2);
        map.put(3,n3);

        int[] d = findSPSS(map,0);

        System.out.println(d);

    }

    public static int[] findSPSS(Map<Integer,NodeX> graph,int s){
        int[] dist = new int[graph.size()];
        setDist(dist);

        //to keep track of all visited nodes
        Set<Integer> visited = new HashSet<>();

        //to implement the greedy strategy we will be using Priority Queue which will
        //be based out of Heap Strategy
        PriorityQueue<Distance> priorityQueue = new PriorityQueue<>();

        //setting up the priorityQueue
        priorityQueue.add(new Distance(s,0));

        //implementing the greedy strategy
        while (!priorityQueue.isEmpty()){
            Distance minDistance = priorityQueue.poll();
            Integer nodeIndex = minDistance.node;
            if(!visited.contains(nodeIndex)) {
                visited.add(nodeIndex);
                dist[nodeIndex] = minDistance.distance;

                NodeX removedNode = graph.get(nodeIndex);
                Map<Integer, Integer> neighbourMap = removedNode.edges;

                for (Map.Entry<Integer, Integer> entry : neighbourMap.entrySet()) {
                    int nodeIndexValue = entry.getKey();
                    int edgeValue = entry.getValue();

                    Distance tempDistance = new Distance(nodeIndexValue,(edgeValue+minDistance.distance));
                    priorityQueue.add(tempDistance);
                }
            }
        }
        return dist;


    }


    public static void setDist(int[] dist){
        for(int i = 0;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
    }
}


class NodeX{
    int v;

    Map<Integer,Integer> edges = new HashMap<>();

    public NodeX(int v){
        this.v = v;
        edges = new HashMap<>();
    }
}

class Distance implements Comparable<Distance>{
    int node;
    int distance;

    Distance(int node,int distance){
        this.node = node;
        this.distance = distance;
    }

    public int compareTo(Distance o){
        if(o.distance>this.distance){
            return -1;
        }else if(o.distance < this.distance){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String s = "node "+node + "   " + "Distance "+ distance;
        return s;
    }



}


