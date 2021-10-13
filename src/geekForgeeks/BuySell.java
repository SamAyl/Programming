package geekForgeeks;

public class BuySell {

    public static void main(String[] args) {
        int[] s = {2,1,4};
        System.out.println(buySell(s));
    }


    public static int buySell(int[] prices){


        int count = 0;
        int price1 = prices[count];
        int price2 = price1;
        int profit = 0;
        while (count<prices.length){
            if(prices[count] > price2){
                price2 =  prices[count];
                if(profit < (price2 - price1)) {
                  profit = price2 - price1;
                }
            } else if(prices[count] < price1){
                price1 = prices[count];
                price2 = price1;
            }

            count++;
        }

        return profit;
    }
}
