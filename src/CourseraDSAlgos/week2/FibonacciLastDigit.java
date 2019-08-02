package CourseraDSAlgos.week2;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {

        if(n==0 || n ==1){
            return n;
        }

        int prev0 = 0;
        int prev1 = 1;

        int lastDigit = 0;
        for(int i = 2;i<=n;i++){

            int val = prev0 + prev1;
            val = val%10;

            prev0 = prev1;
            prev1 = val;

            lastDigit = val;

        }

        return  lastDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

