package Uber_1;

import java.util.*;

public class FracToRecur {

    public static void main(String[] args) {
        String  s = "1212";
        returnShortest(s,1,new StringBuilder(),"1",1);
        String op = "(1222)(122)12(3)";
        for (String s1 : list) {
            System.out.println(s1);
        }
        System.out.println(list.contains(op));
    }

    public static List<String> list = new ArrayList<>();

    public static void returnShortest(String s, int idx, StringBuilder sb, String repeatingSq, int count) {

        if(idx == s.length()) {
            if (count==1) {
                sb.append(repeatingSq);
                list.add(sb.toString());
                sb.delete(sb.length()-repeatingSq.length(),sb.length());
            } else {
                sb.append("(");
                sb.append(repeatingSq);
                sb.append(")");
                list.add(sb.toString());
                sb.delete(sb.length()-repeatingSq.length()-2,sb.length());
            }
        }



            int len = repeatingSq.length();
            if (idx + len -1 < s.length()) {
                String subSq = s.substring(idx,idx+len);
                if (subSq.equalsIgnoreCase(repeatingSq)) {
                    returnShortest(s,idx+len,sb,repeatingSq,count+1);
                    return;
                } else {
                if (count != 1) {
                    sb.append("(");
                    sb.append(repeatingSq);
                    sb.append(")");

                    for(int i = idx+1; i<s.length();i++) {
                        repeatingSq = s.substring(idx,i);
                        returnShortest(s,i,sb,repeatingSq,1);
                    }
                    sb.delete(sb.length()-repeatingSq.length()-2,sb.length());
                } else {
                    sb.append(repeatingSq);
                    for(int i = idx+1; i<s.length();i++) {
                        repeatingSq = s.substring(idx,i);
                        returnShortest(s,i,sb,repeatingSq,1);
                    }
                    sb.delete(sb.length()-repeatingSq.length(),sb.length());
                }
            }
        }

        for(int i = idx+1; i<s.length();i++) {
            repeatingSq = s.substring(idx,i);
            returnShortest(s,i,sb,repeatingSq,1);
        }



    }
}
