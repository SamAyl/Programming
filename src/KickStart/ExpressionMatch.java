package KickStart;

import java.util.*;

public class ExpressionMatch {

    public static void main(String[] args) {

        bracketMatch(")((())");
    }

    public static void bracketMatch(String s){
        char[] ch = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();

        for(int i = 0;i<ch.length;i++){

            Character temp = ch[i];
            if(temp=='('){
                stack.push(temp);
                index.push(i);
            }else{
                if(!stack.isEmpty()){
                    if(stack.peek()=='('){
                        stack.pop();
                        index.pop();
                    }
                }else {
                    index.push(i);
                }
            }
        }


        if(index.isEmpty()){
            System.out.println("Index  "+ 0);
        }else {

            int[] indexPos = new int[ch.length];
            Arrays.fill(indexPos,1);

            while (!index.isEmpty()){
                indexPos[index.pop()]=0;
            }

            int maxIndex = -1;
            int maxLength = Integer.MIN_VALUE;

            int count = 0;

            while (count<indexPos.length){
                if(indexPos[count]==0){
                    count++;
                }else {
                    int startIndex = count;
                    int size = 0;
                    while (count<indexPos.length && indexPos[count]!=0){
                        count++;
                        size++;
                    }

                    if(maxLength<size){
                        maxIndex = startIndex;
                    }
                }
            }
//            List<Integer> list = new ArrayList<>();
//            list.addAll(index);
//
//            int maxDiff = Integer.MIN_VALUE;
//            int indexPosition = -1;
//            for(int i = 0;i<list.size()-1;i++){
//
//                int tempIndex = list.get(i);
//                int nextIndex = list.get(i+1);
//
//                if(nextIndex-tempIndex > maxDiff){
//                    indexPosition = tempIndex;
//                    maxDiff = nextIndex-tempIndex;
//                }
//            }
//
            System.out.println("Index  " + maxIndex);
        }

    }
}
