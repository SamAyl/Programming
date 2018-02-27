package Sorting;

public class MergeSort {

    public static void main(String[] args){
        int[] a = {-2,9,0,9,1};
        print(sort(a,0,4));


    }

    public static int[] sort(int[] a,int l,int r){
        if(l==r){
            int[] b = new int[r-l+1];
            b[0] = a[l];
            return b ;
        }else {
            int mid = (r-l)/2;
            int[] left =  sort(a,l,l+mid);
            int[] right =  sort(a,l+mid+1,r);
            return   Merge(left,right);
        }

    }

    public static int[] Merge(int[] l,int[] r ){

        int sizeL= 0;
        int sizeR = 0;
        int resultCount = 0;

        int[] resultArr = new int[l.length+r.length];

        while (sizeL<=l.length-1 && sizeR<=r.length-1){
            if(l[sizeL]<=r[sizeR]){
                resultArr[resultCount] = l[sizeL];
                sizeL++;
                resultCount++;
            }else {
                resultArr[resultCount] = r[sizeR];
                sizeR++;
                resultCount++;
            }
        }



        if(sizeL>l.length-1 && sizeR<=r.length-1){
            resultArr[resultCount] = r[sizeR];
            resultCount++;
            sizeR++;
        }else if(sizeR>r.length-1 && sizeL<=l.length-1){
            resultArr[resultCount] = l[sizeL];
            resultCount++;
            sizeL++;
        }


        return resultArr;
    }


    public static void print(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
