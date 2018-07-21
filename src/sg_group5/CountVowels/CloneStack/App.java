package sg_group5.CountVowels.CloneStack;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(3);
        stk.push(4);
        Stack<Integer> result = clone(stk);

        Iterator<Integer> it = result.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    public static Stack<Integer> clone(Stack<Integer> stack){
        Deque<Integer> deque = new LinkedList<>();
        while (!stack.isEmpty()){
            deque.add(stack.pop());
        }

        Stack<Integer> cloneStack = new Stack<>();

        while (!deque.isEmpty()){
            int element = deque.removeLast();
            cloneStack.push(element);
            stack.push(element);
        }


        return cloneStack;
    }
 }
