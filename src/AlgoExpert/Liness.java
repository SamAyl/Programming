package AlgoExpert;

import java.util.*;

public class Liness {

    public static void main(String[] args) {
        String s = "qkz";
        Set<String> set = new HashSet<>(Arrays.asList("q","z","k"));

       findMatch(s,0,set,new StringBuilder(),new StringBuilder());
       for(String s1 : ans) {
           System.out.println(s1);
       }
    }

    public static Set<String> ans = new HashSet<>();

    public static void findMatch(String s, int idx, Set<String> words, StringBuilder sb, StringBuilder prev) {
       if (idx == s.length()) {
           sb.append(prev);
           ans.add(sb.toString());
           sb.delete(sb.length()-prev.length(),sb.length());
           return;
       }


        prev.append(s.charAt(idx));
        if (words.contains(prev.toString())) {
            sb.append("+");
            sb.append(prev);
            sb.append("-");
            findMatch(s,idx+1,words,sb,new StringBuilder());
            sb.deleteCharAt(sb.length()-1);
            sb.delete(sb.length()-prev.length(),sb.length());
            sb.deleteCharAt(sb.length()-1);
        }

        findMatch(s,idx+1,words,sb,prev);

        sb.append(prev);
        findMatch(s,idx+1,words,sb,new StringBuilder());
        sb.delete(sb.length()-prev.length(),sb.length());
        prev.deleteCharAt(prev.length()-1);
    }
}
