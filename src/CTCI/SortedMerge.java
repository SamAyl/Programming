package CTCI;

public class SortedMerge {

    public static void main(String[] args){
        int[] a = {1,5,10,11,15,0,0,0,0,0};
        int[] b = {2,3,4,6,15};
        merge(a,b);

    }

    public static void merge(int[] a,int[] b){
        for(int i = 0;i<b.length;i++){
            a[a.length-b.length + i] = b[i];
        }

        mergeSort(a,new int[a.length],0,a.length-1);

        for(int j : a){
            System.out.println(j);
        }
    }

    public static void mergeSort(int[] a,int[] helper,int low,int high){
        if(low<high){
            int middle = (high-low)/2 + low;
            mergeSort(a,helper,low,middle);
            mergeSort(a,helper,middle+1,high);
            mergeArr(a,helper,low,middle,high);

        }
    }

    public static void mergeArr(int[] a,int[]helper,int low,int middle,int high ){
        for(int i = low;i<=high;i++){
            helper[i] = a[i];
        }

        int lIndex = low;
        int rIndex = middle+1;
        int aIndex = low;

        while (lIndex<=middle && rIndex<=high){
            if(helper[lIndex]<=helper[rIndex]){
                a[aIndex] = helper[lIndex];
                lIndex++;
            }else {
                a[aIndex] = helper[rIndex];
                rIndex++;
            }
            aIndex++;
        }

        if(lIndex>middle && rIndex<=high){
            while (rIndex<=high) {
                a[aIndex] = helper[rIndex];
                rIndex++;
                aIndex++;
            }
        }else if(rIndex>high && lIndex<=middle){
            while (lIndex<=middle){
                a[aIndex] = helper[lIndex];
                lIndex++;
                aIndex++;
            }
        }
    }
}
