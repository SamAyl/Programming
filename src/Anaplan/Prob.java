package Anaplan;

public class Prob {

    public static void main(String[] args) {
        int[] a= {0,1,2,2,1};

        int end= -1;

        int i = 0;

        while(i<a.length) {
            if (a[i] != 2) {
                end = end +1 ;
                swap(i,end,a);
                i++;
            } else {
                i++;
            }
        }

        i = 0;
        int end2 = -1;

        while (i < end) {
            if (a[i] !=1) {
              end2 = end2+1;
              swap(i,end2,a);
              i++;
            }else {
                i++;
            }

        }


        print(a);
    }


    public static void print(int[] a) {
        for(int i : a) {
            System.out.println(i);
        }
    }

    public static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
