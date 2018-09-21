package KickStart;

public class MinCoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,3,4,6,9};
        int sum = 13;

        String minCoinsSum = getMinSum(coins,sum);
        System.out.println(minCoinsSum);
    }

    public static String getMinSum(int[] coins,int sum){
        return  getMinSum(coins,0,sum,coins.length-1,new StringBuilder());
    }

    public static String getMinSum(int[] coins,int tempSum,int sum,int index,StringBuilder sb){
        if(tempSum == sum){
            return sb.toString();
        }

        if(tempSum > sum){
            return null;
        }


          int  nearestIndex = getNearestIndex(coins,sum-tempSum,index);
          if(nearestIndex==-1){
              return null;
          }

          String temp = new String();
          while (temp!=null && nearestIndex>=0) {
              sb.append(nearestIndex);
              temp = getMinSum(coins, tempSum + coins[nearestIndex], sum, nearestIndex-1, sb);
               if(temp!=null){

                   return sb.toString();
               }else {
                   nearestIndex--;
                   temp = new String();
               }

          }


        return null;
    }



    public static  int getNearestIndex(int[] coins,int sum,int startIndex){
        int index = -1;

        while (startIndex>=0){
            if(coins[startIndex]>sum){
                startIndex--;
            }else {
                index =startIndex;
                return index;
            }
        }

        return index;
    }
}
