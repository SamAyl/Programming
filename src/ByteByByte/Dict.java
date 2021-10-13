package ByteByByte;

import java.util.*;

public class Dict {


    public static void main(String[] args) {
      Dict d = new Dict();
      Set<String> words = new HashSet<>();

      words.addAll(Arrays.asList("can", "canes", "serene", "rene", "sam"));
      List<String> ans = d.returnPossibleWords("can s r n ",words);
        System.out.println(ans.size());
    }


    List<String> possibleSentences = new ArrayList<>();


    List<String> returnPossibleWords(String s,Set<String> words){
        getWords(s.toCharArray(),0,words,new StringBuilder(),new StringBuilder());
        return possibleSentences;
    }

    public void getWords(char[] ch, int index, Set<String> words,StringBuilder sb,StringBuilder sentence){
         if(index == ch.length){
             if(words.contains(sb.toString())){
                 sentence.append(sb.toString());
                 possibleSentences.add(sentence.toString());
                 sentence.delete(sentence.length()-sb.length(),sentence.length());
             }

             return;
         }



        if(ch[index] == ' '){
            if(words.contains(sb.toString())){
                sentence.append(sb.toString());
                sentence.append(" ");
                getWords(ch,index+1,words,new StringBuilder(),sentence);
                sentence.deleteCharAt(sentence.length()-1);
                sentence.delete((sentence.length()-sb.length()),sentence.length());
            }

                sb.append('e');
                getWords(ch,index+1,words,sb,sentence);
                sb.deleteCharAt(sb.length()-1);

        } else {
            sb.append(ch[index]);
            getWords(ch,index+1,words,sb,sentence);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
