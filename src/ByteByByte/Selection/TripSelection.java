package ByteByByte.Selection;

public class TripSelection {

    public static void main(String[] args) {
        int[] ny = {1,2,3,4,4,3,2,1};
        int[] bo = {4,3,2,1,1,2,3,4};

        int[] totAmt = {0};

        getMaxTrip(ny,bo,0,0,false,totAmt);
        totAmt[0] = 0;
        getMaxTrip(ny,bo,0,0,true,totAmt);
        System.out.println(maxAns);
    }

    private static int maxAns = Integer.MIN_VALUE;
    public static void getMaxTrip(int[] ny, int[] bo, int idx1, int idx2, boolean nyk ,int[] tot) {

        if (idx1 + idx2 == 2* ny.length) {
            maxAns = Math.max(maxAns, tot[0]);
            return;
        }


        if (nyk) {
            tot[0] += ny[idx1];
            getMaxTrip(ny, bo, idx1 + 1, idx2 + 1, nyk, tot);
            tot[0] -= ny[idx1];


            nyk = false;
            getMaxTrip(ny, bo, idx1 + 1, idx2 + 1, nyk, tot);
            nyk = true;
        } else {
            tot[0] += bo[idx2];
            getMaxTrip(ny, bo, idx1 + 1, idx2 + 1, nyk, tot);
            tot[0] -= bo[idx2];


            nyk = true;
            getMaxTrip(ny, bo, idx1 + 1, idx2 + 1, nyk, tot);
            nyk = false;
        }

    }
}
