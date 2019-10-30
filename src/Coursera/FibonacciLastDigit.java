package Coursera;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
     if(n==0 || n== 1){
         return n;
     }

        int prev  =1;
        int old_prev =0;

        int lastDigit = 0;

        for(int i =2;i<=n;i++){
            lastDigit = prev + old_prev;
            lastDigit = lastDigit%10;
            old_prev = prev;
            prev = lastDigit;
        }

        return lastDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}