package DailyByte;

public class WhoWins {

    public static void main(String[] args) {
        int[] a = {-1,2,3};

        int player1 = 0;
        int player2 = 0;


        int strIdx = 0;
        int endIdx = a.length-1;

        boolean player1Playing = true;

        while (strIdx<=endIdx) {

            if (player1Playing) {
                player1 += Math.max(a[strIdx],a[endIdx]);
                if (a[strIdx] > a[endIdx]) {
                    strIdx++;
                } else {
                    endIdx--;
                }
                player1Playing = false;
            } else {
                player2+=Math.max(a[strIdx],a[endIdx]);
                if (a[strIdx] > a[endIdx]) {
                    strIdx++;
                } else {
                    endIdx--;
                }
                player1Playing = true;
            }
        }

        if (player1 > player2) {
            System.out.println("Player1 has won");
        } else  if (player2 < player1) {
            System.out.println("Player2 has won");
        } else {
            System.out.println("There is a draw");
        }
    }
}
