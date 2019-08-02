package CourseraDSAlgos.module1.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairWiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        if(numbers.length==2){
            return (long)numbers[0]* (long)numbers[1];
        }


        int max1 =0;
        int max2=0;


        boolean zeroPresent = false;

        for(int i = 0;i<numbers.length;i++){

            if(numbers[i]==0){
                zeroPresent = true;
                continue;
            }

            if(max1==0 && numbers[i]!=0){
                max1 = numbers[i];
                continue;
            }

            if(max2==0 && numbers[i]!=0){
                max2 = numbers[i];
                continue;
            }


            long prod = (long)max1 * (long)max2;
            long prod1 = (long)max1 * (long)numbers[i];
            long prod2 = (long)max2 * (long)numbers[i];

            if(prod < prod1 || prod < prod2){
                if(prod1< prod2){
                    max1 = numbers[i];
                }else {
                    max2 = numbers[i];
                }
            }

        }


       long ans = (long)max1 * (long)max2;

        if(zeroPresent){
          return   ans<0?0:ans;
        }else {
            return ans;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
