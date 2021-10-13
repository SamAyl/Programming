package AlgoExpert;

import java.util.*;

public class Cal {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(2,-1);

//        for(int i : list) {
//            System.out.println(i);
//        }

        int[] num =  {0,1,2,3,5,9,16};
        int str = 0;
        int end = num.length-1;
        int mid = -1;
        while (str <=end) {

            mid = (str+end)/2;
            if (num[mid] < -1) {
                str = mid+1;
            } else if (num[mid] == -1) {
                System.out.println("got it");
                break;
            } else {
                end = mid -1;
            }
        }

        System.out.println(mid);
    }



}
