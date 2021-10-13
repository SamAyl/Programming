package AlgoExpert;


public class MaxProfit_K_Transactions {

    public static void main(String[] args) {
      int[] prices = {5, 11, 3, 50, 60, 90};
      int k = 2;

        System.out.println(maxProfitWithKTransactions(prices,2));
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int[] a = prices;
        int[][] totProfit = new int[k+1][a.length];



        for(int transaction = 1;transaction<=k;transaction ++) {
            for(int day = 1;day<a.length;day++) {
                int profit1 = 0;
                int profit2 = 0;


                profit1 = totProfit[transaction][day-1];
                profit2 = a[day] + getPreviousMaxTransaction(a,transaction-1,day-1,totProfit);

                totProfit[transaction][day] = Math.max(profit1,profit2);
            }
        }

        int maxProfit = 0;
        for (int i = 0; i<a.length; i++) {
            maxProfit = Math.max(maxProfit,totProfit[k][i]);
        }
        return maxProfit;
    }

    public static int getPreviousMaxTransaction(int[] a, int transaction, int prevDay,int[][] totProfit) {
        int val = Integer.MIN_VALUE;


        while (prevDay>=0) {

            int temp = (-1 * a[prevDay]);
            int tempProfit = prevDay-1>0 ? totProfit[transaction][prevDay-1] : 0;

            val = Math.max(val,temp+tempProfit);
            prevDay--;

        }
        return val;
    }
}

