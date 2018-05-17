package ContigSum;

import java.util.*;

public class App {

    public static void main(String[] args){

     int[] a = {1,-2,3};
     Map<Integer,List<Integer>> map = new HashMap<>();
        System.out.println(maxSum(a,map));
    }

    public static int maxSum(int[] a,Map<Integer,List<Integer>> map){
        for(int i = 0;i<a.length;i++){
            for(int j = i;j<a.length;j++){
                if(!map.containsKey(i)){
                    List<Integer> list = new ArrayList<>();
                        list.add(a[j]);
                        map.put(i,list);
                }else {
                      if(!map.containsKey(i-1)){
                          List<Integer> list = map.get(i);
                          int tempSum = list.get(list.size()-1)+a[j];
                          list.add(tempSum);
                      }else {

                          List<Integer> list = map.get(i-1);
                          int tempSum = list.get(j-i+1)-a[i-1];
                          List<Integer> list1 = map.get(i);
                          list1.add(tempSum);
                      }
                }

            }
        }

        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
            int temp = entry.getValue().get(entry.getValue().size()-1);
            if(temp>max){
                max = temp;
            }
        }

        return max;
    }
}
