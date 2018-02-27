package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args){
        int[]  a = {3,2,4};
      int[] res =   twoSum(a,6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {


        int[] res = new int[2];
        if(nums.length == 0){
            return null;
        }

        if(nums.length==1){
            return null;
        }

      Num[] num = new Num[nums.length];

      for(int i  = 0;i<nums.length;i++){
          num[i] = new Num(nums[i],i);
      }


        Arrays.sort(num);

        int i = 0;
        int j = nums.length-1;

        while (i!=j && j>i){
            if(num[j].value+num[i].value== target){
                res[0] = num[i].index;
                res[1] = num[j].index;
                j--;
                i++;
            }else if(num[j].value>=target){
                j--;
            }else if(num[j].value+num[i].value>target){
                j--;
            }else if(num[j].value+num[i].value < target){
                i++;
            }
        }

        return res;



    }
}

class Num implements Comparable<Num>{
    int value;
    int index;

    public Num(int value,int index){
        this.value  = value;
        this.index = index;
    }

    public int compareTo(Num o){
        return this.value - o.value;
    }
}
