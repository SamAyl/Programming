package MCA2;

import java.util.*;


    class Cycle {
        /*  Function to check if there is cycle in graph
         *   adj[]: array of vectors to represent graph
         *   n and e are number of nodes and edges respectively
         *   parent[]: array to store parent of nodes. Each index stores its node
         * value initially
         *   rank1[]: Each node from 1 to n store initial size as 1.
         */

        public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(11);
            for(int i = 0;i<12;i++) {
                adj.add(new ArrayList<>());
            }


            adj.get(1).add(2);
            adj.get(2).add(1);

            adj.get(1).add(3);
            adj.get(3).add(1);

            adj.get(1).add(10);
            adj.get(10).add(1);

            adj.get(3).add(5);
            adj.get(5).add(3);

            adj.get(3).add(6);
            adj.get(6).add(3);

            adj.get(4).add(7);
            adj.get(7).add(4);

            adj.get(4).add(9);
            adj.get(9).add(4);

            adj.get(5).add(9);
            adj.get(9).add(5);

            adj.get(6).add(8);
            adj.get(8).add(6);

            adj.get(6).add(10);
            adj.get(10).add(6);

            int[] parent = new int[11];
            int[] rank = new int[11];
            for(int i = 0;i<11;i++){
                parent[i] = i;
            }

            for(int i = 0;i<11;i++){
                rank[i] = 1;
            }
            System.out.println(findCycle(adj,parent,rank,10,10));
        }
        static boolean visited[][] = new boolean[1001][1001];
        static boolean findCycle(ArrayList<ArrayList<Integer>> adj, int parent[],
                                 int rank1[], int n, int e) {

            for(int i = 1;i<=n;i++){

                for(int j = 0;j<adj.get(i).size();j++) {
                    int str = i;
                    int end = (adj.get(i)).get(j);
                    if(visited[str][end]!=true && visited[end][str]!=true){
                        boolean checkAndUnion  =   union(str,end,parent,rank1);
                        if(checkAndUnion){
                            return true;
                        }
                        visited[str][end] = true;
                        visited[end][str] = true;
                    }
                }
            }

            return false;
        }


        public static boolean union(int s,int e,int[] parent,int[] rank1) {

            int parentS = findParent(s,parent);
            int parentE = findParent(e,parent);

            if(parentS == parentE){
                return true;
            }

            if(rank1[parentS] >= rank1[parentE]) {
                parent[parentE] = parent[parentS];
                rank1[parentE]= rank1[parentE]+1;
            }else {
                parent[parentS] = parent[parentE];
                rank1[parentS] = rank1[parentS]+1;
            }

            return false;

        }


        public static int findParent(int x,int[] parent) {
            if(parent[x] == x){
                return x;
            } else {
                int parentX = findParent(parent[x],parent);
                parent[x] = parentX;
                return parentX;
            }
        }
    }

