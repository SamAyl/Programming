package WeekendSessions;

public class LongestIncSubSq {

    public static void main(String[] args) {
       int[] arr = {10,1,13,14,12,15};
       int maxCount = findLongestSubSeq(arr);
        System.out.println(maxCount);
    }

    public static int findLongestSubSeq(int[] arr) {

        if (arr== null || arr.length==0) {
            return 0;

        }

        if (arr.length == 1) {

            return arr.length;

        }


        int[] longestSubSq = new int[arr.length];

        //for the firstElement length is 1

        longestSubSq[0] = 1;




        for (int idx = 1; idx < arr.length; idx++) {

            int tempLongestSubSq = Integer.MIN_VALUE;

            for (int subArr = 0; subArr < idx ; subArr++) {

                if (arr[subArr] <= arr[idx] && tempLongestSubSq < longestSubSq[subArr]+1) {
                    tempLongestSubSq = longestSubSq[subArr]+1;

                }
            }

            longestSubSq[idx] = tempLongestSubSq;

        }

        int maxCount = Integer.MIN_VALUE;
        for (Integer count : longestSubSq) {

            if (count > maxCount) {

                maxCount = count;
            }

        }

        return maxCount;

    }
}
