package AlgoExpert;

import java.util.HashMap;
import java.util.*;

public class PrefixTree {

    public static void main(String[] args) {
          String s = "this is a big string";
          TrieNode root = new TrieNode();

          for(int i = 0;i < s.length();i++) {
              addToNode(s,i,root);
          }

          List<String> words = new ArrayList<>();
          words.add("this");
          words.add("yo");
          words.add("is");
          words.add("a");
          words.add("bigger");
          words.add("string");
          words.add("kappa");

          List<Boolean> list = new ArrayList<>();
          for (int i = 0; i < words.size();i++) {
              list.add(wordExist(root,words.get(i),0));
          }

          for (int j = 0; j < list.size(); j++) {
              System.out.println(list.get(j));
          }

    }

    public static void addToNode(String s, int index, TrieNode root) {
        if (index == s.length()) {
            return;
        }

        if (root.charMap.containsKey(s.charAt(index))) {
            addToNode(s,index+1,root.charMap.get(s.charAt(index)));
        } else {
            root.charMap.put(s.charAt(index),new TrieNode());
            addToNode(s,index+1,root.charMap.get(s.charAt(index)));
        }
    }

    public static boolean wordExist(TrieNode root, String word, int index) {
        if (index == word.length()) {
            return true;
        }

         if (root.charMap.containsKey(word.charAt(index))) {
             return (true && wordExist(root.charMap.get(word.charAt(index)), word, index+1));
         } else {
             return false;
         }
    }
}

class TrieNode{
    Map<Character, TrieNode> charMap = new HashMap<>();
    boolean EOF = false;
}
