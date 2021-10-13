package AlgoExpert;

public class RegularExpression {


    public static void main(String[] args) {
        System.out.println(isMatch("aa","a*",0));
        System.out.println("a".substring(1));
    }

    public static boolean isMatch(String text, String pattern,int idx) {

        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return
                    ( (isMatch(text.substring(1), pattern, idx)) && first_match) || isMatch(text, pattern.substring(2), idx);
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1),idx);
        }

    }


    public static boolean isMatch(String text, String pattern,int idx1, int idx2) {

        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        } else if (pattern.isEmpty() && ! text.isEmpty()) {
            return false;
        }


        boolean match = false;
        if (!text.isEmpty()  && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.')) {
            match = true;
        }

        if (pattern.length()>=2 && pattern.charAt(1) == '*') {
            boolean m1 = isMatch(text,pattern.substring(2), idx1,idx2+2);
            boolean m2 = match && isMatch(text.substring(1),pattern,idx1+1,idx2);

            return m1 || m2;
        } else {
            if (!match) {
                return match;
            } else {
                return isMatch(text.substring(1),pattern.substring(1),idx1+1,idx2+1);
            }
        }


    }
}
