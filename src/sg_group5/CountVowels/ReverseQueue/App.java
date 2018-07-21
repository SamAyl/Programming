package sg_group5.CountVowels.ReverseQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        print(queue);
        reverse(queue);
        print(queue);
    }

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }

    public static void print(Queue<Integer> queue){
        Iterator<Integer> it = queue.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
