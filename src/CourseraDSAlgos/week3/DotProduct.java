package CourseraDSAlgos.week3;

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {

        //1,,3   => -4 -1 9

        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 0L;


        int i = a.length-1;
        int j = b.length-1;

        int zeroCount = 0;

        while (i>=0 && j>=0){

           ans+=(long)a[i]*(long)b[j];
           i--;
           j--;
        }


         i=-1;
        while (i<0){
            new Object();
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

