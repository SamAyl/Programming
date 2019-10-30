package InterviewKickstart;

/*
 * Complete the 'nearest_neighbours' function below.
 *
 * The function accepts integer p_x, p_y, k and a 2D integer array n_points as parameter.
 */

import java.util.*;
import java.lang.*;

class Result {

    public static List<List<Integer>> nearest_neighbours(int p_x, int p_y, int k, List<List<Integer>> n_points) {
        List<List<Integer>> k_points = new ArrayList<>();

        Map<Long,List<List<Integer>>> map = new HashMap<>();


        for(List<Integer> point : n_points){
            Integer x = point.get(0);
            Integer y = point.get(1);



            Long dist_x = new Long(x)- new Long(p_x);
            Long dist_y = new Long(y)- new Long(p_y);

            dist_x = dist_x>=0?dist_x:dist_x * -1;
            dist_y = dist_y>=0?dist_y:dist_y * -1;

            if(map.containsKey(dist_x + dist_y)){
                map.get(dist_x+dist_y).add(point);
            }else{
                List<List<Integer>> points = new ArrayList<>();
                points.add(point);
                map.put(dist_x+dist_y,points);
            }

        }


        List<Long> dist = new ArrayList<>();
        dist.addAll(map.keySet());
        Collections.sort(dist);

        for(int i = 0;i<dist.size();i++){
            List<List<Integer>> points = map.get(dist.get(i));
            for(List<Integer> pts : points){
                k_points.add(pts);
                k--;
                if(k==0){
                    break;
                }
            }

            if(k==0){
                break;
            }


        }


        return k_points;
    }


    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        list.add(getList(-3,-7));

        list.add(getList(-1,-7));
        list.add(getList(-4,0));
        list.add(getList(-1,-8));

        System.out.println(nearest_neighbours(-1,-2,3,list));
    }

    private static List<Integer> getList(int x,int y){
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);

        return list;
    }

}

