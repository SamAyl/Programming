package MCA2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {

        NodeTry a = new NodeTry('a');
        NodeTry a1 = new NodeTry('a');


        List<String> list = new ArrayList<>();
        list.add("Isa");
        list.add("Ur");
        list.add("Ilove");
        list.add("Partha");

        NodeTry root = new NodeTry('*');

        create(list,root);

        String word = "Uri";
        System.out.println(exist("Partho",root,0));

     //   System.out.println(root);;


        System.currentTimeMillis();


    }


    public static void create(List<String> word, NodeTry root){
        for(String s : word) {
            insert(s,root,0);
        }
    }


    public static void insert(String s, NodeTry root,int charIndex) {
        if(s==null){
            return;
        }
            if(root.getMap().containsKey(s.charAt(charIndex))){
                if(s.length() == charIndex+1){
                       root.getMap().get(s.charAt(charIndex)).endOFWord = true;
                } else {
                    insert(s,root.getMap().get(s.charAt(charIndex)),charIndex+1);
                }
            } else {
                NodeTry temp = new NodeTry(s.charAt(charIndex));
                 if(s.length() == charIndex + 1) {
                     temp.endOFWord = true;
                     root.getMap().put(s.charAt(charIndex),temp);
                 } else {
                     root.getMap().put(s.charAt(charIndex),temp);
                     insert(s,root.getMap().get(s.charAt(charIndex)),charIndex+1);
                 }
            }

    }

    public static boolean exist(String w, NodeTry root,int charIndex) {

             if(root.getMap().containsKey(w.charAt(charIndex))){
                 if(w.length()==charIndex+1){
                     return true;
                 }else {
                     return exist(w,root.getMap().get(w.charAt(charIndex)),charIndex+1);
                 }
             } else {
                 return false;
             }
    }
}




class NodeTry {
    char c;
    Map<Character,NodeTry> map = new HashMap<>();
    boolean endOFWord;
    boolean rootNode;

    public NodeTry(char c){
        this.c = c;
        rootNode = false;
    }

    @Override
    public int  hashCode(){
        return c;
    }

    public boolean equals(Object o){
        if(o==null || !(o instanceof NodeTry)){
            return false;
        } else if( o == this) {
            return true;
        } else {
             return this.hashCode()== o.hashCode() ? true :  false;
        }
    }


    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public Map<Character, NodeTry> getMap() {
        return map;
    }

    public void setMap(Map<Character, NodeTry> map) {
        this.map = map;
    }

    public boolean isEndOFWord() {
        return endOFWord;
    }

    public void setEndOFWord(boolean endOFWord) {
        this.endOFWord = endOFWord;
    }

    public boolean isRootNode() {
        return rootNode;
    }

    public void setRootNode(boolean rootNode) {
        this.rootNode = rootNode;
    }
}
