package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This problem is same as TwoSum problem
 */
public class SumTwo {

    public static void main(String[] args){
        int[] nums  = {1,3,4,2,5,6};


        System.out.println(get2Sum(nums,7));
    }

    public static List<List<Integer>> get2Sum(int[] a,int sum){
        List<List<Integer>> ans = new ArrayList<>();
        for(int j = a.length-1;j>=1;j--){
            if(a[j]>=sum){
                continue;
            }else {
                int count = 0;
                List<Integer> numbers = new ArrayList<>();
                while (count!=j){
                    if(a[j]+a[count]==sum){
                        numbers.add(a[count]);
                        numbers.add(a[j]);
                        ans.add(numbers);
                        break;
                    }else {
                        count++;
                    }
                }
            }
        }


        return ans;
    }
}
