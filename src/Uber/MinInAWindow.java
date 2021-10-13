package Uber;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinInAWindow {

    public static void main(String[] args) {
        int[] a = {-1,1,2,3,-4,-5,-5};
        Deque<Integer> queue = new LinkedList<>();

        queue.add(a[0]);
        for(int i = 1;i<3;i++) {
            if(!queue.isEmpty() && queue.peekLast()<= a[i]) {
                queue.add(a[i]);
            } else {
                while (!queue.isEmpty() && queue.peekLast()>a[i]) {
                    queue.removeLast();
                }
            }

            queue.add(a[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(queue.remove());

        for(int i = 3;i<a.length;i++) {
            if (!queue.isEmpty() && queue.peekLast()<=a[i]){
                queue.add(a[i]);
            } else {
                while (!queue.isEmpty() && queue.peekLast() > a[i]) {
                    queue.removeFirst();
                }
            }

            queue.add(a[i]);
            pq.add(queue.remove());
        }

        System.out.println(pq.remove());
    }
}
