package ByteByByte.Selection;

import java.util.*;

public class Combination {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int sum = 5;
        List<List<Integer>> list = new ArrayList<>();

        getCombination(a,0,new ArrayList<>(),0,list,5);
        print(list);
    }

    public static void getCombination(int[] a, int idx, List<Integer> temp, int tempSum, List<List<Integer>> ans, int REQUIREDSUM) {

          if (idx == a.length) {
              return;
          }

           temp.add(a[idx]);
           tempSum+=a[idx];

           if (tempSum == REQUIREDSUM) {
               List<Integer> tempAns = new ArrayList<>();
               tempAns.addAll(temp);
               ans.add(tempAns);
           } else {
               getCombination(a,idx+1,temp,tempSum,ans,REQUIREDSUM);
           }


           temp.remove(temp.size()-1);
           tempSum-=a[idx];
           getCombination(a,idx+1,temp,tempSum,ans,REQUIREDSUM);

    }



    public static void print(List<List<Integer>> list) {
        for(List<Integer> list1 : list) {
            for(Integer singleNumber : list1) {
                System.out.print(singleNumber);
                System.out.print("\t");
            }

            System.out.println();
        }
    }
}
