package AlgoExpert;

import java.util.*;

public class KnapSack {

    public static void main(String[] args) {
        int[][] items = {{1,2}, {4,3} , {5,6} ,{6,7}};
        int capacity = 10;

        findMaxCombination(items,new HashSet<>(),10, 0);
        System.out.println(maxValue);
        System.out.println(list);

    }

    static int maxValue;
    static List<Integer> list = new ArrayList<>();
    public static void findMaxCombination(int[][] items, Set<Integer> visited, int totCapacity, int currentCapacity) {

        if(totCapacity == currentCapacity) {
            if (maxValue < currentCapacity) {
                maxValue = currentCapacity;
                list = new ArrayList<>();
                list.addAll(visited);
                return;
            }
        }


        for (int i = 0; i< items.length; i++) {
            if (!visited.contains(i)) {
                 currentCapacity+= items[i][1];
                 if (currentCapacity > totCapacity) {
                     currentCapacity-= items[i][1];
                      if (maxValue < currentCapacity) {
                          maxValue = currentCapacity;
                          list = new ArrayList<>();
                          list.addAll(visited);
                      }
                 } else {
                     visited.add(i);
                     findMaxCombination(items, visited, totCapacity, currentCapacity);
                     visited.remove(i);
                     currentCapacity -= items[i][1];
                 }
            }
        }

    }

}
