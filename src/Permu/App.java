package Permu;

import java.util.*;

public class App {

    public static void main(String[] args){

        Set<String> result = new HashSet<>();
        findComb(6,0,new StringBuilder(),result);
        System.out.println(result.size());
        List<String> list = new ArrayList<>(result);



    }

     public static void findComb(int n,int index,StringBuilder current,Set<String> result){
        if(index == n){
            String temp = current.toString();
            if(check(temp)) {
                result.add(temp);
            }
            return;
        }

        for(int i = 1;i<=2;i++){
            if(i == 1){
                current.append('(');
            }else if(i == 2){
                current.append(')');
            }

            findComb(n,index+1,current,result);
            current.deleteCharAt(current.length()-1);
        }
     }

     public static boolean check(String temp){
         Stack<Character> stack = new Stack<>();
         for(int j = 0;j<temp.length();j++){
             if(temp.charAt(j)=='('){
                 stack.push(temp.charAt(j));
             }else {
                 if(stack.isEmpty()){
                     return false;
                 }
                 Character ch = stack.pop();
                 if(ch!='('){
                     return false;
                 }
             }
         }

         if(stack.isEmpty()){
             return true;
         }

         return false;
     }
}
