package DailyByte;

import java.util.*;

class MovingAverage {


    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

    /** Initialize your data structure here. */
    Queue<Integer> queue = new LinkedList<>();
    int size = 0;
    double currAvg = 0.0;


    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            currAvg = currAvg * size;
            currAvg = currAvg - queue.remove();
            currAvg = currAvg + val;
            currAvg = currAvg / size;

        } else {
            currAvg = currAvg * queue.size();
            currAvg+= val;
            currAvg/=queue.size();
        }

        queue.add(val);

        return currAvg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
