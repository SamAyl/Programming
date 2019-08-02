package Comb;


import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        int[] num = {1,2,3,4};
        List<List<Integer>> lists = new ArrayList<>();
        comb(num,0,2,lists,new ArrayList<>());

        System.out.println(lists);

    }


    public static void comb(int[] num,int index,int k,List<List<Integer>> ans,List<Integer> result){
        if(result.size() == k){
            ans.add(new ArrayList<>(result));
            return;
        }


        for(int i = index;i<num.length;i++){
            result.add(num[i]);
            comb(num,i+1,k,ans,result);
            result.remove(result.size()-1);
        }
    }


}
