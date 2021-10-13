package LeetCode;

import java.util.*;

public class Str {

    static boolean validDict = true;

    public static void main(String[] args) {
       String[] words = {"wrt","wrf","er","ett","rftt"};

       Map<Character,Set<Character>> wordMap = new HashMap<>();
       String prev = "";
       Set<Character> firstChar = new HashSet<>();
       for(String w : words) {
         if (validDict) {

             if (prev.isEmpty()) {
                 addToMap(wordMap, w);
                 prev = w;
                 firstChar.add(prev.charAt(0));
             } else {
                 addToMap(wordMap, prev.charAt(0), w.charAt(0),firstChar);
                 addToMap(wordMap, w);
                 prev = w;
             }
         } else {
             System.out.println("Invalid");
             return;
         }
       }

       Map<Character,Integer> dependencyMap = new HashMap<>();
       getDependencyMap(dependencyMap,wordMap);
       List<Character> list =  dictList(dependencyMap,wordMap);

       for(Character ch : list) {
           System.out.println(ch);
       }
    }


    public static void addToMap(Map<Character,Set<Character>> wordMap, String w){
        char[] ch = w.toCharArray();

        Set<Character> visited = new HashSet<>();
        visited.add(w.charAt(0));
        for(int i = 1;i<w.length();i++) {
            if(ch[i-1] == ch[i]) {
                continue;
            }


            if (visited.contains(ch[i])) {
                validDict = false;
                return;
            }
            if (wordMap.containsKey(ch[i-1])) {
                wordMap.get(ch[i-1]).add(ch[i]);
            } else {
                wordMap.put(ch[i-1], new HashSet<>());
                wordMap.get(ch[i-1]).add(ch[i]);
            }
        }
    }

    public static void addToMap(Map<Character,Set<Character>> wordMap, char parent, char child, Set<Character> firstChar) {


        if (parent == child) {
            firstChar.add(child);
            return;
        }

        if (firstChar.contains(child)) {
            validDict = false;
            return;
        }
        if (wordMap.containsKey(parent)){
            wordMap.get(parent).add(child);
        } else {
            wordMap.put(parent,new HashSet<>());
            wordMap.get(parent).add(child);
        }

        firstChar.add(child);
    }

    public static void getDependencyMap(Map<Character,Integer> dependencyMap, Map<Character,Set<Character>> wordMap) {

        for(Map.Entry<Character,Set<Character>> entry : wordMap.entrySet()) {
            if(!dependencyMap.containsKey(entry.getKey())) {
                dependencyMap.put(entry.getKey(),0);
            }

            for(Character c : entry.getValue()) {
                if (dependencyMap.containsKey(c)) {
                    int count = dependencyMap.get(c);
                    count++;
                    dependencyMap.put(c,count);
                } else {
                    dependencyMap.put(c,1);
                }
            }

        }
    }

    public static List<Character> dictList(Map<Character,Integer> dependencyMap, Map<Character,Set<Character>> wordMap) {
        Queue<Character>  queue = new LinkedList<>();
        List<Character> ans = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry : dependencyMap.entrySet()) {
                if(entry.getValue() == 0){
                    queue.add(entry.getKey());
                }
            }


            while (!queue.isEmpty()) {

                int size = queue.size();

                while (size>0){
                    Character c = queue.poll();
                    ans.add(c);
                    Set<Character> childChar = wordMap.get(c);

                    if (childChar!= null) {
                        for (Character child : childChar) {
                            int count = dependencyMap.get(child);
                            count--;

                            if (count == 0) {
                                queue.add(child);
                            }

                            dependencyMap.put(child, count);
                        }

                    }
                    size--;
                }
            }

            return ans;
    }
}
