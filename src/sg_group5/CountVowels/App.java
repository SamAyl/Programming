package sg_group5.CountVowels;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        System.out.println(getVowels("abcadeoui"));

    }

    public static int getVowels(String s){

        if(s==null|| s.isEmpty()){
            return 0;
        }
        char[] ch =  s.toCharArray();
        int count = 0;
//        Set<Character> set = getVowelsSet();
        for(Character c : ch){
            if(c=='a' || c=='e'||c=='i'||c=='o' || c=='u'){
                count++;
            }
        }

        return count;
    }

//    public static Set<Character> getVowelsSet(){
//        Set<Character> set = new HashSet<>();
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');
//
//        return set;
//    }
}
