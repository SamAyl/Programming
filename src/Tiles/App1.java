package Tiles;

public class App1 {


    public static int countPath;
    public static void main(String[] args){
        count(5);
    }

    public static void count(int n){
        if(n == 1){
            countPath = 1;
            return;
        }

        if(n==2){
            countPath = 2;
            return;
        }

        int[] arr = new int[n-1];
        reset(arr);


        int noOfTwos = n-1/2;
        int j = 1;
        set(arr,0);
        reset(arr);
        j++;

         while (j<=noOfTwos){
             for(int i = 0;i<arr.length-1;i++){
                 arr[i] = 2;
                 arr[i+1] = 0;

             }
        }
        reset(arr);


        System.out.println(countPath);

    }

    public static void reset(int[] arr){
        for(int i = 0;i<arr.length;i++){
            arr[i] = 1;
        }
    }

    public static void set(int[] arr,int index){
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = 2;
            arr[i + 1] = 0;
            countPath++;
        }
    }

}
