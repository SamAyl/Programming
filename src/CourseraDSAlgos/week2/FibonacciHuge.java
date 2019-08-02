package CourseraDSAlgos.week2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {

        List<Long> periods = getPeriod(m);

        long size = periods.size();
        int periodIndex = (int)(n%size);

        return periods.get(periodIndex);
    }


    private static List<Long> getPeriod(long m){
        Long prev0 = 0l;
        Long prev1 = 1l;

        List<Long> period = new ArrayList<>();
        period.add(prev0);
        period.add(prev1);

        while (true){

            long val = prev0 + prev1;
            if(val%m==0 && (val+prev1)%m == 1){
                break;
            }else {

                long temp = val%m;
                period.add(temp);
                prev0 = prev1;
                prev1 = temp;
            }

        }

        return period;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}