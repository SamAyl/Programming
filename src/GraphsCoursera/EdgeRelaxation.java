package GraphsCoursera;

import java.util.*;

public class EdgeRelaxation {

    public static int[] getShortestPath(ArrayList<Integer>[] adj,Map<Edge,Integer> edgeMap,int s){

        int[] prev = new int[adj.length];
        Integer[] dist = setDistances(s,adj.length);

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(s);

        while (!queue.isEmpty()){
            int node = queue.poll();

            if(!visited.contains(node)){
                ArrayList<Integer> neighbours = adj[node];

                for(Integer neighbour : neighbours){
                    if(!visited.contains(neighbour)){
                        dist[neighbour] = dist[node] + edgeMap.get(new Edge(node,neighbour,0));
                        prev[neighbour] = node;
                    }else {
                        if(dist[neighbour] > dist[node]+edgeMap.get(new Edge(node,neighbour,0)));
                        {
                            dist[neighbour] = dist[node]+edgeMap.get(new Edge(node,neighbour,0));
                            prev[neighbour]=node;
                        }
                    }
                    queue.add(neighbour);
                }
                visited.add(node);
            }
        }

        return prev;

    }

    private static Integer[] setDistances(int s,int length){
        Integer[] dist = new Integer[length];
        for(int i = 0;i<length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s]=0;

        return dist;
     }

    public static void main(String[] args) {

        ArrayList<Integer>[] adj = new ArrayList[6];
        for(int i = 0;i<6;i++){
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[0].add(2);
        adj[0].add(3);

        adj[1].add(5);
        adj[1].add(2);

        adj[3].add(4);

        Edge e1 = new Edge(0,1,1);
        Edge e2 = new Edge(0,2,5);
        Edge e3 = new Edge(0,3,2);

        Edge e4 = new Edge(1,5,1);
        Edge e5 = new Edge(1,2,1);

        Edge e6 = new Edge(3,4,1);


        Map<Edge,Integer> edgeMap = new HashMap<>();
        edgeMap.put(e1,1);
        edgeMap.put(e2,5);
        edgeMap.put(e3,2);

        edgeMap.put(e4,1);
        edgeMap.put(e5,1);
        edgeMap.put(e6,1);

        int[] prev = getShortestPath(adj,edgeMap,0);
        System.out.println(prev);
    }
}

class Edge{

    int startNode;
    int endNode;
    int dist;

    Edge(int startNode,int endNode,int dist){
        this.startNode = startNode;
        this.endNode = endNode;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return startNode == edge.startNode &&
                endNode == edge.endNode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startNode, endNode);
    }
}
