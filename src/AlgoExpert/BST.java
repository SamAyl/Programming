package AlgoExpert;

import java.util.*;

public class BST {

    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        for(int i = 0; i< 7;i++) {
            one.add(i+1);
            two.add(i+1);
        }

        sameBsts(one,two);
     }
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        int[] bst = new int[4 * arrayOne.size() +1];
        int[] bst2 = new int[4* arrayOne.size() + 1];

        set(bst);
        set(bst2);

        for(int i = 0; i<arrayOne.size();i++) {
            putInBst(bst, arrayOne.get(i),1);
            putInBst(bst2,arrayTwo.get(i),1);
        }

        for(int j = 0; j<bst.length;j++) {
            if (bst[j] != bst2[j]) {
                return false;
            }
        }
        return true;
    }

    public static void set(int[] a) {
        for(int i = 0;i < a.length; i++) {
            a[i] = Integer.MIN_VALUE;
        }
    }

    public static void putInBst(int[] bst, int val ,int index) {
        if (bst[index] == Integer.MIN_VALUE) {
            System.out.println(index);
            bst[index] = val;
            return;
        }

        if (bst[index] <= val) {
            putInBst(bst,val,2*index+1);
            return;
        } else {
            putInBst(bst,val, 2*index);
            return;
        }
    }
}
