package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args){

        int val = getLongestPalindrom("abcd");
    }


    public static int getLongestPalindrom(String s){
        Map<Character,List<Integer>> map = new HashMap<>();
        makeMap(map,s);
        int maxCount = 1;

        for(Map.Entry<Character,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size()>1){

            }
        }



        return  -1;
    }

    public static void makeMap(Map<Character,List<Integer>> map,String s){
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i)).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i),list);
            }
        }
    }

    public static boolean isPalindrome(String s){
        boolean ispalindrome = true;
        int count=0;
        if(s.length()%2 ==0){
            count = s.length()/2;
        }else {
            count = (s.length()-1)/2;
        }

        for(int i = 0;i<count;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
               return false;
            }
        }


        return ispalindrome;
    }
}
