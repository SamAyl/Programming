package SlidingWinProb;

import java.util.ArrayDeque;
import java.util.Iterator;

public class App {

    public static void main(String[] args) {
        int[] nums = {1,-1};
        int k   =1;

        int[] max = getMax(nums,k);

        System.out.println(max);
    }

    public static int[] getMax(int[] nums,int k){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] max = new int[nums.length-k+1];
        int indexForMaxArr = 0;

        int count=0;
        for(int i = 0;i<k;i++){
          queue.add(nums[i]);
        }
        count+=k;
        max[indexForMaxArr] = getMaxFromQueue(queue);
        int currentMax = max[indexForMaxArr];

        while (count<nums.length){
            indexForMaxArr++;
            queue.removeFirst();
            queue.addLast(nums[count]);
            if(currentMax<nums[count]){
                currentMax = nums[count];
                max[indexForMaxArr] = currentMax;
            }else {
                currentMax = getMaxFromQueue(queue);
                max[indexForMaxArr] = currentMax;
            }

            count++;
        }


        return max;

    }

    public static int getMaxFromQueue(ArrayDeque<Integer> queue){
        Iterator<Integer> it = queue.iterator();

        int max = Integer.MIN_VALUE;

        while (it.hasNext()){
            int temp = it.next();
            if(temp>max){
                max = temp;
            }
        }

        return max;
    }
}
