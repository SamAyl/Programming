package AlgoExpert;

import java.util.*;

public class Permutation {

    public static void main(String[] args) {

    }

    public static void getPerm(List<Integer> arr, Set<Integer> visited, List<Integer> temp, List<List<Integer>> ans) {
           if (temp.size() == arr.size()) {
               List<Integer> list = new ArrayList<>();
               list.addAll(temp);
               ans.add(list);
               return;
           }

             for (int i = 0;i < arr.size();i++) {
                  if (!visited.contains(i)){
                      temp.add(arr.get(i));
                      visited.contains(i);
                      getPerm(arr,visited,temp,ans);
                      visited.remove(i);
                      temp.remove(temp.size()-1);
                  }
             }

    }
}
