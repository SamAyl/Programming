package LeetCode;


import  java.util.*;

public class Islands {


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1  = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        list1.add(1);
        list1.add(1);
        list1.add(0);

        list2.add(0);
        list2.add(0);
        list2.add(1);

        list3.add(1);
        list3.add(0);
        list3.add(1);

        list.add(list1);
        list.add(list2);
        list.add(list3);

        System.out.println(findIslands(list,3,3));
     }


        // Function to find the number of island in the given list A
        // N, M: size of list row and column respectively
        static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {

            int[][] mat = new int[N][M];

            int count = 0;

            for(int i = 0;i<N;i++) {
                for(int j = 0;j<M;j++){
                    mat[i][j] = A.get(i).get(j);
                }
            }



            for(int k = 0; k < N;k++) {
                for(int m = 0;m<M;m++){
                    if(mat[k][m] == 1){
                        findAllConnectedComp(mat, k,m);
                        count++;
                    }
                }
            }


            return count;
        }


        public static int findAllConnectedComp(int[][] mat, int k, int m) {
            Queue<int[]> queue = new LinkedList<int[]>();
            int[] node = new int[2];
            node[0] = k;
            node[1] = m;
            queue.add(node);
            mat[k][m] = -1;

            while(!queue.isEmpty()) {
                int[] tempNode = queue.poll();
                int row = tempNode[0];
                int col = tempNode[1];

                if(row-1 >=0 && mat[row-1][col]==1){
                    add(row-1,col,queue,mat);
                }

                if (row + 1 < mat.length && mat[row+1][col] == 1) {
                    add(row+1,col,queue,mat);
                }

                if(col -1 >= 0 && mat[row][col-1]==1) {
                    add(row,col-1,queue,mat);
                }

                if(col+1 < mat[0].length && mat[row][col+1]==1){
                    add(row,col+1,queue,mat);
                }

                if(row-1 >=0 && col-1>=0 && mat[row-1][col-1]==1){
                    add(row-1,col-1,queue,mat);
                }

                if(row-1 >=0 && col+1 < mat[0].length && mat[row-1][col+1]==1){
                    add(row-1,col+1,queue,mat);
                }

                if(row+1 < mat.length && col-1>=0 &&  mat[row+1][col-1]==1){
                    add(row+1,col-1,queue,mat);
                }

                if(row+1 < mat.length && col+1 < mat[0].length && mat[row+1][col+1]==1){
                    add(row+1,col+1,queue,mat);
                }
            }

            return 1;
        }


        public static void add(int x,int y, Queue<int[]> queue, int[][] mat){
            int[] temp = new int[2];
            temp[0] = x;
            temp[1] = y;

            queue.add(temp);
            mat[x][y] = -1;
            return;
        }
    }

