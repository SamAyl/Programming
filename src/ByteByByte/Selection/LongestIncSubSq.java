package ByteByByte.Selection;


import java.util.*;

public class LongestIncSubSq {

    private static List<Integer> largest = new ArrayList<>();


    public static void main(String[] args) {
        int[] arr = {1,5,2,6,3,4};

        List<Integer> temp = new ArrayList<>();
        makeLargestSq(arr,0,temp);
        print();
    }


    public static void makeLargestSq(int[] arr, int idx, List<Integer> temp) {

        if (idx == arr.length) {
            if (largest.size() < temp.size()) {
                largest.clear();
                largest.addAll(temp);
            }
            return;
        }


        int element = arr[idx];
        if (temp.size() != 0) {
            if (temp.get(temp.size()-1) <= element) {
                temp.add(element);
                makeLargestSq(arr,idx+1,temp);
                temp.remove(temp.size()-1);
            }
        } else {
            temp.add(element);
            makeLargestSq(arr,idx+1,temp);
            temp.remove(temp.size()-1);
        }

        makeLargestSq(arr,idx+1,temp);
    }

    public static void print() {
        for(Integer singleNumber : largest) {
            System.out.print(singleNumber+"\t");
        }

        System.out.println();
    }
}
