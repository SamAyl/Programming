package Sorting;

public class QSort {

    public static void main(String[] args){

        int[] a = {1,4,2,-3,0};
        sort(a,0,4);
        print(a);
    }

    public static void sort(int[] a,int l,int r){

        if(l == r || l>r){
            return;
        }else {
            int index = findIndex(a,r);
            swap(a,index,r);
            sort(a,l,index-1);
            sort(a,index+1,r);
        }
    }

    public static int findIndex(int[] a,int pivot){
        int i=-1;
        int j = 0;

        while (j<pivot){
            if(a[j]<a[pivot]){
                i++;
                swap(a,i,j);
            }
            j++;
        }

        i++;

        return i;
    }

    public static void swap(int[] a,int i,int r){
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
    }

    public static void print(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
