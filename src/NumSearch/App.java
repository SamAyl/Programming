package NumSearch;

public class App {

    public static void main(String[] args) {
        int[][] a = {{1,3}};
        boolean r = searchMatrix(a,3);
        System.out.println(r);


    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }

        boolean check = check(matrix);
        if(!check){
            return check;
        }

        int[] a = new int[matrix.length];

        for(int i = 0;i<matrix.length;i++){
            a[i] = matrix[i][0];
        }

        int index1 = binarySearch(a,0,matrix.length-1,(matrix.length-1)/2,target);
        if(matrix[index1][0] == target){
            return true;
        }else{
            if(index1==0 && matrix[index1][0]>target){
                return false;
            }else if(matrix[index1][0]>target){
                index1--;
            }

            int[] b = new int[matrix[0].length];
            for(int i = 0;i<matrix[0].length;i++){
                b[i] = matrix[index1][i];
            }

            int index2 = binarySearch(b,0,b.length-1,(b.length-1)/2,target);
            if(matrix[index1][index2] == target){
                return true;
            }else{
                return false;
            }

        }

    }

    public static boolean check(int[][] matrix){
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i].length==0){
                return false;
            }
        }

        return true;
    }

    public  static int binarySearch(int[] a,int str,int end,int mid,int v){

        if(v == a[mid]){
            return mid;
        }else if(str == end){
            return mid;
        }else if(str>end){
            return mid;
        } else {

            if(v>a[mid]){
                int tempMid = mid + ((end-mid)/2);
                return binarySearch(a,mid+1,end,tempMid,v);
            }else {
                int tempMid = (str)+(mid-str)/2;
                return binarySearch(a,str,mid-1,tempMid,v);
            }
        }
    }
}
