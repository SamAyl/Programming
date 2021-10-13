package Segment;

public class App {

    public static void main(String[] args) {
        int[] arr = { 1,0,2,1};

        int[] seg = new int[4*arr.length];

        formSegTree(arr,seg,0,arr.length-1,1);
        int a = getRangeSum(seg,1,3,1,0,arr.length-1);
        System.out.println(a);
        update(seg, 1,0, arr.length-1, 1, 1);
        int b = getRangeSum(seg,1,3,1,0, arr.length-1);
        System.out.println(b);


    }

    public static void formSegTree(int[] arr, int[] seg, int str, int end, int index) {

        if (str == end) {
            seg[index] = arr[str];
            return;
        }

        int mid = (str+end)/2;
        formSegTree(arr,seg,str,mid,2*index);
        formSegTree(arr,seg,mid+1,end,2*index+1);

        seg[index] = seg[2*index] + seg[2*index+1];
    }

    public static int getRangeSum(int[] seg, int strRange, int endRange, int index, int str, int end) {
         if (strRange == str && endRange == end) {
             return seg[index];
         }

         if (strRange > end) {
             return 0;
         } else  if (endRange < str) {
             return 0;
         } else if ( strRange >= str && endRange<=end) {
             int mid = (str+end)/2;
             return getRangeSum(seg,strRange,endRange,2*index,str,mid) + getRangeSum(seg,strRange,endRange,(2*index)+1,mid+1,end);
         } else if (strRange< str && (str<=endRange && endRange<=end)) {
             strRange = str;
             return getRangeSum(seg,strRange,endRange,index,str,end);
         } else if (endRange > end && (str<= strRange && strRange <= end)) {
             endRange = end;
             return getRangeSum(seg,strRange,endRange,index,str,end);
         }

         return 0;
    }

    public static int update(int[] seg, int index, int strRange, int endRange, int rangeIndex, int value) {

         if (strRange == endRange) {
             int delta = value - seg[index];
             seg[index] = value;
             return delta;
         }


        int mid = (strRange + endRange) / 2;

        if (rangeIndex > mid) {
            int delta = update(seg,2*index+1,mid+1,endRange,rangeIndex,value);
            seg[index]+=delta;
            return delta;
        } else {
            int delta = update(seg,2*index, strRange, mid, rangeIndex, value);
            seg[index]+=delta;
            return delta;
        }

    }
}
