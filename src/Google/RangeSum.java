package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RangeSum {

      int[][] matrix ={
             {3, 0, 1, 4, 2},
             {5, 6, 3, 2, 1},
             {1, 2, 0, 1, 5},
             {4, 1, 0, 1, 7},
             {1, 0, 3, 0, 5}
     };

      Map<Node,Integer> memory = new HashMap<>();
    public static void main(String[] args) {

        RangeSum rs = new RangeSum();
        System.out.println(rs.getSum(1,1,2,2));

    }
        public int getSum(int row1, int col1, int row2, int col2){

            if(row1 == row2 && col1 == col2){
                return matrix[row1][col1];
            }

            int ans = matrix[row1][col1];

            if(row1 == row2){
                Node node = new Node(row1,col1+1,row2,col2);
                if(memory.containsKey(node)){
                    ans+=memory.get(node);
                } else {
                    int val =  getSum(row1, col1 + 1, row2, col2);
                    memory.put(node,val);
                    ans+=val;
                }
            } else if(col1 == col2) {
                Node node = new Node(row1+1,col1,row2,col2);
                if(memory.containsKey(node)){
                    ans+=memory.get(node);
                }else {
                    int val = getSum(row1+1,col1,row2,col2);
                    memory.put(node,val);
                    ans+=val;
                }

            } else {
                Node node1 = new Node(row1,col1+1,row1,col2);
                Node node2 = new Node(row1+1,col1,row2,col1);
                Node node3 = new Node(row1+1,col1+1,row2,col2);

                if (memory.containsKey(node1)){
                    ans+=memory.get(node1);
                } else {
                    int v1 = getSum(row1,col1+1,row1,col2);
                    memory.put(node1,v1);
                    ans+=v1;
                }

                if (memory.containsKey(node2)){
                    ans+=memory.get(node2);
                } else {
                    int v1 = getSum(row1+1,col1,row2,col1);
                    memory.put(node2,v1);
                    ans+=v1;
                }

                if (memory.containsKey(node3)){
                    ans+=memory.get(node3);
                } else {
                    int v1 = getSum(row1+1,col1+1,row2,col2);
                    memory.put(node3,v1);
                    ans+=v1;
                }

            }

            memory.put(new Node(row1,col1,row2,col2),ans);
            return ans;


        }


    class Node {
        int row1,col1,row2,col2;

        public Node(int row1,int col1,int row2,int col2) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row1 == node.row1 &&
                    col1 == node.col1 &&
                    row2 == node.row2 &&
                    col2 == node.col2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row1, col1, row2, col2);
        }
    }

}
