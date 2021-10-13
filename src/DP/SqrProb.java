package DP;

import java.util.*;

public class SqrProb {

    public static void main(String[] args) {
            List<Integer> list1 = Arrays.asList(0, 1);
            List<Integer> list2 = Arrays.asList(0, 0);
         //   List<Integer> list3 = Arrays.asList(0, 1, 0);
       //     List<Integer> list4 = Arrays.asList(1, 1, 1, 1);


            List<List<Integer>> matrix = new ArrayList<>();
            matrix.add(list1);
            matrix.add(list2);
           // matrix.add(list3);
           // matrix.add(list4);

            System.out.println(squareOfZeroes(matrix));
    }

    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        int[][] rowMatrix = new int[matrix.size()][matrix.get(0).size()];
        makeRowMatrix(matrix,rowMatrix);

        for (int row = 0; row < rowMatrix.length ; row++) {
            for (int col = 0; col < rowMatrix[0].length;col++) {
                if (rowMatrix[row][col] != 0) {
                    int sqrLength = rowMatrix[row][col];
                    if(rowMatrix[row + sqrLength][col] == sqrLength) {

                        int pos1 = col;
                        int pos2 = pos1 + sqrLength;


                        int currRow = row;
                        if(currRow+1 == rowMatrix.length) {
                            continue;
                        }

                        while(currRow <= row + sqrLength) {
                            if(matrix.get(currRow).get(pos1) == 0 && matrix.get(currRow).get(pos2) == 0) {
                                currRow++;
                            }
                        }

                        if (currRow == row+sqrLength+1) {
                            return true;
                        }


                    }
                }
            }
        }



        return false;
    }


    public static void makeRowMatrix(List<List<Integer>> matrix, int[][] rowMatrix) {

        int rowCount = 0;
        int rowPointer = rowMatrix[0].length-1;



        for (List<Integer> singleList : matrix) {

            while (rowPointer >= 0) {
                if (rowPointer != singleList.size()-1) {
                    if (singleList.get(rowPointer) == 0 && singleList.get(rowPointer+1) == 0) {
                        rowMatrix[rowCount][rowPointer] = 1+rowMatrix[rowCount][rowPointer+1];
                    } else {
                        rowMatrix[rowCount][rowPointer] = 0;
                    }
                } else {
                    rowMatrix[rowCount][rowPointer] = 0;
                }

                rowPointer--;
            }
            rowCount++;
            rowPointer = rowMatrix[0].length-1;
        }

        return;

    }



}
