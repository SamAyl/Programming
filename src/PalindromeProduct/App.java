package PalindromeProduct;

public class App {

    public static void main(String[] args){
        largestPalindrome(8);
    }


    public static int largestPalindrome(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append("9");
        }

        String s1 = sb.toString();
        String s2 = sb.toString();
        Long num1 = Long.parseLong(s1);
        Long num2 = Long.parseLong(s2);
        String s3 = Long.toString(num1*num2);






        return -1;
    }
}
