package CSES;

public class DiceCombination {

    public static void main(String[] args) {
        int v = getCombinations(3,0);
        System.out.println(v);
    }

    public static int getCombinations(int n, int currSum) {
        if (n > 6) {
            return 0;
        }

        int numberOfWays = 0;

        for (int i = 1; i<=6;i++) {
            if (currSum+i < n) {
                numberOfWays += getCombinations(n,currSum+i);
            } else if (currSum +i > n) {
                continue;
            } else {
                numberOfWays+=1;
            }
        }

        return numberOfWays;
    }
}
