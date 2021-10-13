package AlgoExpert;

import java.util.*;

class Line1 {

    public static void main(String[] args) {
        int[][] points = {{-1,-1},{-3,-1},{-4,-1},{1,1},{4,1}};
        System.out.println(lineThroughPoints(points));
    }

    public static int lineThroughPoints(int[][] points) {

        Map<Double,Set<Point>> map = new HashMap<>();


        for(int i = 0; i<points.length;i++) {
            for(int j = i+1 ; j < points.length; j++) {

                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                double slope = (double)(y2-y1) / (x2-x1);

                if (map.containsKey(slope)) {
                    map.get(slope).add(new Point(x1,y1));
                    map.get(slope).add(new Point(x2,y2));
                } else {
                    Set<Point> pointsSet = new HashSet<>();
                    pointsSet.add(new Point(x1,y1));
                    pointsSet.add(new Point(x2,y2));

                    map.put(slope,pointsSet);
                }

            }
        }

        int maxPoints = Integer.MIN_VALUE;

        for(Map.Entry<Double,Set<Point>> entry : map.entrySet()) {
            if (entry.getValue().size() > maxPoints) {
                maxPoints = entry.getValue().size();
            }
        }

        return maxPoints;
        //  return -1;
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object o) {
        Point o1 = (Point)o;
        boolean x1 = (this.x == o1.x);
        boolean y1 = (this.y == o1.y);

        return x1 && y1;
    }
}
