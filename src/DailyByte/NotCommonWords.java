package DailyByte;

import java.util.*;

public class NotCommonWords {

    public static void main(String[] args) {
        String[] sent1  = {};
        String[] sent2 = {};

        PrintUnCommonWords(sent1,sent2);


    }

    public static void PrintUnCommonWords(String[] sent1, String[] sent2) {

        Map<String,Integer> wordCountMap = new HashMap<>();

          wordMap(sent2,wordCountMap);
          wordMap(sent1,wordCountMap);

          Set<String> uncommonWords = new HashSet<>();

          for (Map.Entry<String,Integer> entry : wordCountMap.entrySet()) {
              if(entry.getValue() == 1) {
                  uncommonWords.add(entry.getKey());
              }
          }

          for (String singleUnCommonWord : uncommonWords) {
              System.out.println(singleUnCommonWord);
          }
    }

    public static void wordMap(String[] sent1, Map<String,Integer> wordCountMap) {
        for (String s : sent1) {
            int count = wordCountMap.getOrDefault(s,0);
            if (count == 0) {
                wordCountMap.put(s,1);
            } else {
                wordCountMap.put(s,count+1);
            }
        }
    }
}
