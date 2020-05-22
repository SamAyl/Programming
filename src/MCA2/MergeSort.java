package MCA2;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {1,2,5,4,7,9,0};

        print(a);
        print(mergeSort(a));
    }


    private static int[] mergeSort(int[] a) {

        int s = 0;
        int e = a.length-1;

       return mergeSort(a,s,e);

    }

    private static void print(int[] a){
      for(int i = 0;i<a.length;i++) {
          System.out.print(a[i]+ "\t");
      }
        System.out.println();
    }


    private static int[] mergeSort(int[] a, int s, int e){

        if(s>e){
            return null;
        } else if (s == e) {
            int[] res = new int[1];
            res[0] = a[s];
            return res;
        } else {

            int mid = (e-s)/2;
            int[] l = mergeSort(a,s,s+mid);
            int[] r = mergeSort(a,s+mid+1,e);

            if (l != null && r == null) {
                return l;
            } else if (r != null && l == null) {
                return r;
            } else if( l == null && r == null) {
                return null;
            } else {
                return mergify(l, r);
            }

        }
    }


    private static int[] mergify(int[] l, int[] r){
        int[] res = new int[l.length + r.length];

        int lP = 0;
        int rP = 0;
        int count = 0;

        while (lP < l.length && rP < r.length) {

            if (l[lP] <= r[rP]) {
                res[count] = l[lP];
                lP++;
            } else {
                res[count] = r[rP];
                rP++;
            }
            count++;
        }

        if(lP!=l.length) {
            while (lP < l.length){
                res[count] = l[lP];
                lP++;
                count++;
            }
        } else if(rP != r.length) {
            while (rP < r.length) {
                res[count] = r[rP];
                rP++;
                count++;
            }
        }

        return res;
    }
}
