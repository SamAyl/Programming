package KickStart;

import  java.util.*;

public class Distinct2Char {

    public static void main(String[] args) {

        int a = getLongestSubstringLengthExactly2DistinctChars("aaaaaa");
        System.out.println(a);
    }

        // Complete the getLongestSubstringLengthExactly2DistinctChars function below.
        static int getLongestSubstringLengthExactly2DistinctChars(String s) {



            char[] ch = s.toCharArray();

            Set<Character> set = new HashSet<>();
            Character prev = ch[0];
            set.add(prev);

            int index = 0;
            int tempSize = 1;

            int size = 1;

            for (int i = 1; i < ch.length; i++) {
                if (set.contains(ch[i]) && ch[index] == ch[i]) {
                    tempSize++;
                } else if (set.contains(ch[i]) && ch[index] != ch[i]) {
                    index = i;
                    tempSize++;
                } else if (!set.contains(ch[i]) && set.size() < 2) {
                    index = i;
                    tempSize++;
                    set.add(ch[i]);
                } else if (!set.contains(ch[i]) && set.size() == 2) {

                    Character charThatRemains = ch[index];
                    removeTheOther(set, charThatRemains);
                    set.add(ch[i]);
                    if (tempSize > size) {
                        size = tempSize;
                    }
                    tempSize = i - index + 1;
                    index = i;
                }

            }


            if(tempSize> size){
                return tempSize;
            }else{
                return size;
            }
        }

        static void removeTheOther(Set<Character> set,Character charThatRemains){

            Character charThatDeletes = null;
            for(Character c :  set){
                if(c != charThatRemains){
                    charThatDeletes = c;
                }
            }

            set.remove(charThatDeletes);
        }



    }

