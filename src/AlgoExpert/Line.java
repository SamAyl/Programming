package AlgoExpert;

import java.util.*;

class Lines {

    public int lineThroughPoints(int[][] points) {
        Map<Integer,List<Line>> map = new HashMap<>();

        int[] maxPoints = new int[1];

        for (int i = 1; i<points.length; i++ ) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int prevPoints = i-1; prevPoints >= 0; prevPoints--) {
                if (map.containsKey(prevPoints)) {
                    boolean found = false;
                    for (Line singleLine : map.get(prevPoints)) {
                        found = singleLine.ifPresent(x1,y1);
                        if (found) {
                            if (singleLine.maxPoints > maxPoints[0]) {
                                maxPoints[0] = singleLine.maxPoints;
                            }
                            break;
                        }
                    }

                    if(!found) {
                        addLine(i,x1,y1,points[prevPoints][0], points[prevPoints][1],map, maxPoints);
                    }
                } else {
                    addLine(i, x1, y1, points[prevPoints][0], points[prevPoints][1],map, maxPoints);
                }
            }
        }

        return maxPoints[0];


    }

    public void addLine (int pointIdx, int x1, int x2, int y1, int y2, Map<Integer,List<Line>> map, int[] maxPoints) {
        Line newLine = new Line(x1,x2,y1,y2);
        if (maxPoints[0] < newLine.maxPoints) {
            maxPoints[0] = newLine.maxPoints;
        }
        if (map.containsKey(pointIdx)) {
            map.get(pointIdx).add(newLine);
        } else {
            List<Line> linesOnPoint = new ArrayList<>();
            linesOnPoint.add(newLine);
            map.put(pointIdx,linesOnPoint);
        }


    }

}

class Line {

    int x;
    int y;
    int deltaY;
    int deltaX;
  public  int maxPoints;

    public Line(int x, int y, int x1, int y1) {
        this.x = x;
        this.y = y;

        deltaY = y1 - y;
        deltaX = x1 - x;
        maxPoints = 2;
    }

    public boolean ifPresent(int x2, int y2) {
        if (((y2 - y) * deltaX) == ((x2 - x) * deltaY)) {
            maxPoints++;
            return true;
        } else {
            return false;
        }
    }


}

