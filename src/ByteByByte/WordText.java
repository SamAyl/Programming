package ByteByByte;

import java.util.*;

public class WordText {

    public static void main(String[] args) {
        String[] s = {"This", "is", "an", "example", "of", "text", "justification."};
         fullJustify(s,16);
    }

    public static void fullJustify(String[] words, int maxWidth) {
         List<String> list = new ArrayList<>();
         fullJustify(words,maxWidth,0,list);
    }

    public static void fullJustify(String[] words, int maxWidth,int index,List<String> list){

        List<String> wordsForALine = new ArrayList<>();
        int tempWordsCount = 0;
       while (index<words.length){
           if(tempWordsCount+words[index].length() == maxWidth || tempWordsCount+words[index].length()+1 == maxWidth){
               wordsForALine.add(words[index]);
               tempWordsCount = tempWordsCount + words[index].length();
               index++;
               break;
           } else if(tempWordsCount + words[index].length()+1<maxWidth){
               wordsForALine.add(words[index]+" ");
               tempWordsCount+=(words[index].length()+1);
               index++;
           } else {
               String lastWord = wordsForALine.remove(wordsForALine.size()-1);
               lastWord = lastWord.replace(" ","");
               wordsForALine.add(lastWord);
               tempWordsCount--;
               break;
           }
       }

       if(index-1 != words.length-1) {
//           while ((maxWidth - tempWordsCount) % (wordsForALine.size() - 1) != 0) {
//               String wordRemoved = wordsForALine.remove(wordsForALine.size() - 1);
//               index--;
//               tempWordsCount -= wordRemoved.length();
//               String lastWord = wordsForALine.remove(wordsForALine.size() - 1);
//               lastWord = lastWord.replace(" ", "");
//               wordsForALine.add(lastWord);
//               tempWordsCount--;
//           }

           makeSentence(wordsForALine, maxWidth - tempWordsCount, list);
           fullJustify(words, maxWidth, index, list);
       } else {
           makeSentenceNormal(wordsForALine,maxWidth-tempWordsCount,list);
       }


    }

    private static void makeSentence(List<String> words,int num,List<String> list){
        if(words.size() == 1){
            makeSentenceNormal(words,num,list);
            return;
        }

        int numOfSpaces = num/(words.size()-1);
        int leftOverSpace = num%(words.size()-1);

        int spaceCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<words.size();i++) {
            sb.append(words.get(i));

            if (i != words.size() - 1) {
                while (spaceCount < numOfSpaces) {
                    sb.append(" ");
                    spaceCount++;
                }

                if(leftOverSpace!=0){
                    sb.append(" ");
                    leftOverSpace--;
                }
                spaceCount = 0;
            }
        }


        System.out.println("===="+sb.length());

        list.add(sb.toString());
    }


    private static void makeSentenceNormal(List<String> words,int num,List<String> list){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<words.size();i++){
            sb.append(words.get(i));
        }

        int spaceCount = 0;
        while (spaceCount<num){
            sb.append(" ");
            spaceCount++;
        }

        System.out.println("===="+sb.length());

        list.add(sb.toString());
    }
}
