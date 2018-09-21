package KickStart;

import  java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,3,4};
        int sum = 5;
        Set<String> totComb = getComb(coins,sum);
        System.out.println(totComb);
    }

    public static Set<String> getComb(int[] coins,int sum){

        StringBuilder sb = new StringBuilder();
        Set<String> coinSet = new HashSet<>();
        int tempSum = 0;
        getComb(coins,tempSum,sum,0,sb,coinSet);
        return coinSet;
    }

    public static void getComb(int[] coins,int tempSum,int sum,int index,StringBuilder sb,Set<String> coinset){
        if(tempSum == sum ){
            coinset.add(sb.toString());
            return;
        }

        if(tempSum>sum){
            return;
        }

        for(int i = index;i<coins.length;i++){
            tempSum+=coins[i];
            sb.append(coins[i]);
            getComb(coins,tempSum,sum,i,sb,coinset);
            sb.deleteCharAt(sb.length()-1);
            tempSum-=coins[i];

        }
    }


}
