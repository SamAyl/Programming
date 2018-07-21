package Greedy;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {


    public static void main(String[] args) {
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};

        Map<Integer,List<Integer>> map = getStartIndex(gas,cost);
        int index = -1;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            for(Integer integer : entry.getValue()){
                index =  findIndex(gas,cost,integer);
               if(index!=-1){
                   System.out.println(index);
               }

            }
        }




    }


    public static int findIndex(int[] gas,int[] cost,int start){

        int temp = start;
        int count = 0;

        int fuel =0;
        while (count<=gas.length-1){
            fuel += gas[temp];
            fuel = fuel - cost[temp];

            if(fuel>=0){
                if(temp==gas.length-1){
                    temp = 0;
                }else {
                    temp++;

                }

                count++;
            }else {
                return -1;
            }
        }

        return start;
    }


    public static Map<Integer,List<Integer>> getStartIndex(int[] gas, int[] cost){

        Map<Integer,List<Integer>> map = new TreeMap<>();

        for(int i = 0;i<gas.length;i++){

            if(gas[i] > cost[i]){
                if(map.containsKey(gas[i]-cost[i])){
                    map.get(gas[i]-cost[i]).add(i);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(gas[i]-cost[i],list);
                }
            }
        }

        return map;
    }



}
