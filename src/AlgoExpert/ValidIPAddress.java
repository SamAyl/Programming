package AlgoExpert;

import java.util.*;

public class ValidIPAddress {

    public static void main(String[] args) {
        ValidIPAddress address = new ValidIPAddress();
        address.validIPAddresses("1921680");
    }

    public ArrayList<String> validIPAddresses(String string) {

        if (string == null || string.isEmpty() || string.charAt(0) == '0') {
            new ArrayList<String>();
        }

        ArrayList<String> ans = new ArrayList<String>();

        findAllIps(string,ans,0,new StringBuilder(),new int[1]);



        return ans;
    }

    public void findAllIps(String str, ArrayList<String> ans, int idx,StringBuilder sb,int[] dots) {

        if (dots[0] == 3) {
            if (idx < str.length()) {
                String validRangeSubString = str.substring(idx);
                boolean checkValidRange1 = false;
                if (validRangeSubString.length()>1) {
                    checkValidRange1 =  validRangeSubString.charAt(0) != '0' && Integer.parseInt(validRangeSubString) <= 255 ? true : false;
                } else if (validRangeSubString.length()==1) {
                    checkValidRange1 = true;
                }
                if (checkValidRange1){
                    String s  = sb.toString() + validRangeSubString;
                    ans.add(s);
                }
            }

            return;
        }


        int count = 1;

        while (count < 4 && idx+count <= str.length()) {
            String validRange = str.substring(idx,idx+count);
            System.out.println(validRange);
            boolean checkValidRange = false;
            if (validRange.length() > 1) {
                checkValidRange = validRange.charAt(0) != '0' && Integer.parseInt(validRange) <= 255 ? true : false;
            } else if (validRange.length() == 1) {
                checkValidRange = true;
            }
            if (checkValidRange) {

                int lengthBeforeDeletion = 0;
                lengthBeforeDeletion = sb.length();
                sb.append(validRange.toString() + ".");
                dots[0]+=1;
                findAllIps(str,ans,idx+count,sb,dots);
                sb.delete(lengthBeforeDeletion,sb.length());
                dots[0]-=1;
                count++;
            } else {
                return;
            }
        }




    }
}
