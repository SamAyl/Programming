package Educative;

public class MatrixDiagonal {

    public static void main(String[] args) {
        int[][] mat=  {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printDiagonal(mat);
    }


    private static void printDiagonal(int[][] mat) {
        int row = mat.length;

        int column = 0;

        for (int i = 0; i < row; i++) {
                print(mat, i, column);
        }

        for (int i = column + 1; i < mat[0].length; i++) {
            print(mat,mat.length-1,i);
        }
    }

    private static void print(int[][] mat,int x,int y) {

        int temp_x = x;
        int temp_y = y;

        while(temp_x>=0 && temp_y<mat[0].length){
            System.out.print(mat[temp_x][temp_y]);
            System.out.print("\t");
            temp_x--;
            temp_y++;
        }
        System.out.println();
    }
}




