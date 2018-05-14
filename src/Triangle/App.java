package Triangle;

import java.util.*;

public class App {

    public static void main(String[] args) {

        int[] num = {66,48,61,46,75,94};
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        getTriSet(num,0,new ArrayList<>(),result);
        System.out.println(result.size());
    }

    public static void getTriSet( int[] num, int index, List<Integer> list, List<List<Integer>> result){
        if(list.size()==3){
            if(check(list)) {
                result.add(new ArrayList<>(list));
            }
        }


        for(int i = index;i<num.length;i++){
            list.add(num[i]);
            int listSize = list.size();
            getTriSet(num,i+1,list,result);
            list.remove(listSize-1);
        }
    }


    public static boolean check(List<Integer> list){
       
        if((list.get(0) + list.get(1))>list.get(2)){
            return true;
        }

        return false;
    }
}
