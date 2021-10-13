package DailyByte;

import java.util.*;

class HitCounter {

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(4);
        System.out.println(hitCounter.getHits(300));
       // hitCounter.hit(300);
        System.out.println(hitCounter.getHits(301));
        System.out.println(hitCounter.getHits(302));
        System.out.println(hitCounter.getHits(303));
        System.out.println(hitCounter.getHits(304));
    }

    List<Integer> list = new ArrayList<>();
    Map<Integer,Integer> rollingTimeAndCountMap = new HashMap<>();
    Map<Integer,Integer> timeCountMap = new HashMap<>();

    /** Initialize your data structure here. */
    public HitCounter() {
        rollingTimeAndCountMap.put(0,0);
        list.add(0);
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {

        if (timeCountMap.containsKey(timestamp)) {
            int c = timeCountMap.get(timestamp);
            timeCountMap.put(timestamp,c+1);
        } else {
            timeCountMap.put(timestamp,1);
        }

        if (rollingTimeAndCountMap.containsKey(timestamp)) {
            int count = rollingTimeAndCountMap.get(timestamp);
            rollingTimeAndCountMap.put(timestamp,count+1);
        } else {
            int count = rollingTimeAndCountMap.get(list.get(list.size()-1));
            rollingTimeAndCountMap.put(timestamp,count+1);
        }


        if (list.get(list.size()-1) != timestamp) {
            list.add(timestamp);
        }

    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int minTime = timestamp - 300;
        if (minTime < 0) {
            minTime = 0;

        }

        int actualMinTime = getEqualOrFloor(minTime);
        int actualMaxTime = getEqualOrFloor(timestamp);

        if(actualMinTime != actualMaxTime) {
            return rollingTimeAndCountMap.get(actualMaxTime) - rollingTimeAndCountMap.get(actualMinTime);
        } else {
            return timeCountMap.get(actualMinTime);
        }




    }


    public int getEqualOrFloor(int minTime) {




        int str = 0;
        int end = list.size()-1;


        while(str<=end) {
            int mid = (str+end)/2;
            if (list.get(mid) == minTime) {
                return minTime;
            } else if (list.get(mid) < minTime) {
                str = mid+1;
            } else {
                end = mid -1;
            }
        }

        if (str == list.size()) {
            return list.get(end);
        } else if (end == -1) {
            return list.get(str);
        }


        return list.get(str) <= minTime ? list.get(str) : list.get(end);



    }


    public int getEqualOrCeil(int maxTime) {




        int str = 0;
        int end = list.size()-1;


        while(str<=end) {
            int mid = (str+end)/2;
            if (list.get(mid) == maxTime) {
                return maxTime;
            } else if (list.get(mid) < maxTime) {
                str = mid+1;
            } else {
                end = mid -1;
            }
        }


       if (str == list.size()) {
            return list.get(end);
        } else if (end == -1) {
            return list.get(str);
        }

        return list.get(str) >= maxTime ? str : end;



    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

