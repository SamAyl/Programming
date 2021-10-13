package ByteByByte;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

   static Map<Integer,Object[]> map;

   // static LinkedList<TimeObject> ll = new LinkedList<>();
    static int totSize = 0;
    static int totCapacity = 0;
    static TimeObject head;
    static TimeObject curr;


    public static void main(String[] args) {
        map = new HashMap<>(10+1,1);
        totCapacity = 10;


        put(7,28);
        put(7,1);
        put(8,15);
        System.out.println(get(6));
        put(10,27);
        put(8,10);
        System.out.println(get(8));
        put(6,29);
        put(1,9);
        System.out.println(get(6));
        put(10,7);
        System.out.println(get(1));
        System.out.println(get(2));
        System.out.println(get(13));
        put(8,30);
        put(1,5);
        System.out.println(get(1));
        put(13,2);
        System.out.println(get(12));

     //   System.out.println(get(2));

    }

    public  LRUCache(int capacity) {
        map = new HashMap<>(capacity+1,1);
        totCapacity = capacity;
    }

    public static int get(int key) {
        if(map.containsKey(key)){
            Object[] objects = map.get(key);
            remove((TimeObject)objects[1]);
            ((TimeObject)objects[1]).timeStamp = new Date(System.currentTimeMillis());
            addLast((TimeObject)objects[1]);
            return (Integer)objects[0];
        } else {
            return -1;
        }
    }

    public static void put(int key, int value) {
        if(totSize == 0){
            Object[] objects = new Object[2];
            objects[0] = value;
            objects[1] = new TimeObject(key);

            add((TimeObject)objects[1]);
            map.put(key,objects);
            totSize++;
        } else if(totSize<totCapacity) {
            if(map.containsKey(key)){
                Object[] objects = map.get(key);
                objects[0] = value;
                remove((TimeObject)objects[1]);
                ((TimeObject)objects[1]).timeStamp = new Date(System.currentTimeMillis());
                addLast((TimeObject)objects[1]);
            }else {
                Object[] objects = new Object[2];
                objects[0] = value;
                objects[1] = new TimeObject(key);
                addLast((TimeObject)objects[1]);
                map.put(key,objects);
                totSize++;
            }
        } else {
            if(map.containsKey(key)){
                Object[] objects = map.get(key);
                objects[0] = value;
                remove((TimeObject)objects[1]);
                ((TimeObject)objects[1]).timeStamp = new Date(System.currentTimeMillis());
                addLast((TimeObject)objects[1]);
            } else {
                TimeObject timeObject = removeFirst();
                map.remove(timeObject.key);
                Object[] objects = new Object[2];
                objects[0] = value;
                objects[1] = new TimeObject(key);
                addLast((TimeObject) objects[1]);
                map.put(key, objects);
            }
        }
    }




   static class TimeObject implements Comparable<TimeObject> {
        Integer key;
        Date timeStamp;

        TimeObject prev;
        TimeObject next;

        public TimeObject(int key){
            this.key = key;
            timeStamp = new Date(System.currentTimeMillis());
        }

        public int compareTo(TimeObject o){
            if(this.timeStamp.after(o.timeStamp)){
                return 1;
            } else if(this.timeStamp.before(o.timeStamp)) {
                return -1;
            } else {
               return 0;
            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TimeObject that = (TimeObject) o;
            return key == that.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    public static void add(TimeObject o){
        if(head==null){
            head = o;
            curr = o;
        } else {
            curr.next = o;
            o.prev = curr;
            curr = curr.next;
        }
    }

    public static void remove(TimeObject o){
        TimeObject prev = o.prev;
        TimeObject next = o.next;

        if(prev!=null){
            prev.next = next;
        }

        if(next!=null){
            next.prev = prev;
        } else {
            curr = prev;
        }


        if(head == o){
            head = next;
        }
        o.prev = null;
        o.next =null;


    }



    public static void addLast(TimeObject o) {
        if(head ==null){
            head = o;
            curr = o;
        }else {
            curr.next = o;
            o.prev = curr;
            curr = curr.next;

        }
    }

    public static TimeObject removeFirst(){
       TimeObject head1 = head;
       if(head == curr){
           head = head.next;
           curr = head;
       } else {
           head = head.next;
       }

       head1.prev = null;
       head1.next = null;

       return head1;
    }
}
