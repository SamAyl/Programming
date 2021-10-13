package ByteByByte.Selection;

import java.util.*;

public class StringInterleave {


    public static void main(String[] args) {
        String s0 = "ab";
        String s1 = "cd";

        List<String> ans = new ArrayList<>();
        interleave(s0,s1,0,0,new StringBuilder(),ans);
        print(ans);
    }

    public static void interleave(String s1, String s2, int idx1, int idx2, StringBuilder sb, List<String> ans) {


        if (s1.length() > idx1) {
            sb.append(s1.charAt(idx1));
            interleave(s1, s2, idx1 + 1, idx2, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }

        if (s2.length() > idx2) {
            sb.append(s2.charAt(idx2));
            interleave(s1,s2,idx1,idx2+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }

        if (idx1 == s1.length() && idx2 == s2.length()) {
            ans.add(sb.toString());
            return;
        }

    }

    public static void print(List<String> ans) {
        for(String singleAns : ans) {
            System.out.println(singleAns);
        }
    }
}
