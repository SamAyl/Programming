package Uber_1;

import java.util.*;

public class StupidItinerary {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();

        List<String> list1 = Arrays.asList("JFK","SFO");
        List<String> list2 = Arrays.asList("JFK","ATL");
        List<String> list3 = Arrays.asList("SFO","ATL");
        List<String> list4 = Arrays.asList("ATL","JFK");
        List<String> list5 = Arrays.asList("ATL","SFO");


        PriorityQueue<List<String>> pq = new PriorityQueue<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (o1.get(0).compareTo(o2.get(0)) != 0) {
                    return o1.get(0).compareTo(o2.get(0));
                } else {
                    return o1.get(1).compareTo(o2.get(1));
                }
            }
        });


        pq.add(list2);
        pq.add(list3);
        pq.add(list4);
        pq.add(list5);

        List<String> ans = new ArrayList<>();
        ans.addAll(list1);


        Set<String> visited = new HashSet<>();
        visited.add(list1.get(0)+"="+list1.get(1));

        while (!pq.isEmpty()) {
            List<String> temp = pq.remove();
            //checking if visited
            StringBuilder sb = new StringBuilder();
            sb.append(temp.get(0));
            sb.append("=");
            sb.append(temp.get(1));

            if (visited.contains(sb.toString())) {
                continue;
            }


            if (ans.get(ans.size()-1).equalsIgnoreCase(temp.get(0))) {
                ans.add(temp.get(1));
            } else {
                ans.addAll(temp);
                sb.delete(0,sb.length());
                sb.append(ans.get(ans.size()-1));
                sb.append("=");
                sb.append(temp.get(0));
                visited.add(sb.toString());
            }

            sb.delete(0,sb.length());
            sb.append(temp.get(0));
            sb.append("=");
            sb.append(temp.get(1));
            visited.add(sb.toString());
        }


        for(String s : ans) {
            System.out.print(s + "\t");
        }
    }
}
