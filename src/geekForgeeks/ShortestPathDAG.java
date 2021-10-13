package geekForgeeks;

import java.util.*;

public class ShortestPathDAG {

    public static void main(String[] args) {


        int[] shortestPath = shortestPath(getMap2(),1);
        for(int i = 0;i<shortestPath.length;i++){
            System.out.println(i + "==" + shortestPath[i]);
        }

    }


    public  static int[] shortestPath(Map<Integer,List<Dist>> grp, int src){
       List<Integer> topoSort = new LinkedList<>();
       Stack<Integer> topoOrder = new Stack<>();
       topoSort(src,grp,topoOrder,new HashSet<>());

       while (!topoOrder.isEmpty()){
           topoSort.add(topoOrder.pop());
       }


       return getShortestPath(grp,topoSort,src);
    }

    public static int[] getShortestPath(Map<Integer,List<Dist>> grp,List<Integer> topoSort,int src){
        int[] dist = new int[grp.size()];
        for(int i = 0;i<dist.length;i++){
            if(i==src){
                dist[i] = 0;
             } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Iterator<Integer> it = topoSort.iterator();

        while (it.hasNext()){
            int node = it.next();
            List<Dist> adj = grp.get(node);
            for(Dist d : adj){
                if(dist[d.end] > (d.dist + dist[d.str])){
                    dist[d.end] = d.dist+dist[d.str];
                }
            }
        }

        return dist;
    }
    public static void topoSort(Integer str,Map<Integer,List<Dist>> grp,Stack<Integer> topoSort,Set<Integer> visited){


        if(!visited.contains(str)) {

            visited.add(str);


            for (Dist adj : grp.get(str)) {
                topoSort(adj.end, grp, topoSort, visited);
            }

            topoSort.push(str);
        }
    }

    static class Dist {
        int str;
        int end;
        int dist;

        Dist(int str,int end,int dist){
            this.str = str;
            this.end = end;
            this.dist = dist;
        }

    }

    public static Map<Integer,List<Dist>> getMap1(){
        Dist d01 = new Dist(0,1,2);
        Dist d04 = new Dist(0,4,1);
        Dist d12 = new Dist(1,2,3);
        Dist d42 = new Dist(4,2,2);
        Dist d45 = new Dist(4,5,4);
        Dist d53 = new Dist(5,3,1);
        Dist d23 = new Dist(2,3,6);

        Map<Integer,List<Dist>> map = new HashMap<>();
        for(int i = 0;i<6;i++){
            map.put(i,new ArrayList<>());
        }

        map.get(0).add(d01);
        map.get(0).add(d04);

        map.get(1).add(d12);
        map.get(4).add(d42);
        map.get(4).add(d45);

        map.get(5).add(d53);
        map.get(2).add(d23);


        return map;
    }

    public static Map<Integer,List<Dist>> getMap2(){
        Dist d01 = new Dist(0,1,1);
        Dist d12 = new Dist(1,2,3);
        Dist d23 = new Dist(2,3,4);
        Dist d13 = new Dist(1,3,2);

        Map<Integer,List<Dist>> map = new HashMap<>();

        for(int i = 0;i<4;i++){
            map.put(i,new ArrayList<>());
        }


        map.get(0).add(d01);
        map.get(1).add(d12);
        map.get(1).add(d13);
        map.get(2).add(d23);

        return map;
    }
}
