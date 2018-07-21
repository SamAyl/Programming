package KeyPad;

import Lambdas.Functional.Int;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int[][] num = {{1,1,1},{1,0,1},{1,1,1}};
          setMatrix(num);
        System.out.println(num);

    }

    public static void setMatrix(int[][] num){


        Map<Integer,Integer> indices = new HashMap<>();
        for(int i = 0;i<num.length;i++){
            for(int j =0;j<num[0].length;j++){
                if(num[i][j] == 0){
                    indices.put(i,j);

                }
            }
        }




            for(Map.Entry<Integer,Integer> entry : indices.entrySet()){
               set(num,entry.getKey(),entry.getValue());
            }

        }



    public static void set(int[][] num,int i,int j){
        for(int col = 0;col<num[0].length;col++){
            if(num[i][col]!=Integer.MAX_VALUE) {
                num[i][col] = 0;
            }
        }

        for(int row = 0;row<num.length;row++){
            if(num[row][j]!=Integer.MAX_VALUE){
                num[row][j] = 0;
            }
        }
    }

}
