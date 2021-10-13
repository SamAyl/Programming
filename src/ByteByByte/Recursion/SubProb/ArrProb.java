package ByteByByte.Recursion.SubProb;

public class ArrProb {

    public static void main(String[] args) {
        int[][] arr = {{0,1,0,0},{1,1,1,1},{0,1,1,0}};

        int[][] lenArr = new int[3][4];
        int[][] brdArr = new int[3][4];

        int count = 0;
        for (int i = 0; i< arr.length;i++) {
            for(int  j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    lenArr[i][j] = count+1;
                    count++;
                } else {
                    count = 0;                }
            }
        }

        count = 0;
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] ==  1) {
                    brdArr[j][i] = count+1;
                    count++;
                } else {
                    count = 0;
                }
            }
        }

        int maxSize = Integer.MIN_VALUE;

        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j< arr[0].length; j++) {
                     maxSize = Math.max(maxSize,Math.min(lenArr[i][j],brdArr[i][j]));
            }
        }

        System.out.println(maxSize);
    }
}
