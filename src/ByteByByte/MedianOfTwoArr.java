package ByteByByte;

public class MedianOfTwoArr {

    public static void main(String[] args) {
        int[] a1 = {2};
        int[] a2 = {1,3};

        System.out.println(findMedian(a1,a2));
        System.out.println(findMedianSortedArrays(a1,a2));
     }


     //Think in terms of partition and accordingly adjust the array beginning and end value
         public static double findMedian(int[] nums1, int[] nums2){

             int[] bigArr = null;
             int[] smlArr = null;

             if(nums1.length > nums2.length){
                 bigArr = nums1;
                 smlArr = nums2;
             } else {
                 smlArr = nums1;
                 bigArr = nums2;
             }


             int s = 0;
             int e = smlArr.length;

             int elements = (int)Math.ceil((nums1.length + nums2.length)/2.0);

             while (s<=e){
                 int smallArrIndex = (s+e)/2;
                 int bigArrIndex = elements - (smallArrIndex);

                 int x1 = smallArrIndex == 0 ? Integer.MIN_VALUE : smlArr[smallArrIndex-1];
                 int y1 = bigArrIndex   == 0 ?Integer.MIN_VALUE :bigArr[bigArrIndex-1];



               int  x2 = smallArrIndex==smlArr.length? Integer.MAX_VALUE : smlArr[smallArrIndex];
                int y2 = bigArrIndex==bigArr.length ? Integer.MAX_VALUE:bigArr[bigArrIndex];

                 if(x1<=y2 && y1<=x2){
                     int median1 = Math.max(x1,y1);
                     if((bigArr.length + smlArr.length)%2==0){
                         int median2 = Math.min(x2,y2);
                         return (median1+median2)/2.0;
                     }
                     return median1;
                 } else if(x1>y2){
                     e = smallArrIndex-1;
                 } else {
                     s = smallArrIndex+1;
                 }

             }



             return 0;
         }


    public static double findMedianSortedArrays(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }


}
