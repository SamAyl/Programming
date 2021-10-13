package AlgoExpert;

import java.util.*;

public class StronglyConnectedComponents {

    public static void main(String[] args) {

        Map<Integer,List<Integer>> grp = new HashMap<>();
        grp.put(0,new ArrayList<>());
        grp.put(1,new ArrayList<>());
        grp.put(2,new ArrayList<>());
        grp.put(3,new ArrayList<>());
        grp.put(4,new ArrayList<>());


        grp.get(0).add(1);
        grp.get(1).add(2);
        grp.get(2).add(0);
        grp.get(3).add(1);
        grp.get(3).add(4);


    }

    public static int getTimeOutForDFS(int v, Map<Integer,List<Integer>> grp, Set<Integer> visited, PriorityQueue<Tout> tout){
        List<Integer> child = grp.get(v);
        visited.add(v);
        int totTime = 1;
        for(Integer node : child) {
            if(!visited.contains(node)) {
                totTime+=getTimeOutForDFS(node,grp,visited,tout);
            }
        }

        Tout tout1 = new Tout(v,totTime);
        tout.add(tout1);
        return totTime;
    }

    public static void addConnectedComp() {

    }



}

class Tout implements Comparable<Tout>{
    int v;
    int tOut;

    public Tout(int v, int tOut) {
        this.v = v;
        this.tOut = tOut;
    }

    public int compareTo(Tout O) {
        return O.tOut - tOut;
    }
}

