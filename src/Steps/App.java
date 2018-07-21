package Steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {



    public static void main(String[] args) {
        int[] num = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        //System.out.println(findStep(num,0,num[0]));
        System.out.println(minJumps(num));
    }


    public static boolean findStep(int[] nums, int index, int numberAtIndex){
        if(index< nums.length-1 && (nums.length-1-index)<=numberAtIndex){
            return true;
        }else if(index> nums.length-1) {

            return false;

        } else {
            int temp = numberAtIndex;
            if(temp==0){
                return false;
            }
            boolean check = findStep(nums, index+numberAtIndex, nums[index+numberAtIndex]);

            temp--;
            while (!check && temp!= 0) {


                check = findStep(nums, index, temp);
                temp--;
            }

            return check;
        }

    }


    public static int minJumps(int[] num){
        if(num.length==1){
            return 0;
        }
        int[] jumps = new int[num.length];

        for(int i = 0;i<num.length-1;i++){
            int jump = i+num[i];
            jumps[i] = jump;
        }

        jumps[num.length-1] = num[num.length-1];



        int index = 0;
        int count = 0;
        int maxJump =0;
        while (index<num.length-1){
             maxJump = jumps[index];
            maxJump = check(jumps,index,maxJump);

            if(maxJump==-1){
                break;
            }else{
                index = maxJump;
                count++;
            }

        }

        if(maxJump!=-1){
            return Integer.MIN_VALUE;
        }else {
            return count+1;
        }



    }


    public static int check(int[] jumps,int start, int maxJump){

        if(maxJump>=jumps.length-1){
            return -1;
        }else {


            int index = maxJump;

            for(int i = start+1;i<maxJump;i++){
                if(jumps[i]> jumps[maxJump] && jumps[i] > jumps[index]){
                    index = i;
                }
            }

            return index;
        }
    }


}


