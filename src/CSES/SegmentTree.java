package CSES;

public class SegmentTree {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = new int[a.length*4];
        makeSegmentTree(a,b,0,a.length-1,1);
        for(int i : b) {
            System.out.print(i + "\t");
        }
        System.out.println();

        System.out.println(getRange(a,b,0,2,1,1,2));
        a[1]  = 3;
        update(a,b,0,2,1,1);
        for(int i : b) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }


    public static void makeSegmentTree(int[] a, int[] b, int str, int end, int idx) {
       if (str> end){
           return;
       }

        if (str == end) {
            b[idx] = a[str];
            return;
        }

        int mid = (str+end)/2;
        makeSegmentTree(a,b,str,mid,2*idx);
        makeSegmentTree(a,b,mid+1,end,2*idx+1);

        b[idx] = b[2*idx] + b[2*idx + 1];
    }

    public static int getRange(int[] a, int[] b, int str, int end, int idx, int str1, int end1) {

        if (str == str1  && end == end1) {
            return b[idx];
        }


        int mid = (str + end)/2;
        if (str1 > mid) {
            return getRange(a,b,mid+1,end,2*idx+1,str1,end1);
        } else if (end1 < mid +1) {
            return getRange(a,b,str,mid,2*idx,str1,end1);
        } else {
            return (getRange(a,b,str,mid,2*idx,str1,mid) + getRange(a,b,mid+1,end,2*idx+1,mid+1,end1));
        }
    }

    public static int update(int[] a, int[] b, int str , int end, int idx, int aidx) {

        if (str == end && aidx == str) {
            b[idx] = a[aidx];
            return b[idx];
        }

        int mid = (str + end)/2;
        if (aidx > mid) {
           b[idx] =  update(a,b,mid+1,end,2*idx+1,aidx) + b[2*idx];
           return b[idx];

        } else {
            b[idx] = update(a,b,str,mid,2*idx,aidx) + b[2*idx+1];
            return b[idx];
        }

    }
}
