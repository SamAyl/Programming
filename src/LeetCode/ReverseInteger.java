package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        int x = 123;

        while (x%10!=0){
            queue.add(x%10);
            x = x/10;
        }


        int size = queue.size();
        int num = 0;

        while(!queue.isEmpty()){

        }
    }
}
