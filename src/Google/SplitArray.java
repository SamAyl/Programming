package Google;

import java.util.*;

public class SplitArray {

    public static void main(String[] args) {

        int[][] points = new int[2][2];

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                double d1 = Math.sqrt((double)(p1[0]*p1[0]) + (double)(p1[1]*p1[1]));
                double d2 = Math.sqrt((double)(p2[0]*p2[0]) + (double)(p2[1]*p2[1]));

                if(d1>d2){
                    return 1;
                } else if(d1<d2){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

//        int[][] ans = new int[K][2];
//
//        for(int i = 0;i<K;i++){
//            ans[i] = points[i];
//        }
//
//        return ans;
    }


}

class Sort implements Comparator<int[]> {

    public int compare(int[] p1, int[] p2){
        double d1 = Math.sqrt((double)(p1[0]*p1[0]) + (double)(p1[1]*p1[1]));
        double d2 = Math.sqrt((double)(p2[0]*p2[0]) + (double)(p2[1]*p2[1]));

        if(d1>d2){
            return 1;
        } else if(d1<d2){
            return -1;
        } else {
            return 0;
        }
    }
    }
