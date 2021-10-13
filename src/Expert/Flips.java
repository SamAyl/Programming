package Expert;

import java.util.*;

public class Flips {

    public static void main(String[] args) {
        int[][] matrix = {{0,0},{0,1}};
        int initialHash = Arrays.deepHashCode(matrix);


        int ans = getMinMoves(matrix,initialHash,new HashSet<Point>());
        System.out.println(ans);
    }


    public static int getMinMoves(int[][] matrix, int initialHash, Set<Point> visited) {


        int minMoves = Integer.MAX_VALUE;
        for (int i = 0; i<matrix.length;i++) {
            for(int j = 0; j<matrix[0].length;j++) {
                Point temp = new Point(i,j);
                if (visited.contains(temp)) {
                    continue;
                }

                visited.add(temp);

                int currMoves = Integer.MAX_VALUE;
                int currX = i;
                int currY = j;

                flip(currX,currY,matrix);

                int currHash = Arrays.deepHashCode(matrix);
                if (currHash == initialHash) {
                    continue;
                } else {
                     if(checkForAllZero(matrix)) {
                         currMoves = 1;
                         minMoves = Math.min(currMoves,minMoves);
                     } else {
                         int tempMoves = getMinMoves(matrix,initialHash,visited);
                         if (tempMoves != Integer.MAX_VALUE) {
                             currMoves = 1 + getMinMoves(matrix,initialHash,visited);
                             minMoves = Math.min(currMoves,minMoves);
                         }

                     }
                }

                flip(currX,currY,matrix);
                visited.remove(temp);

            }
        }

        return minMoves;
    }

    public static void flip(int x, int y, int[][] mat) {


        mat[x][y] = mat[x][y] == 0 ? 1 : 0;
        if (x+1 < mat.length) {
            mat[x+1][y] = mat[x+1][y] == 0 ? 1 : 0;
        }

        if (x-1 >= 0) {
            mat[x-1][y] = mat[x-1][y] == 0 ? 1 : 0;
        }

        if (y+1 < mat[0].length) {
            mat[x][y+1] = mat[x][y+1] == 0 ? 1 : 0;
        }

        if (y-1 >= 0) {
            mat[x][y-1] = mat[x][y-1] == 0 ? 1 : 0;
        }
    }


    public static boolean checkForAllZero(int[][] matrix) {

        for(int i = 0; i< matrix.length; i++) {
            for (int j = 0; j< matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}

class Point{

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object o) {
        Point p = (Point)o;
        return p.x == this.x && p.y == this.y;
    }

}
