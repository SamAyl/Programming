package DP;

import java.util.*;

public class LongestIncreasingSubSeq {

    public static void main(String[] args) {
        int[] arr = {29, 2, 32, 12, 30, 31};
        List<Integer> list = longestIncreasingSubsequence(arr);
        System.out.println(list);
    }

    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        int[] prev = new int[array.length];
        int[] len =  new int[array.length];

        prev[0] = 0;
        len[0] = 1;

        for (int i = 1; i< array.length; i++) {
            int tempPrev = i;
            int tempLen = 0;

            for (int j = 0; j<i;j++) {
                if (array[i] > array[j]) {
                    if (tempLen < len[j]) {
                        tempLen = len[j];
                        tempPrev = j;
                    }
                }

                tempLen +=1;
                prev[i] = tempPrev;
                len[i] = tempLen;
            }
        }


        int maxLength = 0;
        int maxIndex = -1;
        for (int k = 0; k < len.length; k++) {
            if (len[k] > maxLength) {
                maxLength = k;
                maxIndex = k;
            }
        }

        List<Integer> ans = new ArrayList<>();
        makeList(prev,array,maxIndex, ans);
        Collections.reverse(ans);
        return ans;
    }

    public static void makeList(int[] prev, int[] array, int idx,  List<Integer> list) {
        if (prev[idx] == idx) {
            list.add(array[idx]);
            return;
        }


        if (prev[idx] != idx) {
            list.add(array[idx]);
            makeList(prev,array,prev[idx],list);
        }

    }
}
