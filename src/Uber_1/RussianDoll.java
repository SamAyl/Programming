package Uber_1;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {

    public static void main(String[] args) {
        int[][] a = {{5,4},{6,4},{6,7},{2,3}};

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });






        int[] p = new int[a.length];
        getMaxRussianDolls(a,a.length-1,p);


        int maxValue = 1;
        for(int maxV : p) {
            maxValue = Math.max(maxValue,maxV);
        }

        System.out.println(maxValue);

    }


    public static void getMaxRussianDolls(int[][] dolls, int idx, int[] prevDolls) {


        if (idx <0) {
            return;
        }

        int[] currentDoll = dolls[idx];
        int maxDolls = 1;
        for(int prevDoll = idx + 1 ; prevDoll < prevDolls.length; prevDoll++) {
            if (currentDoll[0] <dolls[prevDoll][0] && currentDoll[1] < dolls[prevDoll][1]) {
                maxDolls = Math.max(maxDolls,prevDolls[prevDoll]+1);
            }
        }

        prevDolls[idx] = maxDolls;
        getMaxRussianDolls(dolls,idx-1,prevDolls);

    }
}
