package MCA2;

import java.util.HashMap;
import java.util.Map;

public class LongestSubSeq {

    public static void main(String[] args) {
        String word = "abcbcdefgjk";
        String longNonRepeatingSubSeq = getLongSubSeq(word);
        System.out.println(longNonRepeatingSubSeq);
    }

    public static String getLongSubSeq(String word) {

        if(word==null || word.length()==0){
            return null;
        }

        if(word.length()==1){
            return word;
        }

        //Basically, am having two pointers because I need a substring and for that I need str pointer and end pointer
        int strIndex = 0;
        int movIndex = 1;

        Map<Character,Integer> visitedCharIndexMap = new HashMap<>();
        visitedCharIndexMap.put(word.charAt(strIndex),0);

        int[] subSeqMetaDate = new int[3];

        while (movIndex<word.length()) {
           if(visitedCharIndexMap.containsKey(word.charAt(movIndex))){
               int jumpIndex = visitedCharIndexMap.get(word.charAt(movIndex));
               compareAndEditValues(subSeqMetaDate,strIndex,movIndex);
               strIndex = jumpIndex+1;
               visitedCharIndexMap.put(word.charAt(movIndex),movIndex);
               movIndex++;

           } else {
               visitedCharIndexMap.put(word.charAt(movIndex),movIndex);
               movIndex++;
           }

        }

        compareAndEditValues(subSeqMetaDate,strIndex,movIndex);

        return word.substring(subSeqMetaDate[1],subSeqMetaDate[2]+1);

    }


    private static void compareAndEditValues(int[] subSeqMetaDate,int strIndex,int movIndex) {
        int currentMaxLength = subSeqMetaDate[0];
        if(currentMaxLength< (movIndex-1 - strIndex + 1)){
            subSeqMetaDate[0] = movIndex-strIndex;
            subSeqMetaDate[1] = strIndex;
            subSeqMetaDate[2] = movIndex-1;
        }
    }
}
