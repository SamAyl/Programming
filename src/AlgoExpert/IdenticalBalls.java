package AlgoExpert;

public class IdenticalBalls {

    public static void main(String[] args) {
       int count = getCount(5,4);
        System.out.println(count);
    }


    public static int getCount(int balls, int buckets) {

        if (balls == 0) {
            return 0;
        } else if (buckets == 0) {
            return 0;
        } else if (buckets == 1){
            return 1;
        }




        int minBalls = 1;
        int totCount = 0;
        while(minBalls <=balls) {
            totCount+=(getCount(balls - minBalls, buckets - 1));
            minBalls++;
        }

        return totCount;

    }
}
