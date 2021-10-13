package ByteByByte.Selection;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("apple");
        dict.add("pine");
        dict.add("pineapple");

        String word = "applepineapple";

        List<List<String>> ans = new ArrayList<>();
        List<String> tempAns = new ArrayList<>();
        findAllPossibleWord(word,0,0,tempAns,ans,dict);

        printAns(ans);
    }


    public static void findAllPossibleWord(String word,int str, int idx, List<String> tempAns, List<List<String>> ans, Set<String> dict) {
        if (str==word.length() || idx == word.length()) {
            return;
        }




        String tempWord = word.substring(str,idx+1);
        if(dict.contains(tempWord)) {
            tempAns.add(tempWord);

            if (idx+1 == word.length()) {
                List<String> temp = new ArrayList<>();
                temp.addAll(tempAns);
                ans.add(temp);
            }
            findAllPossibleWord(word,idx+1,idx+1,tempAns,ans,dict);
            tempAns.remove(tempAns.size()-1);
        }

        findAllPossibleWord(word,str,idx+1,tempAns,ans,dict);
    }


    public static void printAns(List<List<String>> ans) {
        for(List<String> list : ans) {
            for(String word : list) {
                System.out.print(word);
                System.out.print("\t");
            }

            System.out.println();
        }
    }


}
