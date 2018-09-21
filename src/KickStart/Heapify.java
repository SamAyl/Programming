package KickStart;

import java.util.HashMap;
import java.util.Map;

public class Heapify {

    public static void main(String[] args) {
        int[] arr = {4,7,9,0,10,9};


        heapify(arr);
        System.out.println(arr);
    }

    public static void heapify(int[] arr){

        for(int i = arr.length;i>=0;i--){
            heapify(arr,i);
        }

    }

    public static void heapify(int[] arr,int i){

       int l = 2*i+1;
       int r = l+1;

       int largest = i;
       if(l<arr.length && arr[l] > arr[i]){
           largest = l;
       }

       if(r<arr.length && arr[r]>arr[largest]){
           largest = r;
       }


       if(largest!=i){
           swap(arr,i,largest);
           heapify(arr,largest);
       }



    }


    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i]  = a[j];
        a[j] = temp;
    }



}
