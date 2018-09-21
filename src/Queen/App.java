package Queen;

import java.util.*;

public class App {

    public static void main(String[] args) {
        int[][] chess = new int[3][3];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        map.put(0,new HashSet<>());
        map.put(1,new HashSet<>());
        map.put(2,new HashSet<>());

        getPath(0,0,map);
        System.out.println(map);

    }

    public static void getPath(int x,int y,Map<Integer,Set<Integer>> map){
        getVertical(x,y,map,2,2);
        getHorizontal(x,y,map,2,2);
        leftDiag(x,y,map,2,2);
        rightDiag(x,y,map,2,2);
    }

    public static void getVertical(int x,int y,Map<Integer,Set<Integer>> map,int maxX,int maxY){
        int tempX = x;
        int tempY = y;
        while (tempX>=0){
            map.get(tempX).add(tempY);
            tempX--;
        }
        tempX = (x+1);
        while (tempX<=maxX){
            map.get(tempX).add(tempY);
            tempX++;
        }
    }


    public static void getHorizontal(int x,int y,Map<Integer,Set<Integer>> map,int maxX,int maxY){
        int tempX = x;
        int tempY = y;
        while (tempY>=0){
            map.get(tempX).add(tempY);
            tempY--;
        }
        tempY = y+1;
        while (tempY<=maxY){
            map.get(tempX).add(tempY);
            tempY++;
        }
    }

    public static void leftDiag(int x,int y,Map<Integer,Set<Integer>> map,int maxX,int maxY){
        int tempX = x;
        int tempY = y;

        while (tempX>=0 && tempY>=0){
            map.get(tempX).add(tempY);
            tempX--;
            tempY--;
        }

        tempX = x+1;
        tempY = y+1;

        while (tempX<=maxX && tempY <=maxY){
            map.get(tempX).add(tempY);
            tempX++;
            tempY++;
        }
    }

    public static void rightDiag(int x,int y,Map<Integer,Set<Integer>> map,int maxX,int maxY){
        int tempX = x;
        int tempY = y;
        while (tempX>=0 && tempY<=maxY){
            map.get(tempX).add(tempY);
            tempX--;
            tempY++;
        }
        tempX = x+1;tempY = y+1;
        while (tempX<=maxX && tempY>=0){
            map.get(tempX).add(tempY);
            tempX++;
            tempY--;
        }
    }
}
