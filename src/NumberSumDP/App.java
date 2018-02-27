package NumberSumDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {


    public static Map<Sum, List<String>> map = new HashMap<>();

    public static void main(String[] args) {

        int[] arr = {1, 2};
        printTotalCombinations(arr, 6, 0, new StringBuilder());
        System.out.println(printTotalCombination(0,arr,6));
        System.out.println(map.toString());


    }


    public static void printTotalCombinations(int[] arr, int sum, int start, StringBuilder sb) {

        for (int i = start; i < arr.length; i++) {
            if (sum == arr[i]) {
                sb.append(arr[i]);
                System.out.println(sb.toString());
                sb.deleteCharAt(sb.length() - 1);

            } else if (sum < arr[i]) {
                continue;
            } else {
                int tempSum = sum - arr[i];
                sb.append(arr[i]);

//                if(map.containsKey(new Sum(i,tempSum))){
//                    exists(sb,map.get(tempSum));
//                    sb.deleteCharAt(sb.length()-1);
//                }else {
                printTotalCombinations(arr, tempSum, i, sb);
                sb.deleteCharAt(sb.length() - 1);
                //}

            }
        }
    }


    public static List<String> printTotalCombination(int start, int[] arr, int sum) {
        List<String> list = new ArrayList<>();

        for (int i = start; i < arr.length; i++) {
            if (sum == arr[i]) {
                list.add(Integer.toString(sum));
            } else if (sum < arr[i]) {
                continue;
            } else {
                int newSum = sum - arr[i];
                Sum tempSum = new Sum(arr[i], newSum);
                if (map.containsKey(tempSum)) {
                    list.addAll(exists(map.get(tempSum), arr[i]));

                } else {
                    List<String> list1 = printTotalCombination(i, arr, newSum);
                    if (list1 != null && list1.size() != 0) {
                        list.addAll(exists(list1, arr[i]));
                    }
                }
            }
        }


        if(list.size()!=0) {
            map.put((new Sum(arr[start], sum)), list);
        }

        return list;

    }

    public static List<String> exists(List<String> list, int num) {
        List<String> list1 = new ArrayList<>();

        for (String s : list) {
            list1.add(Integer.toString(num) + s);
        }

        return list1;
    }

}
    class Sum {
        int value;
        int sum;

        Sum(int value, int sum) {
            this.sum = sum;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Sum sum1 = (Sum) o;

            if (value != sum1.value) return false;
            return sum == sum1.sum;
        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + sum;
            return result;
        }

        @Override
        public String toString() {
            return "Sum{" +
                    "value=" + value +
                    ", sum=" + sum +
                    '}';
        }
    }


