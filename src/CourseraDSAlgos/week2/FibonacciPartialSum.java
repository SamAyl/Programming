package CourseraDSAlgos.week2;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {

        long val1 = 0;
        long val2 = 0;

        if(to!=0){
            val1 = getPeriod(to+2);
            val1--;

            if(val1<0){
                val1= 9;
            }
        }

        if(from!=0){
            val2 = getPeriod(from+1);
            val2--;
            if(val2<0){
                val2= 9;
            }
        }


        if(val1<val2){
            val1+=10;

        }

        return val1-val2;
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

        int periodIndex1 = (int)((n)%period.size());


         return period.get(periodIndex1);


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

