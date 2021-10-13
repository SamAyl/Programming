package AlgoExpert;

import java.util.*;

public class DiskStack {


    public static void main(String[] args) {
        Integer[] d1 = {2, 1, 2};
        Integer[] d2 = {3, 2, 3};
        Integer[] d3 = {4, 4, 5};


        List<Integer[]> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        list.add(d3);

        List<Integer[]> res = diskStacking(list);
        System.out.println(res);
    }

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {

        Collections.sort(disks, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[2] < o2[2]) {
                    return -1;
                } else if (o1[2] == o2[2]) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        int height = 0;
        List<Integer[]> tallestStack = new ArrayList<>();
        for (int i = 0; i<disks.size();i++) {
            List<Integer[]> diskStacking = diskStacking(disks,i);
            if (height < getHeight(diskStacking)) {
                tallestStack = diskStacking;
            }
        }

        return tallestStack;
    }




    public static List<Integer[]> diskStacking(List<Integer[]> disks, int index) {


        Integer[] currentDisk = disks.get(index);

        if (index == disks.size()-1) {
            List<Integer[]> ans = new ArrayList<>();
            ans.add(currentDisk);
            return ans;
        }

        List<Integer[]> stackedDisks = new ArrayList<>();
        stackedDisks.add(currentDisk);

        int height = 0;
        List<Integer[]> nexStackDisks = new ArrayList<>();

        for (int nextDisk = index+1; nextDisk<disks.size() ; nextDisk++) {
            if (compare(currentDisk,disks.get(nextDisk))) {
                List<Integer[]> newStackDisks = diskStacking(disks,nextDisk);
                int tempHeight = getHeight(newStackDisks);
                if (tempHeight > height) {
                    height = tempHeight;
                    nexStackDisks = newStackDisks;
                }
            }
        }

        stackedDisks.addAll(nexStackDisks);
        return stackedDisks;
    }


    public static boolean compare(Integer[] disk1, Integer[] disk2) {
        boolean ans = false;
        if (disk1[0] < disk2[0]  && disk1[1] < disk2[1] && disk1[2] < disk2[2]) {
            return true;
        } else {
            return false;
        }
    }


    public static int getHeight(List<Integer[]> disks) {
        int sum = 0;
        for (Integer[] singleDisk : disks) {
            sum+=singleDisk[2];
        }

        return sum;
    }
}
