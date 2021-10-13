package Educative;

import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str1, int k) {
        char[] ch  = str1.toCharArray();

        int end = 0;
        int str = 0;
        int minSize = Integer.MIN_VALUE;
        Set<Character> uniqueChar = new HashSet<>();
        for(end = 0; end<ch.length; end++){
            uniqueChar.add(ch[end]);
            if(uniqueChar.size()>k){

                int tempEnd = end;
                Set<Character> set = new HashSet<>();
                while(tempEnd>=str) {
                    set.add(ch[tempEnd]);
                    if(set.size()==k) {break;}
                    tempEnd--;

                }
                uniqueChar = set;
                str = tempEnd;
                int tempSize = (end - str) + 1;
                minSize = minSize<tempSize ? tempSize : minSize;


            } else if (uniqueChar.size() == k) {

                int tempSize = (end - str) + 1;
                minSize = minSize<tempSize ? tempSize : minSize;

            }

        }

        int tempSize = (end - str) + 1;
        return minSize < tempSize ? tempSize : minSize;
    }

    public static void main(String[] args) {
          System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));

    StringBuilder sb = new StringBuilder();
    Set<Integer> set = new HashSet<>();
    set.add(1);
    set.add(1);

  // List<Integer> list =  Collections.singletonList(set);

    }
}
