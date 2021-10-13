package AlgoExpert;

public class App2 {

    public static void main(String[] args) {
        int[] a = {4,4,4,4,4,5};

        int low = 0;
        int high = a.length -1;
        while (low <= high) {
            int mid = (low + high)/2;

            if (a[mid] < 4) {
                if (mid + 1 <= high ) {
                     if (a[mid+1] == 4) {
                         System.out.println(mid);
                         break;
                     }
                }
                    low = mid+1;

            } else if (a[mid] > 4) {
                high = mid-1;
            } else {
                if (mid-1 >=0) {
                    if (a[mid-1] != 4){
                        System.out.println(mid-1);
                        break;
                    }


                }

                high = mid-1;
            }

        }

       System.out.println(low);
    }
}
