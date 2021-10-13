package AlgoExpert;

import java.util.*;

public class SubSeq {

    public static void main(String[] args) {
        int[] arr = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        List<Integer> a = longestIncreasingSubsequence(arr);
        for(Integer s : a ){
            System.out.println(s);
        }
    }
    public static List<Integer> ans = new ArrayList<>();
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        } else if (array.length == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(array[0]);
            return res;
        }




      List<List<Integer>> answers =   longestIncSubSequence(array,0);
      List<Integer> longestList = null;
        int maxSize = Integer.MIN_VALUE;
        for (List<Integer> finalAns : answers ) {
            if (finalAns.size() > maxSize) {
                longestList = finalAns;
            }
        }

        return longestList;
    }


    public static List<List<Integer>> longestIncSubSequence(int[] arr, int index) {

         if (index == arr.length-1) {
             List<Integer> lastIndexAns = new ArrayList<>();
             lastIndexAns.add(arr[index]);

             List<List<Integer>> finalAns = new ArrayList<>();
             finalAns.add(lastIndexAns);
             return finalAns;
         }

        List<List<Integer>> ans = longestIncSubSequence(arr,index+1);
        boolean matchFound = false;
        for(List<Integer> a : ans) {
            if(a.get(a.size()-1) > arr[index]) {
                a.add(arr[index]);
                matchFound = true;
            }
        }

        if (!matchFound) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[index]);
            ans.add(list);
        }

        return ans;



    }
}
