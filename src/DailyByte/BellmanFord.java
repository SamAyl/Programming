package DailyByte;



import java.util.*;

public class BellmanFord {

    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] grp = {{0,4,5,INF},{INF,0,INF,1},{INF,-4,0,INF},{INF,INF,INF,0}};
        long[] shortestPath = {0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};

        shortestPath(0,grp,shortestPath);

        int count = 0;
        for (long i : shortestPath) {
            System.out.println(count +" =====> " + i);
            count++;
        }
    }


    public static void shortestPath(int src, int[][] grp, long[] shortestPath) {


        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);


        while (!queue.isEmpty()) {

            int parent = queue.remove();
            for(int child = 0; child< grp[0].length; child++) {
                int dist = grp[parent][child];
                long totDist = shortestPath[parent]+dist;

                if (shortestPath[child] > totDist) {
                    shortestPath[child] = totDist;
                    queue.add(child);
                }
            }

        }
    }
}
