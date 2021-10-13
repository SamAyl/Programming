package CSES;

public class DP1 {

    public static void main(String[] args) {

        int[][] matrix = new int[2][2];
        int[] a = {0,1};
        int[] b = {0,0};
        int[] c = {0, 1, 1, 1, 0, 1};
        int[] d = {0, 0, 0, 1, 1, 1};
        int[] e = {0, 1, 1, 1, 0, 1};
        int[] f = {0, 0, 0, 0, 0, 1};
        matrix[0] = a;
        matrix[1] = b;
//        matrix[2] = c;
//        matrix[3] = d;
//        matrix[4] = e;
//        matrix[5] = f;


        boolean ans = checkSquare(matrix);
        System.out.println(ans);
    }

    public static boolean checkSquare(int[][] matrix) {
        int[][] rowSum = new int[matrix.length][matrix[0].length];
        int[][] colSum = new int[matrix.length][matrix[0].length];

        for (int col = matrix[0].length-1; col>=0; col--) {
            for(int row = matrix.length-1; row>=0;row--) {

                if (matrix[row][col] == 0) {
                    colSum[row][col] = 1;
                    if (row + 1 < matrix.length) {
                        colSum[row][col] = colSum[row + 1][col];
                    }
                }
            }
        }

        for (int r = 0; r<matrix.length;r++) {
            for (int c = matrix[0].length-1; c>=0; c--) {

                   if (matrix[r][c]  == 0) {
                       rowSum[r][c] = 1;
                       if (c+1<matrix[0].length) {
                           rowSum[r][c] += rowSum[r][c+1];
                       }
                   }
            }
        }


        for (int i  = 0; i<matrix.length;i++) {
            for(int j = 0; j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    if (rowSum[i][j] != 0 && colSum[i][j] != 0) {
                        int rowZeros = rowSum[i][j];
                        int colZeros = colSum[i][j];

                        int jumpValue = Math.min(rowZeros,colZeros);

                        System.out.println( rowSum[i+jumpValue-1][j]);
                        System.out.println(colSum[i][j+jumpValue-1]);
                        if (Math.min(rowSum[i+jumpValue-1][j], colSum[i][j+jumpValue-1]) == jumpValue){
                            return true;
                        }
                    }
                }
            }
        }


        invertR(rowSum,colSum, matrix);
        //invertC(colSum, matrix);

        for (int k = matrix.length-1; k>=0;k--) {
            for (int l = matrix[0].length-1 ; l>=0; l--) {
                if (matrix[k][l] == 0) {
                    int jumpValue1 = Math.min(rowSum[k][l],colSum[k][l]);

                    if (Math.min(rowSum[k-jumpValue1-1][l], colSum[k][k-jumpValue1-1]) == jumpValue1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static void invertR(int[][] rowSum,int[][] colSum,int[][] matrix) {


        for (int i = 0; i<matrix.length;i++) {
            for (int j = 0; j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    rowSum[i][j] = 1;
                    if (i-1>=0) {
                        rowSum[i][j]+=rowSum[i-1][j];
                    }
                }
            }
        }


        for (int k = matrix[0].length-1; k>= 0; k--) {
            for(int l = 0; l<matrix.length;l++) {
                if (matrix[k][l] == 0){
                    colSum[k][l] = 1;

                    if (k-1>=0) {
                        colSum[k][l]+=colSum[k-1][l];
                    }
                }
            }
        }

        return;

    }

}
