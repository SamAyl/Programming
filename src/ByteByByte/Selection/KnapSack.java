package ByteByByte.Selection;

public class KnapSack {

    public static void main(String[] args) {
        int[] weights = {1,2,3,0,1,4};


        knapsack(weights,0,0,0,5);
        System.out.println(maxValue);
    }

    private static int maxValue = 0;

    public static void knapsack(int[] weights, int valueIdx, int totVal, int rollingWeight, int maxWeight) {
        if (valueIdx == weights.length) {
            return;
        }



        rollingWeight += weights[valueIdx];
        totVal+=valueIdx;
        if (rollingWeight == maxWeight) {
            maxValue = Math.max(maxValue,totVal);
        } else if (rollingWeight < maxWeight) {
            knapsack(weights,valueIdx+1,totVal,rollingWeight,maxWeight);
        }

        rollingWeight -=weights[valueIdx];
        totVal -=valueIdx;

        knapsack(weights,valueIdx+1,totVal,rollingWeight,maxWeight);


    }
}
