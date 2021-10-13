package AlgoExpert;

import java.util.*;

public class ZigZag {

    public static void main(String[] args) {

    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

        Iterator<?>[] it = new Iterator<?>[array.size()];
        int count = setIterator(array, it);
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] rowIndex = startValue(array);

        for (int i = 0; i<count; i++) {

            for (int j =0; j<rowIndex.length; j++) {
                if(rowIndex[j] < array.get(0).size()) {
                    if(rowIndex[j]>=0) {
                        it[j].hasNext();
                        queue.add((Integer) it[j].next());
                    }

                    rowIndex[j]+=1;
                }
            }


            if (i%2 == 0) {
                while(!queue.isEmpty()) {
                    result.add(((LinkedList<Integer>) queue).removeLast());
                }
            } else {
               while (!queue.isEmpty()) {
                   result.add(((LinkedList<Integer>) queue).removeFirst());
                }
             }

        }
        return result;
    }


    public static int setIterator(List<List<Integer>> array, Iterator<?>[] it) {
        int i = 0;
        int totSize = 0;

        for(List<Integer> list : array) {
            it[i] = list.iterator();
            i++;
            totSize++;
        }

        totSize+= array.get(0).size() - 1;
        return totSize;
    }

    public static  int[] startValue(List<List<Integer>> list) {
        int[] res = new int[list.size()];

        int count1 = list.get(0).size();
        int count2 = count1;
        for (int i = 0; i<res.length; i++) {
            res[i]  =  count1 - count2;
            count1--;
        }

        return res;
    }

}
