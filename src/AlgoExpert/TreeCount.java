package AlgoExpert;

public class TreeCount {

    public static void main(String[] args) {
        System.out.println(getTreeCount(3));
    }

    public static int getTreeCount(int n) {
        if (n == 0) {return 0;}
        if (n == 1) {return 1;}

         n--;


        int sum =0;
        for (int i = 0; i<=n;i++) {
            sum+= (getTreeCount(i) + getTreeCount(n-i));
        }



        return sum;
    }
}
