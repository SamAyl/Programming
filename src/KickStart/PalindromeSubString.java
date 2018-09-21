package KickStart;

public class PalindromeSubString {

    public static void main(String[] args) {
        String s = "abcbaabcaaaaaaa";
        String largestPalindrome = findLargestPalindrome(s);
        System.out.println(largestPalindrome);
    }

    public static String findLargestPalindrome(String s){



        int str = 0;
        int end = 0;
        for(int i = 0;i<s.length();i++){
          int[] indices = findPalindromeIndices(s.toCharArray(),i);
          if((indices[1] - indices[0])>(end - str)){
              str = indices[0];
              end = indices[1];
          }
        }


        return s.substring(str,end+1);
    }


    // a a b a
    public static int[] findPalindromeIndices(char[] ch,int pivot){

         int[] indices = new int[2];
         indices[0] = pivot;
         indices[1] = pivot;

         int i = pivot-1;
         int j = pivot+1;

         while (i>=0 && j<ch.length){
             if(ch[i]==ch[j]){
                 i--;
                 j++;
             }else if(ch[i]==ch[i+1]){
                 i--;
             }else if(ch[j]==ch[j-1]){
                 j++;
             }else {
                 break;
             }
         }


         indices[0] = i+1;
         indices[1] = j-1;


         return indices;


    }




}
