package AlgoExpert;

import java.util.*;

//[
//  [1, 5],
//  [5, 1],
//  [4, 2],
//  [2, 4],
//  [2, 2],
//  [1, 2],
//  [4, 5],
//  [2, 5],
//  [-1, -2]
//]
public class MinAreaRect {

    public static void main(String[] args) {
        int[][] points = {{1,5},{5,1},{4,2},{2,4},{2,2},{1,2},{4,5},{2,5},{-1,-2}};
      int minArea =   findMinArea(points);
        System.out.println(minArea);
    }

    public static int findMinArea(int[][] points) {
        Map<Integer,Set<Integer>> pointMap = new HashMap<>();

        for(int[] singlePoint : points) {
            if (pointMap.containsKey(singlePoint[0])) {
                pointMap.get(singlePoint[0]).add(singlePoint[1]);
            } else {
                Set<Integer> ySet = new HashSet<>();
                ySet.add(singlePoint[1]);
                pointMap.put(singlePoint[0],ySet);
            }
        }

        int minDist = Integer.MAX_VALUE;


        Set<Integer> visited = new HashSet<>();
        for(Integer xPoint1 : pointMap.keySet()) {
            Set<Integer> yPoints1 = pointMap.get(xPoint1);
            for(Integer xPoint2 : pointMap.keySet()) {
                if (xPoint1 != xPoint2 && !visited.contains(xPoint1)) {
                    Set<Integer> yPoints2 = pointMap.get(xPoint2);

                    Set<Integer> temp = new HashSet<>(yPoints1);
                    temp.retainAll(yPoints2);

                    int tempMinDist = getMinDist(xPoint1,xPoint2,temp);
                    if (tempMinDist< minDist) {
                        minDist = tempMinDist;
                    }
                }
            }
        }


        return minDist;
    }


    public static int getMinDist(int x1, int x2, Set<Integer> y) {
        if (y.size() == 0) {
            return Integer.MAX_VALUE;
        }

        List<Integer> list  = new ArrayList<>();
        list.addAll(y);
        Collections.sort(list);

        int length = Math.abs(x1-x2);
        int area = Integer.MAX_VALUE;
        for(int i = 0; i<list.size()-1;i++ ) {
         int tempArea = length * Math.abs(list.get(i) - list.get(i+1));
         if (tempArea < area) {
             area = tempArea;
         }
        }

        return area;
    }
}
