package AlgoExpert;

class Program {
//
//    public static void main(String[] args) {
//        List<Integer> arr = new ArrayList<>();
//        arr.add(8);
//        arr.add(5);
//        arr.add(11);
//        arr.add(-1);
//        arr.add(3);
//        arr.add(4);
//        arr.add(2);
//
//        List<Integer> ans = rightSmallerThan(arr);
//
//        for(int i : ans) {
//            System.out.println(i);
//        }
//    }
//    public static List<Integer> rightSmallerThan(List<Integer> array) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0);
//         int[] arr = new int[array.size()];
//
//         for (int k = 0; k < arr.length; k++) {
//             arr[k]  = array.get(k);
//         }
////        for(int i = arr.length-1; i>=0; i--) {
////            list.add(putInCorrectPosition(arr,i));
////        }
//
//        node root = new node(arr[arr.length-1]);
//        for(int i = arr.length-2;i>=0;i--) {
//            list.add(putInCorrectPosition(arr[i],root,0));
//        }
//         Collections.reverse(list);
//        return list;
//    }
//
//
//    public static int putInCorrectPosition(int[] arr, int index) {
//
//        int windowSize = index;
//
//        for(int i = index+1; i<arr.length;i++) {
//            if (arr[i]< arr[index]) {
//                windowSize++;
//                swap(arr,windowSize,i);
//            }
//        }
//
//        swap(arr,windowSize, index);
//
//        return index - windowSize;
//
//    }
//
//
//    public static int putInCorrectPosition(int num, node root,int count){
//
//        if(root.v > num){
//            if(root.left!=null) {
//                root.lessCount++;
//              return   putInCorrectPosition(num,root.left,count);
//            } else {
//                root.lessCount++;
//                root.left = new node(num);
//                return count;
//            }
//        } else {
//             if(root.right!=null) {
//                 count +=root.lessCount;
//              return    putInCorrectPosition(num,root.right,count+1);
//             } else {
//                 root.right = new node(num);
//                 return count+root.lessCount+1;
//             }
//        }
//
//    }
//
//
//    public static void swap(int[] a,int i, int j) {
//        int e = a[i];
//        a[i] = a[j];
//        a[j] = e;
//    }
//}
//
//class node {
//    int v;
//    node left;
//    node right;
//
//    int lessCount;
//
//    public node(int v){
//        this.v = v;
//    }
}
