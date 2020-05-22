package MCA2;

public class QSort {

    public static void main(String[] args) {
        int[] a = {5,-1,2,0,6,2};
        sort(a);
        print(a);
    }

    public static void sort(int[] a){
        sort(a,0,a.length-1);

    }

    public static void sort(int[] a, int s, int e){
        if(s<e){
            int pivotIndex = getPivotIndex(a,s,e);
            sort(a,s,pivotIndex-1);
            sort(a,pivotIndex+1,e);
        }
    }

    private static int getPivotIndex(int[] a,int s,int e){
       int lowIndex = s-1;

        System.out.println("Start Index " + s);
        System.out.println("End Index " + e);
       for(int i = s;i<e;i++){
           if(a[i] <= a[e] && lowIndex == i-1){
               lowIndex++;
           } else if(a[i] <= a[e] && lowIndex != i-1) {
               swap(a,lowIndex+1,i);
               lowIndex = lowIndex+1;
           }
       }


       swap(a,lowIndex+1,e);
       return lowIndex+1;
    }


   private static void swap(int[] a, int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
   }

   private static void print(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i] + "\t");
        }
   }
}
