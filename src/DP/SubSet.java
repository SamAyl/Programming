package DP;


import java.util.*;

public class SubSet {
    static List<Character> list = new ArrayList<>();
    static Map<Character, List<String>> map = new LinkedHashMap<>();

    public static void print(List<Character> list, StringBuilder sb, int size, int count, Character ch) {
        if (sb.length() == size) {
            System.out.println(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;

        }

        while (count < list.size()) {
            sb.append(list.get(count));
            print(list, sb, size, count + 1, ch);
            count++;
        }



        sb.deleteCharAt(sb.length()-1);

    }


    public static void main(String[] args){
        list.add('a');
         map.put('a',new ArrayList<>());
        list.add('b');
         map.put('b',new ArrayList<>());
        list.add('e');
        List<String> list1 = new ArrayList<>();
        list1.add("e");
         map.put('e',list1);

        for(int j = 0;j<=list.size()-1;j++) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(j).toString());
            for(int i = 1;i<=list.size();i++) {
                print(list, sb, i, j + 1,list.get(j));
               sb.append(list.get(j).toString());
            }

        }




        printFromCache();
        System.out.println(map);

    }


    public static void printFromCache(){
        for(int i = map.size()-2;i>=0;i--){
            List<String> list1 = map.get(list.get(i+1));
            List<String> tempList = map.get(list.get(i));
            add(list1,tempList,list.get(i));

        }


    }

    public static void add(List<String> list,List<String> tempList,Character ch){
        tempList.add(ch.toString());
        for(int i  = 0;i<list.size();i++){
            String s = list.get(i);
            s = ch.toString() + s;
            tempList.add(s);
        }

        tempList.addAll(list);
    }


}
