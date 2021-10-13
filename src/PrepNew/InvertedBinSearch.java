package PrepNew;

public class InvertedBinSearch {

    public static void main(String[] args) {
        int[] a = {1,1,1};
        System.out.println(getIndex(a));
    }

    public static int getIndex(int[] arr) {
        int str = 0;
        int end = arr.length-1;


        while (str <= end) {
            int mid = (str+end)/2;

            // 9,8,10,11,1,2
            if (arr[mid]> arr[end]) {
                str = mid +1;
            } else if (arr[mid] < arr[str]) {
                end = mid -1;
            } else {
                return str;
            }
        }

        return end+1;
    }
}
