package AlgoExpert;

public class WaterFall {

    public static void main(String[] args) {
        double[][] maze = {{0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},{1, 1, 1, 0, 0, 1, 0},{1, 1, 1, 0, 0, 1, 0},{0, 0, 0, 0, 0, 0, 1},{0, 0, 0, 0, 0, 0, 0}};
        int col =   3;

        fillWater(maze,0,3,100);

        double a = maze[maze.length-1][0];
    }


    public static void fillWater(double[][] maze, int row, int col, double water) {
        if (row == maze.length -1) {
            maze[row][col]+=water;
            return;
        }


       if (maze[row+1][col] != 1) {
           fillWater(maze,row+1,col,water);
       } else {

           int colLeft = findNextColLeft(maze,row,col);
           int colRight = findNextColRight(maze,row,col);

           if (colLeft>=0){
               fillWater(maze,row+1,colLeft,water/2.0);
           }

           if (colRight <= maze[0].length-1) {
               fillWater(maze,row+1,colRight,water/2.0);
           }
       }

    }


    public static int findNextColLeft(double[][] maze, int row, int col) {
        col--;
        while (col >=0 ){
            if (maze[row][col] == 1) {
                return -1;
            }


            if (maze[row+1][col] ==0) {
                return col;
            }

            col--;
        }


        return  col;
    }

    public static int findNextColRight(double[][] maze, int row, int col) {
        col++;
        while (col<maze[0].length) {
            if (maze[row][col] == 1) {
                return maze[0].length;
            }
            if (maze[row+1][col] == 0) {
                return col;
            }
            col++;
        }

        return col;
    }
}
