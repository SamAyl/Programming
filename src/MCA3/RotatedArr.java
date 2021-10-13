package MCA3;

public class RotatedArr {

    public static void main(String[] args) {
        int[] a = {5,6,7,8,9};
     //   int[] br = {}
        int[] ar = {6,7,8,9,5};

        System.out.println(findRotateIndex(ar));
    }

    public static int findRotateIndex(int[] a){
       return findRotateIndex(a,0,a.length-1);
    }

    public static int findRotateIndex(int[] a,int str,int end){


        while (str<=end){
            int mid = (str+end)/2;

            if(a[mid] >a[end]) {
                str = mid+1;
            } else if(a[mid] >= a[str]) {
                end = mid-1;
            }
        }

        return str;
    }
}
