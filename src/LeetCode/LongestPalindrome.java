package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args){

        System.out.println(getLongestPalindrom("abcd"));
    }


    public static String getLongestPalindrom(String s){
        Map<Integer,List<Boolean>> map = new HashMap<>();
        int index = 0;
        int maxLength =0;
        setMap(map,s);
        int tempLength1 = getMaxLength(map.get(0));
        if(maxLength<tempLength1){
            maxLength = tempLength1;
            index = 0;
        }
        for(int i = 1;i<s.length();i++){
            List<Boolean> list = new ArrayList<>();
            list.add(true);
            map.put(i,list);
            for(int j =i+1;j<s.length();j++){
                String tempString = s.substring(i,j+1);
                if(map.containsKey(i-1)){

                    boolean palindrome = map.get(i-1).get(tempString.length());
                    if(!palindrome){
                        boolean palindromeCheck = isPalindrome(tempString);
                        map.get(i).add(palindromeCheck);
                    }else {
                        map.get(i).add(false);
                    }
                }
            }

            int tempLength = getMaxLength(map.get(i));
            if(maxLength<tempLength){
                maxLength = tempLength;
                index = i;
            }

        }
        return s.substring(index,index+maxLength+1);
    }


    public static int getMaxLength(List<Boolean> booleans){
        int maxLength = 0;
        for(int i = booleans.size()-1;i>=0;i--){
            if(booleans.get(i)==true){
                maxLength=i;
                return maxLength;
            }
        }

     return    maxLength;
    }

    public static void setMap(Map<Integer,List<Boolean>> map,String s){
        List<Boolean> list = new ArrayList<>();
        list.add(true);


        for(int i = 1;i<s.length();i++){
            String s1= s.substring(0,i+1);
            list.add(isPalindrome(s1));
        }

        map.put(0,list);
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
