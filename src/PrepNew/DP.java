package PrepNew;

public class DP {

    public static void main(String[] args) {
        int[] a = {1, -1, 1, -1, -2};

        DP p = new DP();
        p.maximizeExpression(a);
    }

    public int maximizeExpression(int[] array) {
        if (array.length < 4) {
            return 0;
        }

        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        getHighestSum(array,0,0,sum,0);
        return sum[0];
    }



    public void getHighestSum(int[] arr, int idx, int pos, int[] sum, int tempSum) {
        if (pos==4) {
            if (sum[0] < tempSum) {
                sum[0] = tempSum;
            }
            return;
        }

        for(int i = idx; i< arr.length; i++) {
            int val = 0;
            if (pos%2 == 0) {
                val = arr[idx];
            }	 else {
                val = -1 *arr[idx];
            }
            tempSum +=val;
            getHighestSum(arr,idx+1,pos+1,sum,tempSum);
            tempSum -=val;
        }


    }
}




