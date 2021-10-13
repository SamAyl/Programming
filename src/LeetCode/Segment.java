package LeetCode;

public class Segment {

    public static int[] arry = {1,2,3,4,5};
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] ans = getSegmentTree(arr);
        //System.out.println(ans);
        System.out.println(getRangeSum(ans, 1, 0, arr.length-1,2,4));
        arr[2] = 2;
        updateSegmentTree(ans,1,0,arr.length-1,2,arr);
       // System.out.println(ans);

    }

    public static int[] getSegmentTree(int[] arr){
       int[] segTree = new int[4*arr.length];
       makeSegmentTree(segTree,1,0,arr.length-1,arr);
       return segTree;
    }


    public static int makeSegmentTree(int[] segTree,int index, int str, int end, int[] arr){

       if(str == end){
           segTree[index] = arr[str];
           return arr[str];
       } else if(str>end){
           return 0;
       }

        int mid = (str+end)/2;
        int leftSum = makeSegmentTree(segTree,2*index,str,mid,arr);
        int rightSum = makeSegmentTree(segTree,(2*index)+1,mid+1,end,arr);

        segTree[index] = leftSum+rightSum;

        return segTree[index];

    }


    public static int updateSegmentTree(int[] segTree, int index, int str, int end, int updateIndex, int[] arr){
        if(str == end && str == updateIndex){
            segTree[index] = arr[updateIndex];
            return segTree[index];
        }


        int mid = (str+end)/2;
        if(mid>=updateIndex){
            int val = updateSegmentTree(segTree,2*index,str,mid,updateIndex,arr);
            segTree[index] = val + segTree[(2*index)+1];
        } else {
            int val = updateSegmentTree(segTree,(2*index)+1,mid+1,end,updateIndex,arr);
            segTree[index] = val + segTree[2*index];
        }

        return segTree[index];
    }

    public static int getRangeSum(int[] segTree,int index, int str, int end, int rangeL, int rangeR ) {


        if(str == rangeL && end == rangeR) {
            return segTree[index];
        }

        if ( rangeL>end || rangeR < str) {
            return 0;
        }

        if(str<=rangeL && end>=rangeR) {
            int mid = (str+end)/2;
            int leftSum = getRangeSum(segTree,2*index,str,mid,rangeL,rangeR);
            int rightSum = getRangeSum(segTree,(2*index + 1),mid+1,end,rangeL,rangeR);
            return  (leftSum + rightSum);
        }

        if ((str <= rangeL && rangeL<=end ) && rangeR > end) {
            return getRangeSum(segTree, index, str,end, rangeL, end);
        }

        if ( str > rangeL && (rangeR >= str && rangeR <=end) ) {
            return getRangeSum(segTree,index,str,end,str, rangeR);
        }

        return -1;
    }


}
