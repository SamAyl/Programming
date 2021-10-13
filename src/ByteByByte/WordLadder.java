package ByteByByte;

import java.util.*;

public class WordLadder {


    public static Set<String> wordsSet = new HashSet<>();

    public static void main(String[] args) {

        String[] word = {"a","b","c"};
        List<List<String>>  result = findLadders("a","c",Arrays.asList(word));
    }

      public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)){
            return new ArrayList<>();
        }


          Set<String> words = new HashSet<>();
          for(String word : wordList){
              words.add(word);
              wordsSet.add(word);
          }

        Map<String,List<String>> grp = new HashMap<>();
        for(String s : wordsSet){
            grp.put(s,new ArrayList<>());
            getAdj(s,wordsSet,grp);
        }

       


      //  makeGraph(beginWord,words,grp);

        int shortestPath = bfs(beginWord,endWord,words,grp);

        List<List<String>> paths = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        dfs(beginWord,endWord,shortestPath,grp,paths,temp,new HashSet<>());
        return paths;
      }

      public static void dfs(String word,String end,int shortestPath,Map<String,List<String>> grp, List<List<String>> paths,List<String> temp,Set<String> visited){

        if(word.equalsIgnoreCase(end)){
            List<String> singlePath = new ArrayList<>();
            singlePath.addAll(temp);
            paths.add(singlePath);
            return;
        }

       // visited = new HashSet<>();
        visited.add(word);
        for(String s : grp.get(word)){
            if(!visited.contains(s)) {
                temp.add(s);
                if (temp.size() <= shortestPath) {
                    dfs(s, end, shortestPath, grp, paths, temp, visited);
                }
                temp.remove(temp.size() - 1);
            }
        }
        visited.remove(word);

      }

      public static int bfs(String str, String end, Set<String> dict,Map<String,List<String>> grp) {

          Queue<String> queue = new LinkedList<>();
          queue.offer(str);
          Set<String> visited = new HashSet<>();
          visited.add(str);

          int level = 0;
          while (!queue.isEmpty()) {
              List<String> words = new ArrayList<>();

              while (!queue.isEmpty()){
                  words.add(queue.poll());
              }

              level++;

              for(String wordOnALevel : words){

                  List<String> adj = grp.get(wordOnALevel);

                  for(String s : adj){
                      if(s.equalsIgnoreCase(end)){
                          return level+1;
                      } else {
                          if(!visited.contains(s)){
                              queue.add(s);
                              visited.add(s);
                          }

                      }
                  }
              }

          }

        return 0;
      }



     static List<String>  getAdj(String word,Set<String> dict,Map<String,List<String>> grp){
        char[] ch = word.toCharArray();

            for (int i = 0; i < ch.length; i++) {
                char original = ch[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    String temp = String.valueOf(ch);
                    if (!word.equalsIgnoreCase(temp) && dict.contains(temp)) {
                        grp.get(word).add(temp);
                    }
                }
                ch[i] = original;
            }


            return grp.get(word);
        }


      
}
