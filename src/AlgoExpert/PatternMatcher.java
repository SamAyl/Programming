package AlgoExpert;

public class PatternMatcher {

    public static void main(String[] args) {

        String pattern = "xxxx";
        String str = "testtesttesttest";

        int[][] metaData = getPatternMetadata(pattern);

        String[]  ans  = getPattern(pattern,str,metaData);

        for(String s : ans) {
            System.out.println(s);
        }

    }


    static int[][] getPatternMetadata(String pattern) {
        int[][] metaData = new int[2][2];
        metaData[0][0] = 0;


        char ch1 = pattern.charAt(0);
        for (int i = 0; i< pattern.length();i++) {
            if (pattern.charAt(i) == ch1) {
                metaData[0][1] += 1;
            } else {
                if (metaData[1][0] == 0) {
                    metaData[1][0] = i;
                }

                metaData[1][1] +=1;
            }
        }

        return metaData;
    }


    public static String[] getPattern(String pattern, String str, int[][] metaData) {


        String firstOne;
        String secOne=null;

        for (int i = 0; i< str.length();i++) {
            firstOne = str.substring(0,i+1);

            if (metaData[1][1] != 0) {
                int secLength = (str.length() - (firstOne.length()) * metaData[0][1]) / metaData[1][1];
                int secIndex =  (firstOne.length() * metaData[1][0]) ;

                if (secIndex >= str.length() || (secIndex+secLength) >=str.length() || secLength <= 0) {
                    break;
                }

                try {
                    secOne = str.substring(secIndex, secIndex + secLength);
                } catch (Exception e){
                    System.out.println(e);
                }
            }

            if (formStringAndCompare(firstOne,secOne,pattern,str)) {
                if (secOne == null) {
                    String[] ans = new String[1];
                    ans[0] = firstOne;
                    return ans;
                } else {
                    String[] ans = new String[2];
                    ans[0] = firstOne;
                    ans[1] = secOne;
                    return ans;
                }
            }


        }


     return new String[0];

    }


    public static boolean formStringAndCompare(String first,String second, String pattern, String str) {

        char ch = pattern.charAt(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< pattern.length();i++) {
            if (pattern.charAt(i) == ch){
                sb.append(first);
            } else {
                sb.append(second);
            }
        }

        return str.equalsIgnoreCase(sb.toString());
    }
}
