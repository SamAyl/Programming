package DP;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Palindrome {

    public static Map<String,Boolean> map = new LinkedHashMap<>();



    public static void main(String[] args){
        print("abacded");
        printSubseq("abcbad");
        System.out.println(map);

    }

    public static void printSubseq(String s){

        /*Getting individual character and their index position */
        Map<Character,List<Integer>> map = new LinkedHashMap<>();
        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i),list);
            }else {
                List<Integer> list1 = map.get(s.charAt(i));
                list1.add(i);
            }
        }


        for(Map.Entry<Character,List<Integer>> entry:map.entrySet()){
            List<Integer> val = entry.getValue();

            if(val.size()!=1){
                for(int j = 0;j<val.size()-1;j++){
                    printPalin(s,val.get(j),val.get(j+1));
                }
            }
        }

    }

    public static void printPalin(String s,int str,int end){
        int left = str;
        int right = end;

        System.out.println(s.substring(str,left+1) + s.substring(right,end+1));

        while (left<right){

            int tempLeft = left+1;
            int tempRight= right-1;
            if(right>tempLeft) {
                System.out.println(s.substring(str,tempLeft+1)+s.substring(right,end+1));
            }


            if(tempRight>tempLeft){
                System.out.println(s.substring(str,left+1)+s.substring(tempRight,end+1));
            }

            left++;
            right--;

            if(left<right){
                boolean check =  palinCheck(s.substring(str,left+1) + s.substring(right,end+1));
                if(check==false){
                    return;
                }
            }





        }
    }


    public static void print(String s){
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            palin(temp);
        }
        for(int j = 1;j<s.length();j++){
            for(int i = j+1;i<s.length();i++){
                String temp = s.substring(j,i+1);
                String secTemp = s.substring(j-1,i+1);
                boolean palinCheck =  map.get(secTemp);
                if(palinCheck == true){
                    map.put(temp,false);
                }else{
                    palin(temp);
                }
            }
        }
    }

    public static void palin(String s){
        if(s.length()%2==0){
            evenPalin(s);
        }else{
            oddPalin(s);
        }
    }

    public static void evenPalin(String s){

        for(int j = 0;j<=s.length()/2-1;j++){
            if(s.charAt(j)!=s.charAt(s.length()-1-j)){
                map.put(s,false);
                return;
            }
        }

        map.put(s,true);
    }

    public static boolean palinCheck(String s){

        for(int j = 0;j<=s.length()/2-1;j++){
            if(s.charAt(j)!=s.charAt(s.length()-1-j)){

                return false;
            }
        }

        return true;

    }

    public static void oddPalin(String s){
        for(int j = 0;j<s.length()/2;j++){
            if(s.charAt(j)!=s.charAt(s.length()-1-j)){
                map.put(s,false);
                return;
            }
        }

        map.put(s,true);
    }
}
