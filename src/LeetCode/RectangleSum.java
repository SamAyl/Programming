package LeetCode;

public class RectangleSum {

    public static void main(String[] args) {
        RectangleSum rs = new RectangleSum();
        char[][] mat = {{'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}};

        System.out.println(rs.maximalRectangle(mat));
    }
        public int maximalRectangle(char[][] matrix) {
            int[][] suffixSum = new int[matrix.length][matrix[0].length];

            int prevSum = 0;
            for(int i = matrix.length - 1;i>=0;i--){
                for(int j = matrix[0].length-1;j>=0;j--){
                    int tempSum = matrix[i][j]=='1' ? 1:0;
                    if(tempSum!=0) {
                        suffixSum[i][j] = prevSum + tempSum;
                        prevSum = suffixSum[i][j];
                    } else {
                        prevSum = 0;
                    }
                }

                prevSum = 0;
            }


            int maxArea = 0;

            for(int i = suffixSum.length-1;i>=0;i--) {
                for(int j = suffixSum[0].length-1;j>=0;j--) {
                    int tempArea = 0;
                    if(i==1 && j ==2) {
                        System.out.println("am here");
                    }
                    if(suffixSum[i][j] != 0) {
                        tempArea = getArea(suffixSum,i,j);
                        if(tempArea > maxArea){
                           maxArea = tempArea;
                        }
                    }
                }
            }


            return maxArea;
        }


        public int getArea(int[][] mat, int i, int j) {

            int minlength = mat[i][j];
            int maxArea = mat[i][j];

            int count = i;
            i++;
            while(i<mat.length){
                if(mat[i][j] !=0) {
                    minlength = Math.min(mat[i][j],minlength);
                    int tempMaxArea = ((i-count) +1) * minlength;
                    maxArea = Math.max(tempMaxArea,maxArea);
                    i++;
                } else {
                    break;
                }
            }


            return maxArea;
        }
    }

