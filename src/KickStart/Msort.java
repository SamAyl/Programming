package KickStart;

public class Msort {

    public static void main(String[] args) {

        int[] a = {3,0,-1,9};
        mergeSort(a,0,3);
        print(a);
    }


    public static void mergeSort(int[] a,int start,int end){
        if(start>=end){
            return;
        }

        int mid = start + (end - start)/2;

        //sort the left array
        mergeSort(a,start,mid);

        //sort the right array
        mergeSort(a,mid+1,end);

        //merge both of them
        mergify(a,start,mid,end);
    }



    public static void mergify(int[] a,int start,int mid,int end){
        int[] l = new int[mid-start+1];
        int[] r = new int[end-mid];

        copy(a,l,start,mid);
        copy(a,r,mid+1,end);


        int lCount = 0;
        int rCount = 0;
        int count = start;

        while (lCount<=l.length-1 && rCount<=r.length-1){
            if(l[lCount]<=r[rCount]){
                a[count] = l[lCount];
                lCount++;
            }else {
                a[count] = r[rCount];
                rCount++;
            }
            count++;
        }

        while (lCount<=l.length-1){
            a[count] = l[lCount];
            count++;
            lCount++;
        }

        while (rCount <= r.length-1){
            a[count] = r[rCount];
            count++;
            rCount++;
        }

    }

    public static void copy(int[] a,int[] arr,int start,int end ){
        int tempCount = start;
        int count = 0;
        while (tempCount<=end){
            arr[count] = a[tempCount];
            tempCount++;
            count++;
        }
    }


    public static void print(int[] a){
        for(int i  : a){
            System.out.println(i);
        }
    }
}
