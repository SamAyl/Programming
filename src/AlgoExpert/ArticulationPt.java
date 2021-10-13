package AlgoExpert;

import java.util.*;

public class ArticulationPt {

    public static void main(String[] args) {
        Map<Integer,List<Integer>> grp = new HashMap<>();
        grp.put(0,new ArrayList<>());
        grp.put(1,new ArrayList<>());
        grp.put(2,new ArrayList<>());
        grp.put(3,new ArrayList<>());
        grp.put(4,new ArrayList<>());

        grp.get(0).add(1);
        grp.get(1).add(0);

        grp.get(1).add(2);
        grp.get(2).add(1);

        grp.get(3).add(2);
        grp.get(2).add(3);

        grp.get(3).add(4);
        grp.get(4).add(3);

        grp.get(4).add(0);
        grp.get(0).add(4);

        boolean[] ans = new boolean[5];
        getArticulation(grp,0,-1,new HashSet<>(),ans,new int[5],new int[5]);
        for(boolean val : ans) {
            System.out.println(val);
        }
    }

    public static int time = 0;
    public static void getArticulation(Map<Integer,List<Integer>> grp, int index, int parentIndex,
                                       Set<Integer> visited, boolean[] point, int[] depth, int[] lowestDepth) {


        visited.add(index);
        time++;
        depth[index] = time;
        lowestDepth[index] = time;

        int count = 0;
        for(Integer child : grp.get(index)) {
            if (visited.contains(child)) {
                 if (parentIndex != child) {
                     lowestDepth[index] = Math.min(lowestDepth[child], lowestDepth[index]);
                 }
            } else {
                getArticulation(grp,child,index,visited,point,depth,lowestDepth);
                lowestDepth[index] = Math.min(lowestDepth[child],lowestDepth[index]);
                count++;
            }

        }

        if (parentIndex == -1 && count >=2) {
            point[index] = true;
        } else if (parentIndex == -1 && count < 2) {
            point[index] = false;
        } else if (parentIndex != -1 && count == 0) {
            point[index] = false;
        } else {
            if (lowestDepth[index] >=depth[index]) {
                point[index] = true;
            } else {
                point[index] = false;
            }
        }



    }
}
