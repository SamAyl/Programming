package MCA2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatrixMul {

   private static   Map<Integer, Map<MatrixNode,Integer>> memory  = new HashMap<>();

    public static void main(String[] args) {
        int[][] matSizes = {{10,30},{30,5},{5,60}};

        System.out.println(findLeastCal(matSizes));
    }

    private static int findLeastCal(int[][] matSizes){
        return findLeastCal(matSizes,0);
    }

    private static int findLeastCal(int[][] matrixSizes, int currentMatrix) {
        if(currentMatrix == matrixSizes.length || currentMatrix+1 ==matrixSizes.length){
            return 0;
        }

       // if()


        int minOperations = matrixSizes[currentMatrix][0] * matrixSizes[currentMatrix][1] * matrixSizes[currentMatrix+1][1];
        matrixSizes[currentMatrix+1][0] = matrixSizes[currentMatrix][0];
        int result = findLeastCal(matrixSizes,currentMatrix+1);
        minOperations+= result;

        matrixSizes[currentMatrix+1][0] = matrixSizes[currentMatrix][1];
        int minOperations1 = findLeastCal(matrixSizes,currentMatrix+1);
        minOperations1+= matrixSizes[currentMatrix][0] * matrixSizes[currentMatrix][1] * matrixSizes[currentMatrix+1][1];

        return minOperations>minOperations1?minOperations1:minOperations;
    }

    private static int result(int r,int c,int index) {

        if(memory.containsKey(index)){
            if(memory.get(index).containsKey(new MatrixNode(r,c))) {
                return memory.get(index).get(new MatrixNode(r,c));
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}

class MatrixNode {
    int r;
    int c;

    public MatrixNode(int r,int c){
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixNode that = (MatrixNode) o;
        return r == that.r &&
                c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}
