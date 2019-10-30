package GraphsCoursera;

import java.util.*;


public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> finishFirst = new Stack<>();

        for(int i = 0;i<adj.length;i++){
            if(!visited.contains(i)){
                visited.add(i);
                explore(i,adj,visited,finishFirst);
            }
        }

        ArrayList<Integer>[] reverse = reverseGraph(adj);

        Set<Integer> reverseVisited = new HashSet<>();
        int[] count = new int[1];

        while (!finishFirst.isEmpty()){
            int node = finishFirst.pop();
            if(!reverseVisited.contains(node)){
                reverseVisited.add(node);
                explore(node,reverse,reverseVisited);
                count[0]+=1;
            }
        }

        return count[0];
    }


    private static void explore(int start, ArrayList<Integer>[] adj,Set<Integer> visited,Stack<Integer> finishFirst){

        ArrayList<Integer> neighbors = adj[start];
        for(int neighborNodes : neighbors){
            if(!visited.contains(neighborNodes)){
                visited.add(neighborNodes);
                explore(neighborNodes,adj,visited,finishFirst);
            }
        }

        finishFirst.push(start);
    }


    private static void explore(int start,ArrayList<Integer>[] reverseGraph,Set<Integer> reverseVisited){

        for(int neighborNode : reverseGraph[start]){
            if(!reverseVisited.contains(neighborNode)){
                reverseVisited.add(neighborNode);
               explore(neighborNode,reverseGraph,reverseVisited);
            }
        }
    }


    public static ArrayList[] reverseGraph(ArrayList<Integer>[] graph){
        if(graph==null || graph.length==0){
            return graph;
        }

        ArrayList<Integer>[] reverse = new ArrayList[graph.length];
        initializeGraph(reverse);

        for(int nodeCount = 0;nodeCount<graph.length;nodeCount++){
            ArrayList<Integer> edges = graph[nodeCount];
            for(int node : edges){
                reverse[node].add(nodeCount);
            }
        }

        return reverse;
    }


    private static void initializeGraph(ArrayList<Integer>[] graph){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        adj[0].add(1);

        adj[1].add(0);
        adj[1].add(2);

        adj[2].add(3);

        adj[3].add(4);
        adj[4].add(3);



        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

