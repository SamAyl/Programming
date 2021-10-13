package DailyByte;

public class RemoveCharPalindrome {

    public static void main(String[] args) {
        String s = "addka";
        System.out.println(removeAndCheckPalindrome(s, 0,s.length()-1,false));
    }

    public static boolean removeAndCheckPalindrome(String s, int strIdx, int endIdx, boolean removeOnce) {
        if(strIdx>endIdx) {
            return true;
        }


        if (s.charAt(strIdx) == s.charAt(endIdx)){
            return true && removeAndCheckPalindrome(s,strIdx+1,endIdx-1,removeOnce);
        } else {
            if (!removeOnce) {
                return true && (removeAndCheckPalindrome(s,strIdx+1,endIdx , !removeOnce) ||
                        removeAndCheckPalindrome(s,strIdx,endIdx-1,!removeOnce));
            } else {
                return false;
            }
        }

    }
}
