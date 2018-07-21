package sg_group5.CountVowels.IsPalindrome;

public class App {

    public static void main(String[] args) {

        //'n' char -> n/2
        // original str, reverse str
        //n + n/2
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s){
        if(s==null || s.isEmpty()){
            return false;
        }

        return check(s);
    }

    public static boolean check(String s){
        char[] ch = s.toCharArray();

        int mid = ch.length/2 -1;

        //n/2
        for(int i = 0;i<=mid;i++){
            if(ch[i]!=ch[ch.length-1-i]){
                return false;
            }
        }

        return true;
    }
}


