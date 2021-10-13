package Recursion;

import  java.util.*;

public class SubString {

    public static void main(String[] args) {
        String s = "abc";
        List<String> subStrings = new ArrayList<String>();
        generateSubString(s.toCharArray(),0,new StringBuilder(),subStrings);
        for(String s1 : subStrings) {
            System.out.println(s1);
        }
    }


    public static void generateSubString(char[] ch, int index, StringBuilder sb, List<String> res) {
        if (index == ch.length) {
            return;
        }


        sb.append(ch[index]);
        res.add(sb.toString());
        generateSubString(ch,index+1,sb,res);

        if (index!=0) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ch[index]);
            res.add(sb1.toString());
            generateSubString(ch, index + 1, sb1, res);
        }
    }

}
