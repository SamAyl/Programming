package sg_group5.CountVowels.ReverseStack;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        print(stack);
        reverseStack(stack);
        print(stack);
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack==null || stack.isEmpty()){
            return;
        }
        Queue<Integer> queue = new LinkedList<>();

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }

        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }
    }


    public static void print(Stack<Integer> stack){
        Iterator<Integer> it = stack.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
