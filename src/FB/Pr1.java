package FB;

import java.util.*;

public class Pr1 {

    public static void main(String[] args) {
        Pr1 p = new Pr1();
        int[] wells = {1,2,2};
        int[][] pipes = {{1,2,1},{2,3,1}};
        int ans = p.minCostToSupplyWater(3,wells,pipes);
        System.out.println(ans);
    }

        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

            Map<Integer,List<Edges>> map = new HashMap<>();

            for (int[] singlePipe : pipes) {
                Edges e1 = new Edges(singlePipe[0],singlePipe[1],singlePipe[2]);
                if (map.containsKey(singlePipe[0])) {
                    map.get(singlePipe[0]).add(e1);
                } else {
                    List<Edges> list1 = new ArrayList<>();
                    list1.add(e1);
                    map.put(singlePipe[0],list1);
                }


                if (map.containsKey(singlePipe[1])) {
                    map.get(singlePipe[1]).add(e1);
                } else {
                    List<Edges> list2 = new ArrayList<>();
                    list2.add(e1);
                    map.put(singlePipe[1],list2);
                }
            }



            int strNode  = getStrNode(wells);
            int cost = wells[strNode];
            strNode++;


            Set<Integer> visited = new HashSet<>();

            PriorityQueue<Edges> pq = new PriorityQueue<>(new Comparator<Edges>() {
                @Override
                public int compare(Edges o1, Edges o2) {
                    return o1.weight - o2.weight;
                }
            });

            pq.addAll(map.get(strNode));
            Set<Edges> processedEdges = new HashSet<>();
            processedEdges.addAll(map.get(strNode));
            int currNode = strNode;
            visited.add(currNode);

            while(visited.size() != wells.length) {
                   Edges temp = getNextEdge(visited,pq);
                   int cost1 = temp.weight;
                   int nextNode = -1;

                   if (visited.contains(temp.n1)) {
                       nextNode = temp.n2;
                   } else {
                       nextNode = temp.n1;
                   }

                   int selfCost = wells[nextNode-1];

                   cost+=Math.min(cost1,selfCost);

                   pq.addAll(map.get(nextNode));
                   visited.add(nextNode);
            }


            return cost;


        }


        public Edges getNextEdge(Set<Integer> visited , PriorityQueue<Edges> pq) {

            while (!pq.isEmpty()){
                Edges e1 = pq.poll();
                if (visited.contains(e1.n1) && visited.contains(e1.n2)){
                    continue;
                } else {
                    return e1;
                }
            }

            return null;
        }

        public int getStrNode(int[] wells){
            int minNode = 0;
            int minCost = wells[minNode];

            for(int i = 1; i<wells.length;i++){
                if (wells[i] < minCost){
                    minCost = wells[i];
                    minNode = i;
                }
            }

            return minNode;
        }


    }

    class Edges {
        int n1;
        int n2;
        int weight;

        public Edges(int n1, int n2, int weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }


        @Override
        public int hashCode(){
            return Objects.hash(n1,n2);
        }

        @Override
        public boolean equals(Object o) {
            Edges e = (Edges)o;
            return e.n1 == this.n1 && e.n2 == this.n2;
        }
    }

