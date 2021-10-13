package CSES;

class App {

//    public static void main(String[] args) {
//        App app = new App();
//        int[] nums = {5,2,6,1};
//        app.countSmaller(nums);
//    }
//    public List<Integer> countSmaller(int[] nums) {
//
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//
//        if (nums.length ==1) {
//            List<Integer> list = new ArrayList<>();
//            list.add(0);
//            return list;
//        }
//
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        node root = new node(nums[nums.length-1]);
//
//        for (int i = nums.length -2 ; i >= 0; i--) {
//
//            node temp = new node(nums[i]);
//            addTree(root,temp);
//            System.out.println(temp.lessCount);
//            list.add(temp.lessCount);
//        }
//
//        Collections.reverse(list);
//        return list;
//
//    }
//
//
//    public void addTree(node root, node node) {
//
//        if (root.num < node.num) {
//            node.lessCount += 1;
//            node.lessCount += root.lessCount;
//
//            if (root.right != null) {
//                addTree(root.right,node);
//            } else {
//                root.right = node;
//            }
//        } else {
//            root.lessCount+=1;
//
//            if (root.left != null) {
//                addTree(root.left, node);
//            } else {
//                root.left = node;
//            }
//        }
//    }
//
//
//}
//
//class node {
//
//    int num;
//    int lessCount;
//    node left;
//    node right;
//
//    public node(int num) {
//        this.num = num;
//    }
}