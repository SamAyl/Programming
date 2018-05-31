package LetterComb;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Map<Integer,List<String>> map = new HashMap<>();

        Set<String> words = new HashSet<>();
        words.add("i");
        words.add("lov");
        words.add("ph");
        words.add("iphone");
        words.add("z");
        words.add("droid");

        String pattern = "ilovedroidiphone";

        Set<String> allWords = findLetterComb(pattern,map);
        Set<String> cmnWords = findCommonWords(words,allWords);
        List<String> cmnWordsList  = new ArrayList<>();
        cmnWordsList.addAll(cmnWords);
        List<String> result = new ArrayList<>();
        permutate(cmnWordsList,0,new StringBuilder(),result,new HashSet<>());
        System.out.println(result);
        System.out.println(result.size());


    }


    public static Set<String> findLetterComb(String s,Map<Integer,List<String>> map){


        for(int i = 0;i<s.length();i++){
            map.put(i,new ArrayList<>());
            for(int j = i;j<s.length();j++) {
                if (map.containsKey(i - 1)) {
                    List<String> temp1 = map.get(i-1);
                    StringBuilder sb = new StringBuilder(temp1.get(j-i+1));
                    sb.deleteCharAt(0);
                    map.get(i).add(sb.toString());
                }else {
                    map.get(i).add(s.substring(i,j+1));
                }
            }
        }

        Set<String> words = new HashSet<>();
        for(Map.Entry<Integer,List<String>> entry : map.entrySet()){
            words.addAll(entry.getValue());
        }

        return words;
    }

    public static Set<String> findCommonWords(Set<String> words,Set<String> allWords){
        Set<String> cmnWords = new HashSet<>();

        for(String s : allWords){
            if(words.contains(s)){
                cmnWords.add(s);
            }
        }

        return cmnWords;
    }


    public static void permutate(List<String> words,int index,StringBuilder sb,List<String> result,Set<String> visited){
        if(index==words.size()){
            String temp = sb.toString();
            result.add(temp);
        }

        for(int i = 0;i<words.size();i++) {
            if (!visited.contains(words.get(i))) {
                sb.append(words.get(i));
                sb.append(" ");
                visited.add(words.get(i));
                permutate(words, index + 1, sb, result, visited);
                visited.remove(words.get(i));
                int strIndex = sb.indexOf(words.get(i) + " ");
                int lastIndex = strIndex +words.get(i).length();
                sb.delete(strIndex,lastIndex+1);
            }
        }
    }


}
