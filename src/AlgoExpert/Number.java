package AlgoExpert;

import java.util.*;

public class Number {

    public static void main(String[] args) {

        String[] numbers = {"314159265358979323846",
                "26433",
                "8",
                "3279",
                "314159265",
                "35897932384626433832",
                "79"};

        String pi = "3141592653589793238462643383279";

        Set<String> numb = new HashSet<>();
        for(String s : numbers) {
            numb.add(s);
        }

        int count =  numbersInPi(pi,numb,0);
        System.out.println(count-1);
    }

    public static int numbersInPi(String pi, Set<String> numbers, int idx) {
           if (idx == pi.length()) {
               return 0;
           }


        StringBuilder sb = new StringBuilder();
         int count = -1;
        for(int i = idx; i<pi.length();i++) {
            sb.append(pi.charAt(i));
            if(numbers.contains(sb.toString())) {
                int tempCount = 1;
                int tC = numbersInPi(pi,numbers,i+1);
                if (tC != -1) {
                    tempCount+=tC;
                    if (count == -1) {
                        count = tempCount;
                    } else {
                        count = Math.min(count,tempCount);
                    }
                }
            }
        }

        return count;

    }
}
