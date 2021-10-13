package AlgoExpert;

import java.util.HashMap;
import java.util.Map;

public class PalindromeCuts {

    public static void main(String[] args) {
        String s = "abb";
        System.out.println(getMinCuts(s.toCharArray(),0)-1);
    }


   static Map<Integer,Integer> map = new HashMap<>();

    public static int getMinCuts(char[] ch, int index) {

        if (index == ch.length) {
            return 0;
        }

        int minCut = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = index; i<ch.length;i++) {
            sb.append(ch[i]);
            if(checkPalindrome(sb.toString())) {

               int minCutFromNextIndex = 0;
               if (map.containsKey(i+1)) {
                   minCutFromNextIndex  = map.get(i+1);
               } else {
                   minCutFromNextIndex = getMinCuts(ch,i+1);
                   map.put(i+1,minCutFromNextIndex);
               }

               int tempCuts  = 1 + minCutFromNextIndex;
               if (tempCuts < minCut) {
                   minCut = tempCuts;
               }
            }


        }

        return minCut;
    }


    public static boolean checkPalindrome(String s) {
        char[] ch = s.toCharArray();

        if (ch.length % 2 == 0) {
            int str  = 0;
            int end = ch.length - 1;

            while (str<end) {
                if (ch[str] == ch[end]) {
                    str++;
                    end--;
                } else {
                    return false;
                }
            }

            return true;
        } else {
            int str = 0;
            int end = ch.length - 1;

            while (str != end) {
                if (ch[str] == ch[end]) {
                    str++;
                    end--;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}
