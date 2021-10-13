package CSES;

public class SegTree {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] segTree = new int[nums.length * 4];

        fillTree(nums,segTree,0,nums.length-1,1);
        int ans = getRSum(nums,segTree,0,0,0,3,1);
        System.out.println(ans);

    }

    public static void fillTree(int[] nums, int[] seg, int str, int end, int idx) {

        if (str == end){
            seg[idx] = nums[str];
            return;
        }


        int mid = (str+end)/2;
        fillTree(nums, seg,str, mid,2*idx);
        fillTree(nums,seg,mid+1,end,((2*idx)+1));
        seg[idx] = seg[2*idx] + seg[(2*idx)+1];

    }

    public static int getRSum(int[] nums, int[] segTree, int str, int end,int refS, int refE, int idx) {
        if (str > end) {
            return 0;
        }

        if (refS == str && refE == end) {
            return segTree[idx];
        }


        int mid = (refE+refS)/2;

        if (str <= mid && mid <= end) {
          return   getRSum(nums,segTree,str,mid,refS,mid,2*idx) + getRSum(nums,segTree,mid+1,end,mid+1,refE,2*idx + 1);
        }else if (str >mid) {
            return getRSum(nums,segTree,str,end,mid,refE,2*idx+1);
        } else  {
            return getRSum(nums,segTree,str,mid,refS,refE,2*idx);
        }



    }
}
