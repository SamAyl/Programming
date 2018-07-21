package PermutateII;

import java.util.*;

public class App {


    public static void main(String[] args) {
        int[] n = {1,1,2};
        Set<List<Integer>> set = new HashSet<>();
        permutate(n,new HashSet<>(),set,new ArrayList<>());
        List<List<Integer>> lists = new ArrayList<>(set);
        System.out.println(lists);
    }


    public static void permutate(int[] num,Set<Integer> visited,Set<List<Integer>> result,List<Integer> nums){
        if(nums.size() == num.length){
            if(!result.contains(nums)){
               result.add(new ArrayList<>(nums));
            }
        }

        for(int i = 0;i<num.length;i++){
            if(!visited.contains(i)) {
                nums.add(num[i]);
                visited.add(i);
                permutate(num, visited, result, nums);
                nums.remove(nums.size() - 1);
                visited.remove(i);
            }

        }
    }
}
