package Coursera;

import java.util.*;

public class FibonacciHuge {

    private static long getFibonacciHugeNaive(long n, long m) {
     if(n==0 || n == 1){
         return n%m;
     }

       String s = getPeriod(m);
       long periodLength = s.length();

        return n%periodLength;
    }


    private static String  getPeriod(long m){
      StringBuilder sb = new StringBuilder();
      sb.append(0);
      sb.append(1);

      long prev0 =0;
      long prev1 =1;

      while (true){
          long val = prev0 + prev1;
          long modVal = val%m;

          if(modVal == 0 && (val+prev1)%m == 1){
              break;
          }else {
              sb.append(modVal);
              prev0 = prev1;
              prev1 = val;
          }
      }


      return sb.toString();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
