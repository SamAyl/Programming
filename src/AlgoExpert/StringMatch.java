package AlgoExpert;

import java.util.*;

public class StringMatch {

    public static void main(String[] args) {
       canConvert("abcdefghijklmnopqrstuvwxyz",
               "bcadefghijklmnopqrstuvwxzz");
    }

    public static boolean canConvert(String str1, String str2) {

        if (str1.equalsIgnoreCase(str2)) return true;

        Map<Character,Character> map = new HashMap<>();
        boolean bool1=  canConvert(str1,str2,0,new StringBuilder(), map);
//        Set<Character> values = new HashSet<>();
//        values.addAll(map.values());
        return bool1 && map.values().size() < 26;
    }

    public static boolean canConvert(String str1, String str2, int idx, StringBuilder sb, Map<Character,Character> map) {
        if (idx == str1.length()) return str2.equalsIgnoreCase(sb.toString());


        char c1 = str1.charAt(idx);
        char c2 = str2.charAt(idx);

        if (map.containsKey(c1) && map.get(c1) == c2) {
            sb.append(c2);
            return canConvert(str1,str2,idx+1,sb,map);
        } else if (!map.containsKey(c1)) {
            sb.append(c2);
            map.put(c1,c2);
            return canConvert(str1,str2,idx+1,sb,map);
        } else if (map.containsKey(c1) && map.get(c1) != c2) {
            return false;
        }


        return true;
    }
}
