package CSES;

public class KMP {

    public static void main(String[] args) {
        String pattern = "abcdabc";
        String text = "abcdabdabcdabcdabc";

        int[] idxJump = new int[pattern.length()];

        fill(idxJump,pattern);
        printInt(idxJump);

    }

    public static void fill(int[] idx, String pattern){
        int str = 0;
        int temp = 1;

        while(temp<pattern.length()){
            if (pattern.charAt(temp)==pattern.charAt(str)){
                idx[temp] = str;
                str++;
                temp++;
            }else {
                temp++;
                str = 0;
            }
        }
    }

    public static void printInt(int[] jump) {
        for (int i : jump) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
