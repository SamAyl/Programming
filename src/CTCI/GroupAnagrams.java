package CTCI;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("cba");
        list.add("bca");
        list.add("df");
        list.add("fd");
        list.add("fed");

        List<String> result = getSortedAnagram(list);

        for(String s : result){
            System.out.println(s);
        }
    }

    public static List<String> getSortedAnagram(List<String> names){
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<names.size();i++) {
            String sortedString = getSortedString(names.get(i));
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sortedString, list);
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> entry : map.entrySet()){
            for(int i : entry.getValue()){
                result.add(names.get(i));
            }
        }

        return result;
    }

    public static String getSortedString(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder();
        for(char c : ch){
            sb.append(c);
        }

        return sb.toString();

    }


}
