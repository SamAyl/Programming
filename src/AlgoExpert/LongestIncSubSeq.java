package AlgoExpert;

import java.util.*;

public class LongestIncSubSeq {

    public static void main(String[] args) {
        int[] arr = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        int[] len = new int[arr.length];
        int[] par = new int[arr.length];

       len[0] = 1;
       par[0] = 0;

        for (int i = 1; i< arr.length; i++) {
            int Len = 1;
            int ParIdx = i;

            for (int j = 0; j<i;j++) {
                if (arr[i] > arr[j]) {
                    if (Len < len[j] + 1) {
                        Len = len[j] + 1;
                        ParIdx = j;
                    }
                }
            }

            len[i] = Len;
            par[i] = ParIdx;
        }


        int maxLength = Integer.MIN_VALUE;
        int maxIdx = -1;

        for(int i = 0; i < len.length; i++) {
           if (len[i] > maxLength) {
               maxLength = len[i];
               maxIdx = i;
           }
        }

        List<Integer> list = new ArrayList<>();
        getList(arr,par,maxIdx,list);

        Collections.reverse(list);

        for(int i : list) {
            System.out.println(i);
        }
    }


    public static void getList(int[] arr, int[] par, int idx,List<Integer> list) {

        if(par[idx] == idx) {
            list.add(arr[idx]);
            return;
        } else {
            list.add(arr[idx]);
            getList(arr,par,par[idx],list);
            return;
        }
    }
}
