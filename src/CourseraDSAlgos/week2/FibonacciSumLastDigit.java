package CourseraDSAlgos.week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
      long ans =  getPeriod(n+2) - 1;
      if(ans<0){
         return 9;
      }else {
          return ans;
      }
    }

    private static long getPeriod(long n){
        Long prev0 = 0l;
        Long prev1 = 1l;

        List<Long> period = new ArrayList<>();
        period.add(prev0);
        period.add(prev1);

        while (true){

            long val = prev0 + prev1;
            if(val%10==0 && (val+prev1)%10 == 1){
                break;
            }else {

                long temp = val%10;
                period.add(temp);
                prev0 = prev1;
                prev1 = temp;
            }

        }

        int periodIndex = (int)((n)%period.size());
        return period.get(periodIndex);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

