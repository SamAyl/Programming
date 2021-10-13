package Google;


import java.util.*;
import java.util.Collections;

class MedianFinder {

    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> ri = new PriorityQueue<>();
    int count = 0;

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
      //  m.addNum(5);

        System.out.println(m.findMedian());
    }
    public MedianFinder() {

    }

    public void addNum(int num) {
       lo.add(num);



       if(ri.isEmpty() && lo.size()!=1){
           ri.add(lo.poll());
       } else if(!ri.isEmpty()) {
           if (lo.size() - ri.size() == 1) {
               if (lo.peek() > ri.peek()) {
                   int element = ri.poll();
                   ri.add(lo.poll());
                   lo.add(element);
               }
           } else {
                   ri.add(lo.poll());
               }
           }



    }

    public double findMedian() {
           if(lo.size() == ri.size()){
               return (lo.peek() + ri.peek())/2.0;
           } else if(lo.size()>ri.size()){
               return lo.peek();
           } else {
               return ri.peek();
           }
    }
}