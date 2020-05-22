package MCA2;

public class Inversions {

    private static long getNumberOfInversions(int[] a,int [] b, int left, int right) {
        return getNumberOfInversionss(a,b,0,a.length-1);
    }

    private static long getNumberOfInversionss(int[] a, int[] b, int left, int right) {
        if(left > right) {
            return 0;
        }

        if(left == right) {
          //  System.out.println(left);
            b[left] = a[left];
            return 0;

        }

        long numberOfInversions = 0;
        int mid = (left + right) /2;

        numberOfInversions+=getNumberOfInversionss(a,b,left,mid);
        numberOfInversions+=getNumberOfInversionss(a,b,mid+1,right);

        int lp = left;
        int rp = mid+1;

        int count = lp;
        while(lp<=mid && rp<=right) {

            if(b[lp]>b[rp]){
                a[count] = b[rp];
                numberOfInversions+= (mid-lp)+1;
                rp++;
                count++;
            } else {
                a[count] = b[lp];
                count++;
                lp++;
            }
        }

        if(lp>mid && rp<=right){
            while(rp>right){
                a[count] = b[rp];
                rp++;
                count++;
            }
        } else if(rp>right && lp<=mid){
            while (lp<=mid){
                a[count] = b[lp];
                lp++;
                count++;
            }
        }

        copy(a,b,left,right);
        return numberOfInversions;


    }


    private static void swap(int[] b, int x, int y) {
        int temp = b[x];
        b[x] = b[y];
        b[y]= temp;

    }


    private static void copy (int[] a, int[] b, int l, int r) {

        for(int i = l ;i<=r;i++) {
            b[i] = a[i];

        }


    }

    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);
      //  int n = scanner.nextInt();
        int[] a = {2,3,9,2,9};
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
        int[] b = new int[5];


        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}

