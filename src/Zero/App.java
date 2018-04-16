package Zero;

import java.util.*;

public class App {

    public static void main(String[] args){
        int[] a = {1,2,0,4,0,0,9};
        setArray(a);

        for(Integer i : a){
            System.out.println(i);
        }
    }

    public static void setArray(int[] a){
         int i = 0;
         int j =0;

         while(j<a.length-1){
             if(a[i]!=0){
              //   i
             }
         }
    }

    public static void swap(int[] a,int i,int j){
        a[i] = a[j];
        a[j] = 0;
    }
}
