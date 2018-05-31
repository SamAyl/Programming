package SlidingWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class App {

    public static void main(String[] args){
        int[] num = {1,-1};
        int k = 1;

        System.out.println(getMaxSlidingWindow(num,k));

    }

    public static Integer[] getMaxSlidingWindow(int[] num,int k){
        if(num==null || num.length<k){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                }else if(o1 < o2){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        int count = 0;
        for(int i =0;i<k;i++){
            priorityQueue.add(num[i]);
        }
        list.add(priorityQueue.peek());
        count+=k;

       for(int i = count;i<num.length;i++){
           priorityQueue.remove(num[i-k]);
           priorityQueue.add(num[i]);
           list.add(priorityQueue.peek());
       }


        return list.toArray(new Integer[list.size()]);
    }
}
