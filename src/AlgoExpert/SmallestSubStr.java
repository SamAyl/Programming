package AlgoExpert;

import java.util.*;

public class SmallestSubStr {

    public static void main(String[] args) {
        String s = "abcd$ef$axb$c$";
        String p = "$$abf";

        String res = getSmallestSub(s,p);
        System.out.println(res);
    }

    public static String getSmallestSub(String s,String p) {
        StringBuilder sb = new StringBuilder();

        Set<Character> charSet = new HashSet<>();

        Map<Character,Integer> charMap = new HashMap<>();
        Map<Character,Integer> map = new HashMap<>();
        for(Character eachChar : p.toCharArray()) {
            charSet.add(eachChar);
            map.put(eachChar,0);

            if (charMap.containsKey(eachChar)) {
                int count = charMap.get(eachChar);
                charMap.put(eachChar,count+1);
            } else {
                charMap.put(eachChar,1);
            }
        }

        Set<Character> foundCharSet = new HashSet<>();
        int movingPtr = 0;
        List<String> ans = new ArrayList<>();

        while (movingPtr < s.length()) {

            if (charSet.contains(s.charAt(movingPtr))) {
                sb.append(s.charAt(movingPtr));
                int count = map.get(s.charAt(movingPtr));
                map.put(s.charAt(movingPtr),count+1);
                foundCharSet.add(s.charAt(movingPtr));

                if (foundCharSet.size() == charSet.size() && charCountCheck(map,charMap)) {
                    ans.add(sb.toString());

                    boolean nextStringInPattern = true;

                    while (nextStringInPattern) {
                        Character c = sb.charAt(0);
                        int firstCharCount =  map.get(c);

                        firstCharCount--;

                        if (firstCharCount == 0 || charMap.get(c) > firstCharCount) {
                            nextStringInPattern = false;
                            foundCharSet.remove(c);
                            sb = nextSubString(sb.substring(1),charSet);
                        } else {
                            sb = nextSubString(sb.substring(1),charSet);
                            ans.add(sb.toString());
                        }


                        map.put(c,firstCharCount);
                    }

                }


            } else if (sb.length() > 0) {
                sb.append(s.charAt(movingPtr));
            }
                movingPtr ++;

        }

        int minSize = Integer.MAX_VALUE;
        String res = null;
        for (String res1 : ans) {
            if (res1.length() < minSize) {
                res = res1;
                minSize = res1.length();
            }
        }

        return res;

    }


    public static StringBuilder nextSubString(String s,Set<Character> set) {
        int index = 0;
        for(Character c : s.toCharArray()) {
            if (set.contains(c)){
                break;
            }

            index++;
        }

        return new StringBuilder(s.substring(index));
    }

    public static boolean charCountCheck(Map<Character,Integer> map, Map<Character,Integer> refMap) {
         for(Map.Entry<Character,Integer> entry : map.entrySet()) {
             if (entry.getValue() >= refMap.get(entry.getKey())) {
                 continue;
             } else {
                 return false;
             }
         }

         return true;
    }
}
