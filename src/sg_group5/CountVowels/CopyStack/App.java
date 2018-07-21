package sg_group5.CountVowels.CopyStack;

import java.util.*;

public class App
{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);



        reverse(stack);

        Iterator<Integer> it  = stack.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    public static void reverse(Stack<Integer> stack){
        Queue<Integer> queue = new LinkedList<>();
        while (!stack.isEmpty()){
           queue.add(stack.pop());
        }

        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }
    }
}
