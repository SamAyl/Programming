package geekForgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class ConsecutiveNum {

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(findLength(nums));
    }

    public static int findLength(int[] nums){

        nums = removeDuplicates(nums);
        int[] parent = new int[nums.length];


        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num-1) && ! map.containsKey(num+1)) {
                setParent(i,map.get(num-1),parent);
            } else if(map.containsKey(num+1) && !map.containsKey(num-1)) {
                setParent(i, map.get(num + 1), parent);
            } else if (map.containsKey(num+1) && map.containsKey(num-1)) {
                   setParent(i,map.get(num+1),parent);
                   setParent(parent[map.get(num-1)],parent[i],parent);
            }
            else if (map.containsKey(num)){
                setParent(i,map.get(num),parent);
            } else {
                parent[i] = i;
            }

            if(!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }
        }

     return getMax(parent);

    }


    public static void setParent(int x, int y,int[] parent){
        int root = findParent(y,parent);
        parent[x] = root;
    }


    public static int findParent(int y,int[] parent) {

        if(parent[y] == y) {
            return y;
        } else {
            int finalParent = findParent(parent[y],parent);
            parent[y] = finalParent;
            return finalParent;
        }
    }


    public static int getMax(int[] par) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i  =0;i<par.length;i++){
            int root = par[i];

            while (par[root]!=root){
                root = par[root];
            }


            if(map.containsKey(root)) {
                int count = map.get(root);
                map.put(root,count+1);
            } else {
                map.put(root,1);
            }
        }


        int max = Integer.MIN_VALUE;

        for(int key : map.keySet()) {
            if(map.get(key)>max) {
                max = map.get(key);
            }
        }

        return max;
    }

 public  static int[] removeDuplicates(int[] nums) {
        List<Integer> num = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i : nums){
            if(!visited.contains(i)) {
                num.add(i);
                visited.add(i);
            }
        }

        int[] ans = new int[num.size()];
        int count = 0;
        for(int i : num){
            ans[count] = i;
            count++;
        }

        return ans;
    }

}
