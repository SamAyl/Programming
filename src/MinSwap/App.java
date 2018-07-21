package MinSwap;

public class App {
    public static void main(String[] args) {
        int[] a = {2,3,2,5,6};
        int[] b = {0,1,4,4,5};


        System.out.println(minSwap(a,b));
    }

    public static int minSwap(int[] a,int [] b){
        int count = 0;
        for(int i = 1;i<a.length;i++){
            if(a[i-1]>=a[i] && b[i-1]<b[i]){




            }else if(b[i-1]>=b[i] && a[i-1] < a[i]){

            }
        }

        return count;
    }


    public static void swap(int[] a,int[] b,int i){
        int temp =  a[i];
        a[i] = b[i];
        b[i] = temp;
    }
}
