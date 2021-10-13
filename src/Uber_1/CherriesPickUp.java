package Uber_1;

public class CherriesPickUp {

    public static void main(String[] args) {
        int[][] cherry = {{1,1,-1},{1,-1,1},{-1,1,1}};
     //   int ans = getMaxCherry(cherry,0,0);
     //   System.out.println(ans);
    }

    public static void getMaxCherry(int[][] cherry, int row, int col, int[] c) {


         if (cherry[row][col] == 1) {
             c[0]+=1;
             cherry[row][col] = 0;
         }








    }
}
