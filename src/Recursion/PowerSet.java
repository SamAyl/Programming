package Recursion;

import java.util.*;

public class PowerSet {

    public static void main(String[] args) {
        Character[] ch = {'1', '2', '3'};
        List<String> powerSet = new ArrayList<>();
        getPSet(ch,0,powerSet,new StringBuilder());
        for(String s : powerSet) {
            System.out.println(s);
        }
    }

    //Iterative + Recursion
    public static void getPSet(Character[] ch, int index, List<String> result, StringBuilder temp) {
        if(index == ch.length) {
            return;
        }

        for(int i = index; i<ch.length; i++) {
            temp.append(ch[i]);
            result.add(temp.toString());
            getPSet(ch,i+1,result,temp);
            temp.deleteCharAt(temp.length()-1);

        }

    }


    //Iterative -> Recursion + Recursion
    public static void getPSetNew(Character[] ch, int index, List<String> result, StringBuilder temp) {
        if(index == ch.length) {
            return;
        }

        for(int i = index; i<ch.length; i++) {
            temp.append(ch[i]);
            result.add(temp.toString());
            getPSetNew(ch,i+1,result,temp);
            temp.deleteCharAt(temp.length()-1);

        }

    }
}
