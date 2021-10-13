package AlgoExpert;

import java.util.*;

public class Goog1 {

    public static void main(String[] args) {
        int fib_prev = 0;
        int fib_curr = 1;

        Set<Integer> fibSet = new HashSet<>();
        fibSet.add(0);

        while (fib_curr > 0 && fib_curr < Integer.MAX_VALUE) {

            fibSet.add(fib_curr);
            int temp = fib_curr;
            fib_curr = fib_curr + fib_prev;
            fib_prev = temp;

        }

        int str = 15;
        int end = 17;

        int num = str;
        int fibBinCount = 0;

        while (num <= end) {
            int count = getBinaryCount(num);
            if (fibSet.contains(count)) {
                System.out.println(count);
                fibBinCount++;
            }
            num++;
        }

        System.out.println(fibBinCount);
    }

    public static int getBinaryCount(int num) {

         int oneCount = 0;

         while(num > 0) {
             if (num%2 == 1) {
                 oneCount++;

                 if (num == 1) {
                     break;
                 }
             }

             num = num/2;

         }

         return oneCount;
    }
}
