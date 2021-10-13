package LeetCode;


import java.util.*;

class Solution {

    public static void main(String[] args) {
        String s1 = "abc";

        if(s1.matches("[a-z]*")){
            System.out.println(true);
        }
        Solution s = new Solution();
        s.lastSubstring("xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji");
    }
    public String lastSubstring(String s) {
        char ch = 'a';
        char[] ch1 = s.toCharArray();

        for(Character c : ch1){
            if(c>ch){
                ch = c;
            }
        }


        List<String> list = new ArrayList<>();
        //int prev = -1;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ch) {
              //  if(prev !=-1){
                    list.add(s.substring(i));
                //    prev = i;
//                } else {
//                    prev = i;
//                }
            }
        }

      //  list.add(s.substring(prev,s.length()));


        String prevStr = "";

        for(String s1 : list){
            if(prevStr == ""){
                prevStr = s1;
            }else {
                System.out.println(s1+"     "+prevStr.compareTo(s1));
                if(prevStr.compareTo(s1) <0) {
                    prevStr = s1;
                } //else {
                 //   prevStr = prevStr+s1;
               // }
            }
        }


        return prevStr;
    }
}