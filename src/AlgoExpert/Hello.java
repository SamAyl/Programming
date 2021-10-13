package AlgoExpert;

import java.util.*;

public class Hello {

    public static void main(String[] args) {
        Hello h = new Hello();
      int ans =    h.strobogrammaticInRange("0","100");
        System.out.println(ans);
    }

    public int strobogrammaticInRange(String low, String high) {
        if (high.length() < low.length()) {
            return 0;
        }

        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');

        int[] count = new int[1];


        if (low.length() == high.length()) {
            getCount(low,high,low.charAt(0), high.charAt(0),map,count, low.length(),new StringBuilder());
        } else {
            for(int size = low.length() ; size <= high.length(); size++) {
                if (size == low.length()) {
                    getCount(low,high,low.charAt(0),'9',map,count,size, new StringBuilder());
                } else if (size == high.length()) {
                    getCount(low,high,'1',high.charAt(0),map,count,size, new StringBuilder());
                } else {
                    getCount(low,high,'1','9',map,count,size, new StringBuilder());
                }
            }
        }


        return count[0];

    }


    public void getCount(String low, String high, char lowChar, char highChar, Map<Character,Character> map, int[] count, int size,
                         StringBuilder  sb){



            if (sb.length() == high.length() && sb.length() == low.length()) {
                if (high.compareTo(sb.toString()) >= 0 && low.compareTo(sb.toString()) <= 0)
                    check(sb.toString(), count, map);
                return;
            } else if (size == sb.length() && sb.length() == high.length() && sb.length() != low.length()) {
                if (high.compareTo(sb.toString()) >= 0) {
                    check(sb.toString(), count, map);
                }
                return;

            } else if (size == sb.length() && sb.length() == low.length() ) {
                if (low.length() == sb.length() && low.compareTo(sb.toString()) <= 0) {
                    check(sb.toString(), count, map);
                }
                return;
            } else if (size == sb.length() && sb.length() < high.length() && sb.length() > low.length()) {
                if (high.compareTo(sb.toString()) > 0 && low.compareTo(sb.toString()) < 0)
                    check(sb.toString(), count, map);
                return;
            }



        char c1 = high.charAt(0);
        char c2 = low.charAt(0);

        for(Map.Entry<Character,Character> entry : map.entrySet()) {
            char ch = entry.getKey();
            if (sb.length() == 0) {
                if(ch>=lowChar && ch<=highChar) {
                    sb.append(ch);
                    getCount(low,high,lowChar,highChar,map,count,size,sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            } else {
                sb.append(ch);
                getCount(low,high,lowChar,highChar,map,count,size,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }



    public void check(String s, int[] count, Map<Character,Character> map) {

        char[] ch = s.toCharArray();

        int low = 0;
        int high = ch.length -1;

        while (low <= high) {
            char temp = ch[low];
            ch[low] = ch[high];
            ch[high] = temp;

            ch[low] = map.get(ch[low]);
            if (low != high) {
                ch[high] = map.get(ch[high]);
            }

            low++;
            high--;

        }

        String ans = new String(ch);
        if (ans.equalsIgnoreCase(s)) {
            count[0]+=1;
        }

    }


}
