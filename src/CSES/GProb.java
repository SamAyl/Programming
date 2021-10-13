package CSES;

public class GProb {

    public static void main(String[] args) {
        GProb sol = new GProb();
        int[][] ans = {{1,1},{1,1}};
        int k = sol.maximumSumSubmatrix(ans,2);
        System.out.println(k);
    }


        public int maximumSumSubmatrix(int[][] matrix, int size) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }


            int[][] sum = new int[matrix.length][matrix[0].length - size + 1];

            for (int i = 0; i< matrix.length; i++) {
                int[] arr = matrix[i];

                int str = 0;
                int end = str + size -1;
                int sumCol = 0;
                int tempSum = getSum(str,end,arr);
                sum[str][sumCol] = tempSum;
                str++;
                end++;

                while (end < matrix[0].length) {
                    tempSum-=arr[str-1];
                    tempSum+=arr[end];
                    sum[str][sumCol] = tempSum;
                    str++;
                    end++;
                    sumCol++;
                }

            }

            //rowWise Traversal
            int maxSum = Integer.MIN_VALUE;

            for (int j = 0; j<sum[0].length;j++) {
                int rowStr = 0;
                int rowEnd = rowStr+size-1;

                int rowTempSum = getRowSum(rowStr,rowEnd,j,sum);
                maxSum = Math.max(maxSum,rowTempSum);
                rowStr++;
                rowEnd++;
                while (rowEnd < sum.length) {
                    rowTempSum -= sum[rowStr-1][j];
                    rowTempSum+=sum[rowEnd][j];

                    maxSum = Math.max(rowTempSum,maxSum);
                    rowStr++;
                    rowEnd++;
                }
            }

            return maxSum;
        }


        public int getSum(int str, int end, int[] arr) {
            int count = 0;

            while(str<=end) {
                count+= arr[str];
                str++;
            }

            return count;
        }


        public int getRowSum(int str, int end, int col, int[][] mat){

            int count = 0;

            while (str<=end){
                count+=mat[str][col];
                str++;
            }

            return count;
        }

}
