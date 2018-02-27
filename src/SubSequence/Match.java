package SubSequence;

import java.util.*;

public class Match {

   Map<Integer,Integer> index = new TreeMap<>();

    public void match(String text,String pattern){
        Map<Character,List<Integer>> map = new HashMap<>();
        int count = -1;
        for(Character c : text.toCharArray()){
            count++;
            if(map.containsKey(c)){
                map.get(c).add(count);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(count);
                 map.put(c,list);
            }
        }


       for(int i = 0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
               i = i+ print(map,pattern,i,text);
            }
       }

        System.out.println(index.toString());
        subPattern(pattern,text);

    }


    public int print(Map<Character,List<Integer>> map,String pattern,int i,String text){
        int count = 0;
        int patternCount = i;
        List<Integer> val = map.get(pattern.charAt(i));



        for(int j = 0;j<val.size();j++) {
            int tempCount = -1;
            int textCount =  val.get(j);

            while (patternCount < pattern.length() && textCount<text.length()) {
               if(pattern.charAt(patternCount) == text.charAt(textCount)){
                   tempCount++;
                   textCount++;
                   patternCount++;
               }else{
                   break;
               }
            }

            if(count<tempCount){
                count = tempCount;
            }

            patternCount = i;



        }


        index.put(i,count);
        return count;


    }


    public void subPattern(String pattern,String text){

        List<String> subPat = new ArrayList<>();


        for(Map.Entry<Integer,Integer> entry : index.entrySet() ){
            if(entry.getValue()!=0) {
                subPat.add(pattern.substring(entry.getKey(), entry.getKey() + entry.getValue()+1));
            }else{
                subPat.add(pattern.substring(entry.getKey(),entry.getKey()+1));
            }
        }

        System.out.println(subPat);

        for(int i = 0;i<subPat.size();i++){
            if(text.startsWith(subPat.get(i))){
               find(subPat.get(i),subPat,i+1,text);
            }
        }

    }


    public void find(String str, List<String> subPat,int i,String text){
        if(text.equalsIgnoreCase(str)){
            System.out.println("found a match");
        }else {

            if(i<subPat.size()){
                String temp  = str + subPat.get(i);
               if(text.startsWith(temp)){
                   str = temp;
                   i++;
                   find(str,subPat,i,text);
               }else{
                   i++;
                   find(str,subPat,i,text);
               }
            }

        }
    }

}


