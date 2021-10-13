package DailyByte;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] s = {"spot", "spotty", "spotted"};
        System.out.println(lcp(s));
    }

    public static String lcp(String[] s) {

        String lcp = s[0];
        for (int count = 1; count < s.length ; count++) {
            lcp = getNewLcp(lcp, s[count]);
            if (lcp.isEmpty()) {
                return lcp;
            }
        }

        return lcp;
    }

    public static String getNewLcp(String ref, String match) {

        int idx1 = 0;
        int idx2 = 0;
        StringBuilder sb = new StringBuilder();
        while (idx1 < ref.length() && idx2<match.length()) {
            if (ref.charAt(idx1) == match.charAt(idx2)) {
                sb.append(ref.charAt(idx1));
                idx1++;
                idx2++;
            } else {
                return sb.toString();
            }
        }

        return sb.toString();
    }
}
