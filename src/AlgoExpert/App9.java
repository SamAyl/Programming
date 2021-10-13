package AlgoExpert;

import java.util.*;

public class App9 {

    public static void main(String[] args) {
           App9 app = new App9();
           int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
           int ans =  app.countSquares(matrix);
        System.out.println(ans);
    }

    public int countSquares(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }


        Map<Integer,Integer> map = new HashMap<>();

        int[][] oneCount = new int[matrix.length][matrix[0].length];

        int prevSum = 0;
        int count = 0;
        for (int i = 0; i< matrix.length; i++) {
            prevSum = 0;
            for (int j = matrix[0].length-1; j>=0; j--) {
                if (matrix[i][j] ==  1) {
                    count++;
                    oneCount[i][j] = matrix[i][j] + prevSum;
                    prevSum = oneCount[i][j];
                } else {
                    prevSum = 0;
                }
            }
        }

        map.put(1,count);

        for (int m = 0; m < oneCount.length; m++) {
            for (int col = 0; col < oneCount[0].length; col++) {
                if (oneCount[m][col] != 0) {
                    getAllSquare(m,col,oneCount,map);
                }
            }
        }

        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans+=entry.getValue();
        }

        return ans;
    }


    public void getAllSquare(int row, int col, int[][] matrix, Map<Integer,Integer> map) {
        row++;
        int count = 2;
        int minLength = matrix[row-1][col];
        while(row < matrix.length) {
             minLength = Math.min(minLength, matrix[row][col]);
            if (minLength>=count) {
                if (map.containsKey(count)) {
                    int sqrCount = map.get(count);
                    sqrCount++;
                    map.put(count,sqrCount);
                } else {
                    map.put(count,1);
                }
                count++;
                row++;
            }else {
                break;
            }
        }
    }
}
