package AlgoExpert;

import java.util.*;

public class LargestRange {

    public static void main(String[] args) {
        int[] arr = {0, 9, 19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14};

        int[] parent = new int[arr.length];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();


        for (int i = 0; i< arr.length ;i++) {
            int number = arr[i];

            if (i == 6) {
                System.out.println();
            }
            if (map.containsKey(number)) {
                parent[i] = parent[map.get(number)];
            } else if (map.containsKey(number-1) && !map.containsKey(number+1)) {
                parent[i] = parent[map.get(number-1)];
            } else if (map.containsKey(number+1) && !map.containsKey(number-1)) {
                parent[i] = parent[map.get(number+1)];
            } else if (map.containsKey(number-1) && map.containsKey(number+1)) {
                parent[i] = parent[map.get(number-1)];
                int superParent = getParentIndex(parent,map.get(number+1));
                parent[superParent] = parent[map.get(number-1)];
            } else  {
                parent[i] = i;
            }


            if (!map.containsKey(number)) {
                map.put(number,i);
            }

        }


        reset(parent);



        Map<Integer, int[]> map1 = new HashMap<>();

        for (int j = 0; j<parent.length; j++) {
            if (map1.containsKey(parent[j])) {
                int[] range = map1.get(parent[j]);

                if (range[0] > arr[j]) {
                    range[0] = arr[j];
                } else if (range[1] < arr[j]) {
                    range[1] = arr[j];
                }

            } else {
                int[] range = new int[2];
                range[0] = arr[j];
                range[1] = arr[j];
                map1.put(parent[j],range);
            }
        }



        Integer minSize = Integer.MIN_VALUE;
        int[] maxRange=null;
        for (Map.Entry<Integer, int[]> entry : map1.entrySet()) {
             int[] size = entry.getValue();
             if (size[1] - size[0] > minSize) {
                 maxRange = size;
                 minSize = (size[1] - size[0]);
             }
        }

        System.out.println(maxRange[0] + " ============= "+ maxRange[1]) ;
    }


    public static void reset(int[] parent) {
        for (int i = 0; i< parent.length; i++) {
            if (parent[i] == i){
                continue;
            } else {
                int superParent = getParentIndex(parent,i);
                parent[i] = superParent;
            }
        }
    }


    public static int getParentIndex(int[] par, int j) {

        if (par[j] == j) {
            return j;
        }

       return getParentIndex(par,par[j]);
    }

}