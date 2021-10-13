package AlgoExpert;

import java.util.*;

public class Buildings {

    public static void main(String[] arf) {
        String[] reqs = {"gym", "office", "school", "store"};
        List<Map<String,Boolean>> blocks = new ArrayList<>();

        Map<String,Boolean> map1 = new HashMap<>();
        Map<String,Boolean> map2 = new HashMap<>();
        Map<String,Boolean> map3 = new HashMap<>();
        Map<String,Boolean> map4 = new HashMap<>();
        Map<String,Boolean> map5 = new HashMap<>();

//
//        {"gym": false, "office": true, "school": true, "store": false},
//        {"gym": true, "office": false, "school": false, "store": false},
//        {"gym": true, "office": false, "school": true, "store": false},
//        {"gym": false, "office": false, "school": true, "store": false},
//        {"gym": false, "office": false, "school": true, "store": true}
        map1.put("gym", false);
        map1.put("office",true);
        map1.put("school",true);
        map1.put("store",false);

        map2.put("gym", true);
        map2.put("office",false);
        map2.put("school", false);
        map2.put("store",false);

        map3.put("gym", true);
        map3.put("office",false);
        map3.put("school",true);
        map3.put("store",false);

        map4.put("gym",false);
        map4.put("office",false);
        map4.put("school", true);
        map4.put("store", false);

        map5.put("gym", false);
        map5.put("office",false);
        map5.put("school", true);
        map5.put("store", true);

       blocks.add(map1);
       blocks.add(map2);
       blocks.add(map3);
       blocks.add(map4);
       blocks.add(map5);


        System.out.println(apartmentHunting(blocks,reqs));
    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        Map<Integer,Integer> mapOfAvailabilityAndIndex = new HashMap<>();


        List<Set<String>> blockSet = new ArrayList<>();
        for(Map<String,Boolean> block : blocks) {
            Set<String> availableBlock  = new HashSet<>();
            for (Map.Entry<String,Boolean> map : block.entrySet()) {
                if(map.getValue()) {
                    availableBlock.add(map.getKey());
                }
            }
            blockSet.add(availableBlock);
        }

        Set<String> req = new HashSet<>();
        for(String s : reqs) {
            req.add(s);
        }


        int minDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i< blockSet.size(); i++) {
            Set<String> tempReq = new HashSet<>();
            tempReq.addAll(req);
            int dist = getDist(blockSet,i,tempReq);
            if (minDistance > dist) {
                minDistance  = dist;
                index = i;
            }

        }

        return index;
    }


    public static int getDist(List<Set<String>> blocks, int index, Set<String> reqs) {
        Set<String> availableBuildings = new HashSet<>();

        int leftIndex  = index;
        int rightIndex = index;

        int distWalk = 0;
        reqs.removeAll(blocks.get(index));
        if(reqs.size()==0) {
            return distWalk;
        }


        while(leftIndex >=0  || rightIndex<blocks.size()) {

            if (reqs.size() == 0) {
                return distWalk;
            }

            leftIndex--;
            rightIndex++;

            if (leftIndex>=0) {
                reqs.removeAll(blocks.get(leftIndex));
                if (reqs.size() == 0) {
                    return distWalk+1;
                }
            }

            if (rightIndex< blocks.size()) {
                reqs.removeAll(blocks.get(rightIndex));
                if (reqs.size() == 0) {
                    return distWalk+1;
                }



            }

            distWalk++;
        }

        return distWalk;
    }
}
