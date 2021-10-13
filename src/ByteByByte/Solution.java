package ByteByByte;

import java.util.*;

class Solution {
    Map<Integer,Set<String>> map = new HashMap<>();

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.removeInvalidParentheses("()())()");
        System.out.println(list.size());
    }

    public List<String> removeInvalidParentheses(String s) {
        removeInvalidBrackets(s.toCharArray(),0,0,0,new StringBuilder());

        Set<Integer> keyset = map.keySet();
        if(keyset == null || keyset.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        int min = Integer.MIN_VALUE;

        for(int i : keyset){
            if(min<i){
                min = i;
            }
        }

        List<String> list = new ArrayList<>();
        list.addAll(map.get(min));

        return list;

    }



    void removeInvalidBrackets(char[] ch, int leftP, int rightP,int index,StringBuilder sb) {
        if(index==ch.length) {
            String ans = "";
            if(leftP == rightP) {
                ans = sb.toString();
                if(map.containsKey(ans.length())) {
                    map.get(ans.length()).add(ans);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(ans);
                    map.put(ans.length(),set);
                }


            }

           return;
        }


        char currentChar;
        if(ch[index] == '('){
            leftP++;
            currentChar = '(';

            if(leftP > rightP){
                sb.append(currentChar);
                removeInvalidBrackets(ch,leftP,rightP,index+1,sb);
                sb.deleteCharAt(sb.length()-1);
                removeInvalidBrackets(ch,leftP-1,rightP,index+1,sb);
            }
        } else if ( ch[index] == ')') {
            rightP++;
            currentChar = ')';

            if(rightP > leftP) {
                removeInvalidBrackets(ch,leftP,rightP-1,index+1,sb);
            } else if (rightP <= leftP) {
                removeInvalidBrackets(ch, leftP, rightP - 1, index + 1, sb);
                sb.append(currentChar);
                removeInvalidBrackets(ch, leftP, rightP, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(ch[index]);
            removeInvalidBrackets(ch,leftP,rightP,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }




    }



}
