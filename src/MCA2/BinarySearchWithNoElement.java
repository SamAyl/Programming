package MCA2;

import java.util.List;

public class BinarySearchWithNoElement {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,6,7};
        System.out.println(findNearest(a,5));
    }

    public static int findNearest(int[] a, int v){
        int start = 0;
        int end = a.length-1;
        int mid = (start+end)/2;

        while (start<a.length && end>0 && start!=end){
            if(a[mid]== v){
                return mid;
            } else if( a[mid] < v){
                start = mid+1;
                mid = (start+end)/2;
            } else {
                end = mid-1;
                mid = (start+end)/2;
            }
        }


        return start;
    }

    public static void bfs(List<List<Integer>> nodes) {

     //   Queue<Integer> queue = new
    }

}
