package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

public class Stringfy {

    public static void main(String[] args) {
        String s = "abcabcd";
        int[] match = new int[s.length()];


        int currP = 1;

        int strP = 0;
        int count = 0;
        while(currP<s.length()) {
            if (s.charAt(currP) != s.charAt(strP)) {
                currP++;
                strP = 0;
                count = 0;
            } else {
                count++;
                match[currP] = count;
                currP++;
                strP++;
            }
        }


        String mainS = "abcabcaaaaabcabcdab";
        List<Integer> list = new ArrayList<>();


        int strIdx = 0;
        int ptnIdx = 0;

        while (strIdx < mainS.length()) {


            if (mainS.charAt(strIdx)  == s.charAt(ptnIdx)) {
                int[] nextIdxs = check(mainS,s,strIdx,ptnIdx,match,list);
                strIdx = nextIdxs[0];
                ptnIdx = nextIdxs[1];
            } else {
                strIdx++;
                ptnIdx=0;
            }
        }


        for(int i = 0; i<list.size();i++) {
            System.out.println(list.get(i));
        }

    }


    public static int[] check(String s, String p, int i, int j,int[] match,List<Integer> list) {

        int strIndex = i;
        while (i< s.length() && j< p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }

        if (j==p.length()) {
            list.add(strIndex);
            int[] ans = new int[2];
            ans[0] = i;
            ans[1] = 0;
            return ans;
        } else {
            int[] ans = new int[2];
            ans[0] = i;
            ans[1] = match[j-1];
            return ans;
        }
    }

}
