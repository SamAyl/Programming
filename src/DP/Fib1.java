package DP;

import java.util.*;

public class Fib1 {

   public static Map<Integer,Integer> fibCache = new HashMap<>();
   public static Map<Integer,Integer> fibCache1 = new TreeMap<>();
    /*Regular fib program without caching*/
    public  static int getFib(int num){
        if(num ==0){
            return 0;
        }
        if(num == 1){
            return 1;
        }

        return getFib(num-1) + getFib(num-2);
    }


    /*Program with caching*/
    public static int Fib(int num){

        if(fibCache.containsKey(num)){
            return fibCache.get(num);
        }else {

            if (num == 0) {
                if (fibCache.containsKey(0)) {
                    return fibCache.get(0);
                } else {
                    fibCache.put(0, 0);
                    return 0;
                }
            }

            if (num == 1) {
                if (fibCache.containsKey(1)) {
                    return fibCache.get(1);
                } else {
                    fibCache.put(1, 1);
                    return 1;
                }
            }

            int sum = Fib(num - 1) + Fib(num - 2);
            fibCache.put(num, sum);
            return sum;

        }
    }

    public static int fibLin(int num){
        if(fibCache1.containsKey(num)){
            return fibCache1.get(num);
        }else{

            int size = fibCache1.size();
            if(size ==0){
               fibCache1.put(0,0);
               fibCache1.put(1,1);

               for(int i  = 2;i<=num;i++){
                   int sum   = fibCache1.get(i-1)+fibCache1.get(i-2);
                   fibCache1.put(i,sum);
               }
            }else {

                for(int i = size-1;i<num;i++){
                    int sum   = fibCache1.get(i-1)+fibCache1.get(i-2);
                    fibCache1.put(i,sum);
                }
            }

            return fibCache1.get(num);

        }
    }
    public static void main(String[] args){

        System.out.println(Fib(10));
        System.out.println(getFib(10));
        System.out.println(fibLin(10));
    }
}
