package ByteByByte.Selection;

import java.util.*;

public class TargetSun {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int sum = 4;


        generateTargetSum(arr,0,0,sum,new ArrayList<>());
        print(ans);
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static void generateTargetSum(int[] arr, int idx, int tempSum, int sum, List<Integer> tempAns) {

        if(idx== arr.length){
            return;
        }


        tempSum+=arr[idx];
        tempAns.add(arr[idx]);
        if (tempSum < sum) {
            generateTargetSum(arr,idx,tempSum,sum,tempAns);
        } else if (tempSum == sum) {
            List<Integer> tempArr = new ArrayList<>();
            tempArr.addAll(tempAns);
            ans.add(tempArr);
        }

        tempSum-=arr[idx];
        tempAns.remove(tempAns.size()-1);

        generateTargetSum(arr,idx+1,tempSum,sum,tempAns);

    }





    public static void print(List<List<Integer>> list) {
        for(List<Integer> list2 : list) {
            for(Integer singleNumber : list2) {
                System.out.print(singleNumber);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
