package Educative;

import java.util.LinkedList;
import java.util.Queue;

public class FindNum {

    public static void main(String[] args) {

       Queue<String> q =  findNum(6);
       find(6);
        System.out.println(q);
    }

    private static Queue<String> findNum(int n){
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();


        int count = 1;


        int numOfDigits = 1;
        q1.add("0");
        q1.add("1");

        numOfDigits++;

        while (count<=n) {

            Queue<String> mainQueue = null;
            Queue<String> nextQueue = null;
            if(q2.isEmpty()){
                mainQueue = q1;
                nextQueue = q2;
            }else {
                mainQueue = q2;
                nextQueue = q1;
            }

            int size = mainQueue.size();
            while (size!=0) {
                String temp = mainQueue.remove();
                String oldTemp = temp;
                StringBuilder sb = new StringBuilder("1");
                if (sb.length() + temp.length() == numOfDigits) {
                    sb.append(temp);
                } else {
                    int diff = numOfDigits - (sb.length() + temp.length());
                    while (diff != 0) {
                        sb.append(0);
                        diff--;
                    }
                    sb.append(temp);
                }

                nextQueue.add(oldTemp);
                mainQueue.add(sb.toString());
                size--;
            }

            nextQueue.addAll(mainQueue);
            mainQueue.clear();
           count+=nextQueue.size();
            numOfDigits++;
        }


        return q1.isEmpty()?q2:q1;

    }

    public static void find(int number){
        String[] result = new String[number];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        for (int i = 0; i < number; i++) {
            result[i] = String.valueOf(queue.remove());
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.add(Integer.parseInt(s1));
            queue.add(Integer.parseInt(s2));
        }


        return;
    }
}

