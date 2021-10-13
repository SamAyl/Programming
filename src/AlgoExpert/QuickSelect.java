package AlgoExpert;

public class QuickSelect {


    public static void main(String[] args) {
        int[] a = {8, 5, 2, 9, 7, 6, 3};  // 2,3,5,6,7,8,9
        int k = 3;

        System.out.println(quickselect(a,k));
    }

        public static int quickselect(int[] array, int k) {

            int parition = -1;
            int low = 0;
            int high = array.length -1;
            k = k-1;
            while(parition != k) {
                parition = parition(array,low, high);
                if (parition == k) {
                    return array[k];
                } else {
                    if (parition < k) {
                        low = parition + 1;
                    } else {
                        high = parition -1;
                    }
                }
            }

            return -1;
        }

        public static int parition(int[] arr,int low, int high) {

            int partition = low -1;
            int temp = low;
            while(temp<high) {
                if (arr[temp] < arr[high]) {

                        partition++;
                        swap(partition,temp,arr);
                         temp++;
                }	else {
                    temp++;
                }
            }

            swap(partition+1,high,arr);
            return partition+1;
        }

        public static void swap(int idx1, int idx2 ,int[] a) {
            int temp = a[idx1];
            a[idx1] = a[idx2];
            a[idx2] = temp;
        }

    }

