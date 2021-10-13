package LeetCode;

import java.util.*;

public class Combine {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(3,7,new ArrayList<>(),0,0,ans);
        System.out.println(ans);
    }

    public static void combine(int k,int n,List<Integer> list,int sum,int str, List<List<Integer>> ans) {
        if(k == 0){
            if(sum == n){
                List<Integer> temp1 = new ArrayList<>();
                temp1.addAll(list);
                ans.add(temp1);
            }
            return;
        }

        if(sum>n){
            return;
        }


        for(int i = str;i<n;i++){
            sum = sum+i;
            list.add(i);
            combine(k-1,n,list,sum,i+1,ans);
            list.remove(list.size()-1);
            sum = sum-i;

        }
    }
}
