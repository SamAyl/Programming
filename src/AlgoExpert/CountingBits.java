package AlgoExpert;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits bits = new CountingBits();
        bits.countBits(2);
    }

    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        fillOne(ans,0,0,num);
        return ans;
    }

    int filledOnes = 0;

    public void fillOne(int[] ans, int prevSum, int idx,int num) {
         if (filledOnes == num) {
             return;
         }

        int tempSum1 = prevSum + (int)Math.pow(2,idx) * 0;
        int tempSum2 = prevSum + (int)Math.pow(2,idx)*1;

        if(tempSum2 <= num) {
            ans[tempSum2] = ans[prevSum]+1;
            filledOnes++;
            fillOne(ans,tempSum2,idx+1,num);
        }

        if(tempSum1 <= num ) {
            fillOne(ans,tempSum1,idx+1,num);
        }

        return;

    }
}
