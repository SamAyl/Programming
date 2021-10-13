package LeetCode;

import java.util.*;


class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");

        String sentence = "the cattle was rattled by the battery";

        System.out.println(s.replaceWords(dict,sentence));
    }
    public String replaceWords(List<String> dict, String sentence) {


        Node root = new Node('$');
        for(String word : dict) {
            formTrie(root,word,0);
        }


        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for(String w : words) {
            if(root.childMap.containsKey(w.charAt(0))){
              String ans =   getRoot(root,w,0,new StringBuilder());
              if (ans != null) {
                  sb.append(ans);
              } else {
                  sb.append(w);
              }
                sb.append(" ");
            } else {
                sb.append(w);
                sb.append(" ");
            }
        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }


    public String getRoot(Node root,String word, int index, StringBuilder sb) {



        Node n = root.childMap.get(word.charAt(index));
        if(n == null) {
            return null;
        }
        sb.append(n.c);
        if (n.eof == true) {
            return sb.toString();
        } else {
            return getRoot(n, word, index+1, sb);
        }
    }




    public void formTrie(Node root, String word, int index) {

        if (index == word.length()) {
            return;
        }

        char c = word.charAt(index);

        if (root.childMap.containsKey(c)) {
            if (index == word.length()-1) {
                root.childMap.get(c).eof = true;
                return;
            } else {
                formTrie(root.childMap.get(c), word,index+1);
            }
        } else {
            Node child = new Node(word.charAt(index));
            root.childMap.put(c,child);

            if(index == word.length()-1) {
                root.childMap.get(c).eof = true;
                return;
            } else {
                formTrie(root.childMap.get(c),word,index+1);
            }

        }

    }



}

class Node {
    public char c;
    public Map<Character,Node> childMap = new HashMap<>();
    public boolean eof;

    Node (char c) {
        this.c = c;
    }
}
