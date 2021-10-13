package AlgoExpert;

import java.util.*;

public class RectangleMania {

    public static void main(String[] args) {
        Points[] p  = new Points[12];
        p[0] = new Points(0,0);
        p[1] = new Points(0,1);
        p[2] = new Points(1,1);
        p[3] = new Points(1,0);
        p[4]  = new Points(2,1);
        p[5] = new Points(2,0);
        p[6] = new Points(3,1);
        p[7] = new Points(3,0);
        p[8] = new Points(1,3);
        p[9] = new Points(3,3);
        p[10] = new Points(0,-4);
       // p[11] = new Points()



        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<p.length;i++) {
            if (map.containsKey(p[i].x)) {
                map.get(p[i].x).add(p[i].y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p[i].y);
                map.put(p[i].x,list);
            }
        }


        for(Integer s : map.keySet()) {
            Collections.sort(map.get(s));
        }

        int sum = 0;
        Set<Integer> visited = new HashSet<>();
        for(Integer x : map.keySet()) {
            visited.add(x);
            for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
                if (visited.contains(entry.getKey())) {
                    continue;
                } else {
                    sum+=getCombinations(map.get(x),entry.getValue());
                }
            }
        }

        System.out.println(sum);
    }

    public static int getCombinations(List<Integer> p1, List<Integer> p2) {
        int size1 = 0;
        int size2 = 0;
        int count = 0;
        while (size1<p1.size() && size2<p2.size()) {
            if (p1.get(size1) == p2.get(size2)) {
                count++;
            }

            size1++;
            size2++;
        }

        if (count>1) {
            return (count * count-1)/2;
        }

        return 0;
    }

}

class Points{
    int x;
    int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
