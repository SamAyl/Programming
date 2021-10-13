package DailyByte;

import java.util.*;

public class RandomizedCollection {
    LinkedList<Integer> linklist = new LinkedList<>();
    Map<Integer,Integer> list = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (list.containsKey(val)) {
            list.put(val,list.get(val) +1);
            linklist.add(val);
            return false;
        } else {
            linklist.add(val);
            list.put(val,1);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!list.containsKey(val)) {
            return false;
        }

        int c = list.get(val);
        c--;
        if (c == 0) {
            list.remove(val);
        }

        linklist.removeFirstOccurrence(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(linklist.size()));
    }
}
