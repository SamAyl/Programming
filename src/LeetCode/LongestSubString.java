package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args){
        System.out.println(findSubSequence("ggububgvfk"));
    }


    public static int findSubSequence(String s){

        if(s==null || s.trim().isEmpty()){
            return 0;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        sb.append(s.charAt(0));
        map.put(s.charAt(0),0);
        for(int i = 1;i<s.length();i++){
            if(sb.toString().contains(s.substring(i,i+1)))
            {
                if(count<sb.length()){
                    count = sb.length();
                }
               int end =  map.get(s.charAt(i));
                sb.delete(0,end+1);
                reset(map,end+1);
                i--;

            }else{
                sb.append(s.charAt(i));
                map.put(s.charAt(i),sb.length()-1);
            }

        }

        if(count>sb.length()){
            return count;
        }else {
            return sb.length();
        }



    }

    public static void reset(Map<Character,Integer> map,int key){
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            map.put(entry.getKey(),entry.getValue()-key);
        }
    }


}
