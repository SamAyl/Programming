package AlgoExpert;

import java.util.*;

public class LongestSubString {

    public static void main(String[] args) {
       LongestSubString l = new LongestSubString();
        System.out.println(l.longestBalancedSubstring(")())(())((((((()((()"));
    }


        int longestSubString = Integer.MIN_VALUE;

        public int longestBalancedSubstring(String string) {

            if (string.isEmpty() || string.length()  == 1){ return 0;}
            StringBuilder sb = new StringBuilder();
            longestStr(string.toCharArray(),0, sb,0,0 );
            int length = longestSubString;
            longestSubString = Integer.MIN_VALUE;
            int length1 = getRemainingMax(sb.toString());
            return length > length1 ? length : length1;
        }

        public void longestStr(char[] ch, int idx, StringBuilder tempSubString, int openBrkCount , int closeBrkCount) {
            if (idx == ch.length) {
                return;
            }

            if (ch[idx] == '(' && openBrkCount >= closeBrkCount) {
                tempSubString.append(ch[idx]);
                longestStr(ch,idx+1,tempSubString,openBrkCount+1,closeBrkCount);
            } else if (ch[idx] == ')' && openBrkCount > closeBrkCount) {
                tempSubString.append(ch[idx]);
                longestStr(ch,idx+1, tempSubString,openBrkCount,closeBrkCount+1);
            } else if (ch[idx] ==')' && openBrkCount == closeBrkCount) {
                if (longestSubString < tempSubString.length()) {
                    longestSubString = tempSubString.length();
                }

                tempSubString.delete(0,tempSubString.length());
                longestStr(ch,idx+1,tempSubString,0,0);
            }

            return;
        }


        public int getRemainingMax(String s) {
            char[] ch = s.toCharArray();
            Stack<Character> stk = new Stack<>();
            Stack<Integer> stk1 = new Stack<>();


            for(int i = 0;i<ch.length;i++) {
                if (ch[i] == '(') {
                    stk.push('(');
                    stk1.push(i);
                } else {

                    stk.pop();
                    stk1.pop();
                }
            }

            Set<Integer> indices = new HashSet<>();
            indices.addAll(stk1);

            int count = 0;
            int tempCount = 0;
            for(int i = 0;i<ch.length;i++) {
                if (indices.contains(i)) {
                    if (count < tempCount) {
                        count = tempCount;
                    }
                    tempCount = 0;
                } else {
                    tempCount++;
                }


            }

            return count > tempCount ? count : tempCount;
        }
    }


