package LongestSubStrPalindrome;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    public static void main(String[] args){
        String s = "cbbd";

        Map<String,Boolean>  map = new LinkedHashMap<>();

        for(int i = 1;i<s.length();i++){
            String temp = s.substring(0,i+1);
            map.put(temp,checkPalind(temp));
        }

        check(s,1,map);
        System.out.println(map.toString());
    }


    public static void check(String s,int index,Map<String,Boolean> map){

        if(index>=s.length()){
            return ;
        }
      for(int i = index+1;i<s.length();i++){
          String temp = s.substring(index,i+1);
          boolean palinCheck = map.get(s.charAt(index-1)+temp);
          if(palinCheck){
              map.put(temp,false);
          }else {
              map.put(temp,checkPalind(temp));
          }

      }
      index++;
      check(s,index,map);

      return;
    }


    public static boolean checkPalind(String temp){

        char[] arr = temp.toCharArray();
         boolean palindrome=true;
          int length = arr.length/2;
          length--;
          for(int i = 0;i<=length;i++) {
              if (arr[i] != arr[arr.length - 1 - i]) {
                  return false;
              }

          }

        return palindrome;
    }
}
