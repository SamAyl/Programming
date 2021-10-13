package AlgoExpert;

public class ShiftedBinarySearch {
    public static void main(String[] args) {
        System.out.println(shiftedBinarySearch(null,0));
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        int[] a = {71, 72, 73, 0, 1, 21, 33, 37, 45, 61};
        target = 73;
        int indexShiftPosition = findPosition(a,0,a.length-1);
        if (indexShiftPosition != -1) {
            if (a[0] <= target && target <= a[indexShiftPosition-1]) {
                return binarySearch(a,0,indexShiftPosition-1,target);
            } else {
                return binarySearch(a,indexShiftPosition,a.length-1,target);
            }

        } else {
            return binarySearch(a,0, a.length - 1, target);
        }
        //  return -1;
    }

    public static int findPosition(int[] a, int low, int high) {

        while(low <=high) {
            int mid = (low + high)/2;

            if (a[mid] < a[low]) {
                if(mid-1>=low && a[mid-1] > a[mid]) {
                    return mid;
                }

                high = mid -1;

            } else{
                if (mid + 1 <=high && a[mid+1] < a[mid]) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] a, int low, int high, int target) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == target) {
                return mid;
            }

            if (a[mid] < target) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }
}
