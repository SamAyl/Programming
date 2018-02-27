package Consecutive;

import java.util.HashMap;
import java.util.Map;

public class App1 {

   static double[] a = {1,2,2,4,4,5,3,3,1};
   static Map<Integer,Integer> map = new HashMap<>();

   public static void main(String[] args){

       createMap();
       remove();
       for(int i =0;i<a.length;i++){
           System.out.println(a[i]);
       }



   }


    public static void remove(){


        if(map.size()==0){
            return;
        }
        replace();
        createMap();
        remove();

    }


    public static void replace(){
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int i1 = entry.getKey();
            int i2 = entry.getValue();

            a[i1] = Double.NaN;
            a[i2] = Double.NaN;
        }


    }


    public static int check(int ref){
        int next = -1;
        int i = ref+1;

        while (i<a.length){
            if(a[i]==Double.NaN){
                i++;
                continue;
            }else {
                if(a[ref]==a[i]){
                   map.put(ref,i);
                   next = i+1;
                    break;
                }else{
                    i++;
                }
            }
        }


        return next;
    }

    public static void createMap(){
        map = new HashMap<>();
        int count = 0;

        while (count<a.length-1){
          int temp = check(count);
          if(temp!=-1){
              count = temp;
          }else {
              count++;
          }

        }
    }
}
