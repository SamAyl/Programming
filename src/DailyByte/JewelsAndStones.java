package DailyByte;

import java.util.HashMap;

public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "AD";
        String stones = "adASADDD";

         int count = getJewelCountInStones(stones, jewels);
        System.out.println(count);
    }

    public static int getJewelCountInStones(String stones, String jewels) {

        HashMap<Character,Integer> jewelMap = new HashMap<>();

        for(Character c : jewels.toCharArray()) {
            jewelMap.put(c,0);
        }

        for(Character stnChar : stones.toCharArray()) {
            if (jewelMap.containsKey(stnChar)) {
                int count = jewelMap.get(stnChar);
                jewelMap.put(stnChar,count+1);
            }
        }

        int totCount = 0;
        for (Integer count : jewelMap.values()) {
            totCount+=count;
        }
        return totCount;
    }
}
