package Google;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-1,4,0,0,-4,-5,-4,-5,0,2,-5,2,-2};
        List<List<Integer>> ans = s.threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int zeroIndex = getZeroIndex(nums);

        if(nums[0]>0 || nums[nums.length-1]<=0){
            return new ArrayList<>();
        }

        int negativeStart = 0;
        int negativeEnd = -1;

        int positiveStart = -1;
        int positiveEnd = nums.length-1;

        if(nums[zeroIndex] <=0){
            negativeEnd = zeroIndex;
            positiveStart = zeroIndex+1;
        } else {
            negativeEnd = zeroIndex-1;
            positiveStart = zeroIndex;
        }



        Set<List<Integer>> ans = new HashSet<>();
        int zeroCount = getZeroCount(nums);
        if(zeroCount>3){
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(0);
            temp.add(0);

            ans.add(temp);
        }
        for(int i = positiveStart;i<=positiveEnd;i++){
            ans.addAll(getTwoSum(nums,(nums[i]*-1),negativeStart,negativeEnd,false));
        }

        for(int j = negativeStart;j<=negativeEnd;j++){
            ans.addAll(getTwoSum(nums,(nums[j]*-1),positiveStart,positiveEnd,true));
        }

        return new ArrayList<List<Integer>>(ans);
    }

    public  List<List<Integer>> getTwoSum(int[] nums, int target,int str,int end,boolean positiveEnd) {

        int left = str;
        int right = end;

        List<List<Integer>> ans = new ArrayList<>();

        while(left<right){
            if(nums[left] + nums[right] == target){
                List<Integer> temp = new ArrayList<>();
                int targetElement = target * -1;
                if(positiveEnd){
                    temp.add(targetElement);
                }
                temp.add(nums[left]);
                temp.add(nums[right]);

                if(!positiveEnd){
                    temp.add(targetElement);
                }
                ans.add(temp);
                left++;
                right--;
            } else if(nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return ans;

    }


    public int getZeroIndex(int[] nums){
        int str = 0;
        int end = nums.length-1;

        int mid = -1;


        while(str<=end){
            mid = (str+end)/2;

            if(nums[mid] == 0){
                return mid;
            } else if( nums[mid]>0){
                end = mid-1;
            } else {
                str = mid+1;
            }
        }

        return mid;
    }


    public int getZeroCount(int[] nums){
         int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] ==0){
                count++;
            }
        }

        return count;
    }



}
