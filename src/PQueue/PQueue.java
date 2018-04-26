package PQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PQueue {

    public static void main(String[] args){


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        priorityQueue.add(100);
        priorityQueue.add(20);
        priorityQueue.add(30);
        priorityQueue.add(3);

        Iterator<Integer> it = priorityQueue.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(priorityQueue.size());


    }
}
