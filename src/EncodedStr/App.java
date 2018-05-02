package EncodedStr;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class App {

    public static void main(String[] args){


        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("3[a2[c]]"));
       System.out.println(decodeString("3[a]2[bc]"));

    }

    public static String decodeString(String s){

        Map<Integer,Integer> indexMap = new HashMap<>();
        int j = 0;

        while (j<s.length()){
            if(s.charAt(j)-'0'>=0 && s.charAt(j)-'0'<=9){
                int jump = getIndex(s,j);
                indexMap.put(j,jump);
                j = jump;
            }else {
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        j = 0;
        while (j<s.length()){
            if(indexMap.containsKey(j)){
                String temp = getString(s,j,Character.getNumericValue(s.charAt(j)));
                j = indexMap.get(j);
                sb.append(temp);
            }else {
            sb.append(s.charAt(j));
            j++;
        }
        }

        return sb.toString();
    }

    public static String getString(String s,int index,int count){
        int j = index+2;


        StringBuilder temp = new StringBuilder();

        while(s.charAt(j)!=']'){
            if(s.charAt(j)-'0'>=0 && s.charAt(j)-'0'<=9){
               String s1= getString(s,j,Character.getNumericValue(s.charAt(j)));
               temp.append(s1);
                j+=(2+(s1.length()/Character.getNumericValue(s.charAt(j)))+1);
            }else{
                temp.append(s.charAt(j));
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (count>0){
            sb.append(temp.toString());
            count--;
        }

        return sb.toString();

    }

    public static int getIndex(String s,int index){
        Stack<Character> stack = new Stack<>();
        stack.push('[');
        index+=2;

        while (!stack.isEmpty()){
            if(s.charAt(index)==']'){
               Character ch = stack.pop();
               while (!ch.equals('[')){
                   ch = stack.pop();
               }
               index++;

            }else {
                stack.push(s.charAt(index));
                index++;
            }
        }

        return index;
    }

}
