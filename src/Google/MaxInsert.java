package Google;

import java.util.HashMap;
import java.util.Map;

public class MaxInsert {

    public static void main(String[] args) {
       MaxInsert m = new MaxInsert();
       int[] num = {1,1,2,3,4};
        System.out.println(m.checkValidState(num));


    }

   public boolean checkValidState(int[] num){


       Map<Integer,Integer[]> map = new HashMap<>();

       for(int  i = 0;i<num.length;i++){
           if(map.containsKey(num[i])){
               map.get(num[i])[1]+=1;
               map.get(num[i])[0]=i;
           }else {
               Integer[] countInformation = new Integer[2];
               countInformation[0] = i;
               countInformation[1] = 1;

               map.put(num[i],countInformation);
           }
       }

       for(Map.Entry<Integer,Integer[]> entry : map.entrySet()){
           if(entry.getValue()[1] == 1){
               boolean check = checkValidState(entry.getValue()[0],num);
               if(!check){
                   return false;
               }
           }
       }
       return true;
   }

   private boolean checkValidState(int index,int[] num){


        if(index+1<num.length && index+2<num.length){
            if(num[index]+1 == num[index+1] && num[index+1]+1 == num[index+2]){
                return true;
            }
        }
        if(index-1>=0 && index-2 >=0){
            if(num[index-2]+1 == num[index-1] && num[index-1]+1 == num[index]){
                return true;
            }
        }

        if(index+1<num.length && index-1>=0){
            if(num[index-1]+1 == num[index] && num[index] +1 == num[index+1]){
                return true;
            }
        }

        return false;
   }
}
