package KickStart;

public class Qsort {

    public static void main(String[] args) {

        int[] a = {0,0,0,0};
        quickSort(a,0,a.length-1);
        print(a);
    }

    //divide
    public static int choosePivot(int[] a,int start,int end){
        return end;
    }




    //quickSort
    public static void quickSort(int[] a,int start,int end){
        if(start>=end){
            return;
        }else {
            int index = choosePivot(a,start,end);
            int partition = partition(a,start,end,index);
            quickSort(a,start,partition-1);
            quickSort(a,partition+1,end);
        }
    }


    //partition function
    //conquer part
    public static int partition(int[] a, int start,int end,int index){
        swap(a,end,index);

        int min= start-1;
        int curr = start;

        while (curr!=end){
            if(a[curr]>a[end]){
                curr++;
            }else {
                min++;
                swap(a,min,curr);
                curr++;
            }
        }

        min++;
        swap(a,min,end);

        return min;
    }

    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int[] a){
        for(int i  : a){
            System.out.println(i);
        }
    }
}
