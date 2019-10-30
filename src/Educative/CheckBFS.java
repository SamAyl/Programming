package Educative;

import java.util.HashSet;
import java.util.Set;

class CheckBFS {


    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);

        System.out.println(bfsTraversal(g,0));
        System.out.println(dfsTraversal(g,0));
    }
    //Breadth First Traversal of Graph g from source vertex
    public static String bfsTraversal(Graph g, int source) {
        String result = "";
        int num_of_vertices = g.vertices;


        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(source);

        Set<Integer> visited = new HashSet<>();

        StringBuilder sb = new StringBuilder();


        while (!queue.isEmpty()){

            int node = queue.dequeue();
            if(!visited.contains(node)){
                sb.append(node);
                DoublyLinkedList<Integer> edges = g.adjacencyList[node];
                traverse(queue,visited,edges);
            }

        }
        // Write - Your - Code
        return sb.toString(); //For the above graph, it should return "01234" or "02143"
    }

    private static void traverse(Queue<Integer> queue,Set<Integer> visited,DoublyLinkedList<Integer> edges){

        DoublyLinkedList<Integer>.Node temp = edges.headNode;

        while (temp!=null ){
            if(!visited.contains(temp.data)){
                queue.enqueue(temp.data);
            }

            temp = temp.nextNode;
        }


    }


    public static String dfsTraversal(Graph g,int source){
        StringBuilder sb = new StringBuilder();
        dfsTraversal(g,source,new HashSet<>(),sb);
        return sb.toString();
    }

    private static void dfsTraversal(Graph g, int source,Set<Integer> visited,StringBuilder sb){

        if(!visited.contains(source)) {


            DoublyLinkedList<Integer> edges = g.adjacencyList[source];
            DoublyLinkedList<Integer>.Node temp = edges.headNode;

            sb.append(source);
            visited.add(source);

            while (temp != null) {
               dfsTraversal(g,temp.data,visited,sb);
               temp = temp.nextNode;
            }

        }
    }

}