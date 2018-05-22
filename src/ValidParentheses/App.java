package ValidParentheses;

import java.util.*;

public class App {

    public static void main(String[] args) {

        System.out.println(match("()(()"));
    }


    public static int match(String s){
        List<Integer> set = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    int tempIndex = stack.pop();
                    if(s.charAt(tempIndex)=='('){
                        set.add(tempIndex);
                        set.add(i);
                    }
                }

            }
        }


        Collections.sort(set);
        List<Integer> list = set;

        if(list.size()==0){
            return 0;
        }

        if(list.size()==2){
            return 2;
        }

        int tempCount = 1;
        int maxCount = 0;
        for(int i = 1;i<list.size();i++){
            if(list.get(i)-list.get(i-1)==1){
                tempCount++;
            }else {
                maxCount = maxCount>tempCount ? maxCount : tempCount;
                tempCount = 1;
            }
        }


        return maxCount > tempCount ? maxCount : tempCount;

    }
}
