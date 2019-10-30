package Educative;

import java.util.*;

public class CycleDetection {

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.addEdge(0,1);
        g.addEdge(1,2);

        System.out.println(findMotherVertex(g));
    }

    public static int findMotherVertex(Graph g){


        Set<Integer> remainingNodes = new LinkedHashSet<>();
        int startNode = getStartIndex(g,remainingNodes);

        Map<Integer,Integer> parentMap = new HashMap<>();


        Integer[] nodes = new Integer[2];
        nodes[0] = startNode;
        nodes[1] = nodes[0];

        Set<Integer>[] nodesTraverse = new HashSet[2];
        nodesTraverse[1] = remainingNodes;


        while (!remainingNodes.isEmpty()) {
            parentMap.put(startNode,-1);
            nodesTraverse[0] = new HashSet<Integer>();
            dfs(nodes,g,nodesTraverse,parentMap);
            startNode = remainingNodes.iterator().hasNext()?remainingNodes.iterator().next():-1;

        }


        int parent = -1;
        for(Map.Entry<Integer,Integer> entry : parentMap.entrySet()){
                if(parent==-1){
                    parent = entry.getValue();
                }else {
                    if(parent!=entry.getValue()){
                        parent =-1;
                        break;
                    }
                }


        }

        return parent;


    }


    //nodeTraverse 0 => visitedNodes
    //nodeTraverse 1 => remainingNodes

    //nodes 0 => currentNode
    //nodes 1 => startNode

    private static void dfs(Integer[] nodes,Graph g,Set<Integer>[] nodesTraverse,Map<Integer,Integer> parentMap){
        if(!nodesTraverse[0].contains(nodes[0])){
            DoublyLinkedList<Integer> edges = g.adjacencyList[nodes[0]];
            DoublyLinkedList<Integer>.Node temp = edges.headNode;

            nodesTraverse[0].add(nodes[0]);
            nodesTraverse[1].remove(nodes[0]);

            if(parentMap.containsKey(nodes[0])){
                parentMap.put(nodes[0],nodes[1]);
            }

            while (temp!=null){
                nodes[0] = temp.data;
                dfs(nodes,g,nodesTraverse,parentMap);
                temp = temp.nextNode;
            }
        }
    }

    private static int getStartIndex(Graph g, Set<Integer> remainingNodes){

      DoublyLinkedList<Integer>[] edges = g.adjacencyList;
      int size = -1;
      int index = -1;


      for(int i = 0;i<edges.length;i++){

          if(size<edges[i].size){
              size = edges[i].size;
              index = i;
          }
          remainingNodes.add(i);
      }

      return index;
    }
}
