package CourseraDSAlgos.week2;

import java.util.Scanner;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {

        if(n==0 || n==1){
            return n;
        }

        long prev0 = 0;
        long prev1 = 1;

        long sum = 1;

        for(long i = 2;i<=n;i++){
            long val = prev0 + prev1;

            val = val%10;

            prev0 = prev1;
            prev1 = val;

            val = val * val;
            val= val%10;

            sum+=val;
            sum= sum %10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}
