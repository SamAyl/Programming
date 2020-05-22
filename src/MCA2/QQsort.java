package MCA2;

import java.util.Random;

public class QQsort {

   static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {


        int i = l+1;
        int j = l;

        int equalP = l;
        while (i<=r){

        }


        swap(a,l,j);

        return null;
    }

    private static void swap(int[] a,int x,int y) {

        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;

    }



    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    private static void print(int[] a){
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {2 ,3, 9 ,2, 9};
        randomizedQuickSort(a,0,a.length-1);
        print(a);
    }
}
