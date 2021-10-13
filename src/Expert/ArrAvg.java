package Expert;

import java.util.*;


class ArrAvg {

    public static void main(String[] args) {
        ArrAvg arrAvg = new ArrAvg();
        int[] a = {17,5,5,1,14,10,13,1,6};
        System.out.println(arrAvg.splitArraySameAverage(a));
    }
    public boolean splitArraySameAverage(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }

        int totSum = getTotSum(nums);
        return checkSplitArray(nums, new HashSet<Integer>(),totSum,0);
    }



    public boolean checkSplitArray(int[] nums, Set<Integer> visitedIndices , int totSum, int currSum) {
        if (visitedIndices.size() == nums.length-1) {
            return false;
        }


        boolean ansFound = false;
        for(int i = 0; i< nums.length; i++) {
            if (!visitedIndices.contains(i)) {
                visitedIndices.add(i);
                currSum+=nums[i];
                totSum-=nums[i];

                if ((totSum * visitedIndices.size()) == (currSum * (nums.length - visitedIndices.size()))) {
                    return true;
                }else {
                    ansFound = checkSplitArray(nums,visitedIndices,totSum,currSum);
                    if (ansFound) {
                        return ansFound;
                    } else {
                        currSum-=nums[i];
                        totSum-=nums[i];
                        visitedIndices.remove(i);
                    }
                }
            }
        }

        return ansFound;




    }


    public int getTotSum(int[] nums) {
        int sum = 0;
        for(int singleNum : nums) {
            sum+= singleNum;
        }

        return sum;
    }


}