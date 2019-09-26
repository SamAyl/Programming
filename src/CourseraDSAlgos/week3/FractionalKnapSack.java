package CourseraDSAlgos.week3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FractionalKnapSack {
    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(4,20);
        map.put(2,14);
        map.put(3,18);

        System.out.println(fractionalKnapSack(map,7));
    }

    public static double fractionalKnapSack(Map<Integer,Integer> map,int maxWeight){

        Map<Double,Integer> fractionalMap = new TreeMap<Double,Integer>(Collections.reverseOrder());

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Double fraction = (double)entry.getValue()/entry.getKey();
            fractionalMap.put(fraction,entry.getKey());
        }

       Double val = 0.0;

        for(Map.Entry<Double,Integer> entry : fractionalMap.entrySet()){

            if(maxWeight==0){
                break;
            }

            int w = entry.getValue();
            if(w>maxWeight){
                val+=maxWeight*entry.getKey();
                break;
            }else {
                val+=w*entry.getKey();
            }

            maxWeight-=w;
        }


        return val;
    }
}
