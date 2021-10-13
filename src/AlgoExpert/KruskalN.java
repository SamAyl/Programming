package AlgoExpert;

import java.util.*;

public class KruskalN {

    public static void main(String[] args) {
         Set<Integer> set = new TreeSet<Integer>();
         set.add(10);
         set.add(-9);
         set.add(8);
         set.add(-8);

         for (Integer i : set) {
             System.out.println(i);
         }
        System.out.println("<=============================================>");
         List<Integer> list = new ArrayList<>();
         list.add(10);
         list.add(-9);
         list.add(8);
         list.add(-8);

         Collections.sort(list);

         for (Integer j : list) {
             System.out.println(j);
         }

        System.out.println("<=============================================>");

         int[][] arr = new int[3][2];

         int[] a1 = {-10,2};
         int[] a2 = {-10,3};
         int[] a3 = {5,2};

         arr[0] = a1;
         arr[1] = a2;
         arr[2] = a3;

         Arrays.sort(arr, new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 return o1[0]-o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1];
             }
         });

        Arrays.sort(arr, (a,b)-> a[0]-b[0] !=0 ? a[0]-b[0] : a[1] - b[1]);
         for(int[] a : arr) {
             print(a);
         }

        System.out.println("<=============================================>");

         Set<Integer> set1 = new HashSet<>();
         set1.add(1);
         set1.add(2);
         set1.add(3);
         set1.add(4);

         Set<Integer> set2 = new HashSet<>();
         set2.add(2);
         set2.add(3);

         set1.retainAll(set2);

         for(int k : set1) {
             System.out.println(k);
         }
    }

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
