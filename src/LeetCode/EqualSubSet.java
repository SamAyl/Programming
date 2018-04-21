package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualSubSet {

    public static void main(String[] args){

        int[] num = {1,5,5,9};
        EqualSubSet equalSubSet = new EqualSubSet();
        System.out.println(equalSubSet.canPartition(num));
    }


    public Map<Node1,Integer> map =  new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public boolean canPartition(int[] nums) {

        for(int i = 0;i< nums.length;i++){

            for(int j = i;j<nums.length;j++){
                if(checkSum(nums,i,j)){
                    return true;
                }
            }

        }

        return false;
    }


    public boolean checkSum(int[] nums,int i,int j){
        Node1 temp = new Node1(i,(j-i+1));
        Node1 temp1 = new Node1(i-1,j-i+1+1);
        int sum =0;
        if(map.containsKey(temp1)){
            sum = (map.get(temp1))-nums[i-1];

        }else {
            for(int str = i;str<=j;str++){
                sum+=nums[str];
            }
        }

        map.put(temp,sum);

        if(set.contains(sum)){
            return true;
        }else {
            set.add(sum);
            return false;
        }
    }




}

class Node1{
    int start;
    int size;


    public Node1(int start,int size){
        this.size = size;
        this.start = start;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node1 node1 = (Node1) o;

        if (start != node1.start) return false;
        return size == node1.size;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + size;
        return result;
    }
}
