package Google;

import java.util.*;

public class InfiniteSumProb {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(2, 2, 2,10,10,8, 1, 11));

        System.out.println(getIndex(list,5,0,new ArrayList<>()));
     //  PriorityQueue<Integer> pq = new PriorityQueue<>()

    }



    public static int getIndex(List<Integer> list,int sum,int index, List<Integer> mem) {

        if(list.get(index) == sum){
            return index;
        }

        if(list.get(index) > sum){
            return getIndex(list,sum,index+1,mem);
        } else {
            int currNum = list.get(index);
            int memSize = mem.size();
            for(int i =0;i<memSize;i++){
                if(mem.get(i) + currNum == sum){
                    return index;
                } else if(mem.get(i) + currNum < sum){
                    mem.add(mem.get(i)+currNum);
                }
            }

            mem.add(currNum);

            return getIndex(list,sum,index+1,mem);
        }


        }



    }

