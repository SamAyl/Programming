package LeetCode;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        int[] a = {186,419,83,408};
       int ans = coinChange(a,6249);
        System.out.println(ans);
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return getCoinsCount(coins,amount);
    }

    public static int getCoinsCount(int[] coins,int amount) {
        if(amount == 0){
            return 0;
        } else if (amount < 0) {
            return -1;
        }


        int coinCount = 1;
        int tempCount = -1;
        for(int i = coins.length-1;i>=0;i--){
           // System.out.println(coins[i] + " =====" + amount);
            tempCount = getCoinsCount(coins,amount - coins[i]);
            if(tempCount !=-1){
                break;
            }

        }
        return tempCount == -1 ? tempCount : (coinCount+tempCount);
    }

}
