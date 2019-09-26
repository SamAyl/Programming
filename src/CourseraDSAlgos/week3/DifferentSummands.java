package CourseraDSAlgos.week3;

import java.util.*;

public class DifferentSummands {

    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();

        summands.add(1);
        if(n==1){
            return summands;
        }
        n--;
        while (n>0){

            int prevPrize = summands.get(summands.size()-1);
            if(n<=prevPrize){
                int index = summands.size()-1;
                int element = prevPrize + n;
                summands.set(index,element);
                break;
            }else {
                summands.add(prevPrize+1);
                n = n - (prevPrize+1);

            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }

}
