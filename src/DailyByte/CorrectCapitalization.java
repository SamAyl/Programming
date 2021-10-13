package DailyByte;

public class CorrectCapitalization {

    public static void main(String[] args) {

        String s = "codingK";
        System.out.println(checkCaps(s));
    }

    public static boolean checkCaps(String s) {
        if (s.length() == 1) {
            return true;
        }

        if (s.charAt(0)-'a' >=0 && s.charAt(0)-'a'<=25) {
            return checkSmall(s,1);
        } else {
            if (s.charAt(1) - 'a' >=0 && s.charAt(1)-'a' <= 25) {
                return checkSmall(s,1);
            } else {
                return checkBig(s,1);
            }
        }

    }

    public static boolean checkSmall(String s , int idx) {

        int len = s.length();

        while (idx < len) {
            if (s.charAt(idx)-'a' >= 0 && s.charAt(idx) - 'a' <= 25) {
                idx++;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean checkBig(String s, int idx) {
        int len = s.length();

        while (idx < len) {
            if (s.charAt(idx) - 'A' >= 0 && s.charAt(idx) - 'A' <= 25) {
                idx++;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
