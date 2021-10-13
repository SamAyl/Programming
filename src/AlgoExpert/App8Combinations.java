package AlgoExpert;

import java.util.*;

public class App8Combinations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums2 = {4,0};

        Map<Integer,List<int[]>> map = new TreeMap<>();

        for(int i = 1;i<=nums.length;i++) {
            map.put(i,new ArrayList<int[]>());
            getNumbers(nums,0,i,map ,new StringBuilder());
        }

       Map<Integer,List<int[]>> map2 = new TreeMap<>();
       // for (int j = 1; j<nums)
    }


    public static void getNumbers(int[] nums, int idx1, int k, Map<Integer,List<int[]>> map, StringBuilder sb ) {
        if (k == sb.length()) {
            map.get(k).add(makeArr(sb.toString()));
            return;
        }

        for(int i = idx1; i<nums.length;i++) {
            sb.append(nums[i]);
            getNumbers(nums,i+1,k,map,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static int[] makeArr(String s) {
        int[] ans = new int[s.length()];

        for(int i = 0; i<ans.length;i++) {
            ans[i] = Character.getNumericValue(s.charAt(i));
        }

        return ans;
    }
}

class Index1 {
    int idx1;
    int idx2;

    public Index1(int idx1, int idx2) {
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Index1)) {
            return false;
        } else {
            Index1 index1 = (Index1)o;
            return index1.idx1 == idx1 && index1.idx2 == idx2;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(idx1,idx2);
    }
}
