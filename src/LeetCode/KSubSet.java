package LeetCode;

import java.util.*;

public class KSubSet {

    public static void main(String[] args){
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        List<Integer> num = new ArrayList<>();

        for(Integer i : nums){
            num.add(i);
        }

        Collections.sort(num);


    }



    public boolean findSubSets(int[] num,int k){

        List<Set<Integer>> list = new ArrayList<>();
        int sum=0;
        Set<Integer> visited = new HashSet<>();
        int startIndex =0;
        int maxElementsInASet = num.length - k;

      




    return false;



    }
}
