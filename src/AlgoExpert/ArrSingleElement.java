package AlgoExpert;

public class ArrSingleElement {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6};

        int str = 0;
        int end = a.length - 1;

        while (str <= end) {
            int mid = (str + end) / 2;

            if (mid +1 <= end && a[mid] == a[mid + 1]) {
                if ((end - (mid + 1)) % 2 != 0) {
                    str = mid + 2;
                } else {
                    end = mid - 1;
                }
            } else if (mid-1>= str && a[mid] == a[mid - 1]) {
                if (((mid - 1) - str) % 2 != 0) {
                    end = mid - 2;
                } else {
                    str = mid + 1;
                }
            } else {
                System.out.println(a[mid]);
                break;
            }
        }

    }
}
