package Prod;

import java.util.*;

public class Prooduct {

   public static Map<Integer,List<Integer>> map = new HashMap<>();
   public static List<Integer> maxList = new ArrayList<>();

    public static void main(String[] args){
     int[] a = {-1,3,2,9,20,-9};
     maxProd(a);
    }

    public static void maxProd(int[] a){
         int count = a.length-1;

         List<Integer> list = new ArrayList<>();
         list.add(a[count]);
         map.put(a[count],list);
         count--;

         while (count>=0){
             List<Integer> list1 = map.get(a[count+1]);
             map.put(a[count],getList(list1,a[count]));
             findMax(map.get(a[count]));
             count--;
         }

        int max = maxList.get(0);
        for(Integer i : maxList){
            if(i>max){
                max = i;
            }
        }

        System.out.println(max);


    }




    public static void findMax(List<Integer> list){
        int max = list.get(0);
        for(Integer i : list){
            if(i>max){
                max = i;
            }
        }


        maxList.add(max);
    }

    public static List<Integer> getList(List<Integer> list,int num){
        List<Integer>  list1 = new ArrayList<>();
        list1.add(num);
        for(Integer i: list){
            list1.add(num*i);
        }

        return list1;
    }
}
