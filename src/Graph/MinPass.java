package Graph;

import java.util.*;

public class MinPass {

    public static void main(String[] args) {
        int[][] mat = {{0,-1,-3,2,0},
                {1,-2,-5,-1,-3},
                {3,0,0,-4,-1}};

        Set<Point> visited = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        for(int row = 0 ; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length ; col++) {
                if (mat[row][col] > 0) {
                    queue.add(new Point(row,col));
                    visited.add(new Point(row,col));
                }
            }
        }

        int pass = 0;
        boolean singlePass = false;

        while (!queue.isEmpty()) {


            if (singlePass) {
                pass++;
                singlePass = false;
            }

            int size = queue.size();

            while (size>0) {
                Point temp = queue.remove();
                if (temp.row + 1 < mat.length &&  !visited.contains(new Point(temp.row+1,temp.col))
                 && mat[temp.row+1][temp.col] < 0) {
                     mat[temp.row+1][temp.col] = mat[temp.row+1][temp.col] * -1;

                     Point pt = new Point(temp.row+1,temp.col);
                     queue.add(pt);
                     visited.add(pt);

                     singlePass = true;
                }

                if (temp.row-1 >= 0 && !visited.contains(new Point(temp.row-1,temp.col)) && mat[temp.row-1][temp.col] < 0) {
                    mat[temp.row-1][temp.col] = mat[temp.row-1][temp.col] * -1;

                    Point pt = new Point(temp.row-1, temp.col);
                    queue.add(pt);
                    visited.add(pt);

                    singlePass = true;
                }

                if (temp.col + 1 < mat[0].length && !visited.contains(new Point(temp.row,temp.col+1)) && mat[temp.row][temp.col+1] < 0) {

                    mat[temp.row][temp.col+1] = mat[temp.row][temp.col+1] * -1;
                    Point pt = new Point(temp.row, temp.col+1);
                    queue.add(pt);
                    visited.add(pt);

                    singlePass = true;
                }

                if (temp.col-1 >=0 && !visited.contains(new Point(temp.row,temp.col-1)) && mat[temp.row][temp.col-1] < 0) {

                    mat[temp.row][temp.col-1] = mat[temp.row][temp.col-1] * -1;
                    Point pt = new Point(temp.row, temp.col-1);
                    queue.add(pt);
                    visited.add(pt);

                    singlePass = true;
                }


                size--;
            }

            print(mat);

        }

        System.out.println(pass);
    }


    public static void print(int[][] mat) {

        System.out.println("============================");

        for (int i = 0; i< mat.length ; i++) {
            for (int j = 0; j< mat[0].length; j++) {
                System.out.print(mat[i][j]);
                System.out.print("\t");
            }

            System.out.println();
        }

        System.out.println("===========================");
    }
}

class Point {

    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public boolean equals(Object o) {
        Point p1 = (Point)o;
        return this.row == p1.row && this.col == p1.col;
    }
}
