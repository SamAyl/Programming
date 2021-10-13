package Google;

public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] nums = {1,2,0};

        System.out.println(m.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int count = 0;
        int nonPositiveNumbers = 0;
        while(count<nums.length){
            if(nums[count]<=0){
                nonPositiveNumbers++;

            }
            count++;
        }


        int totPositiveNumbers = nums.length - nonPositiveNumbers;
        count = 0;

        while(count<nums.length){
            if(nums[count] == count+1){
                count++;
            } else {
                int number = nums[count];
                //This is for duplicates
                if(number>=1 && number<=totPositiveNumbers && nums[number-1]!=number) {
                    swap(number-1,count,nums);
                } else{
                    count++;
                }
            }
        }


        int missingNumber = 1;
        for(int i = 0;i<totPositiveNumbers;i++){
            if(missingNumber!=nums[i]){
                return missingNumber;
            } else {
                missingNumber++;
            }
        }

        return missingNumber;

    }


    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

