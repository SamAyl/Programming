package KickStart;

import java.util.*;

public class Check {

    public static void main(String[] args) {
        char ch = 'i';

     //   String[] ans = wordBreak("applepie",{"app","","",""})
    }


    static String[] wordBreak(String strWord, String[] strDict) {


        char[] ch = strWord.toCharArray();

        Map<Integer, List<String>> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add(Character.toString(ch[ch.length - 1]));
        map.put(ch.length - 1, list);


        for (int i = ch.length - 2; i >= 0; i--) {
            List<String> temp = map.get(i + 1);
            List<String> temp1 = new ArrayList<>();


            for (String s : temp) {
                temp1.add(Character.toString(ch[i]) + s);
                temp1.add(Character.toString(ch[i]) + " " + s);
            }


            map.put(i, temp1);

        }

        Set<String> dict = new HashSet<>();
        for (String s2 : strDict) {
            dict.add(s2);
        }

        List<String> answers = new ArrayList<>();
        List<String> finalString = map.get(0);

        for (String s1 : finalString) {
            if (dict.contains(s1)) {
                answers.add(s1);
            }
        }

        return answers.toArray(new String[0]);
    }

}