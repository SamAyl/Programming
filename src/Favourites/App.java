package Favourites;

import java.util.*;


public class App {

    public static void main(String[] args) {
        char[] ch = {'a','b','c','d'};
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        permutate(ch,new HashSet<>(),sb,result);
        System.out.println(result.size());

    }


    public static void permutate(char[] ch,Set<Integer> visited,StringBuilder sb , List<String> result){
        if(sb.length()==ch.length){
            result.add(sb.toString());
            return;
        }

        for(int i = 0;i<ch.length;i++){
            if(!visited.contains(i)) {
                sb.append(ch[i]);
                visited.add(i);
                permutate(ch, visited, sb, result);
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(i);
            }
        }
    }
}
