package AlgoExpert;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAABBCCCCDD";

        StringBuilder sb = new StringBuilder();
        int count = 1;
        int chatCount = 1;
        char prev = s.charAt(0);
        while (count<s.length()) {

            if(prev == s.charAt(count)) {
                if (chatCount + 1 <=9){
                    chatCount++;
                } else {
                    sb.append(chatCount);
                    sb.append(prev);
                    chatCount = 1;
                }
            } else {
                sb.append(chatCount);
                sb.append(prev);
                prev = s.charAt(count);
                chatCount = 1;
            }


            count++;
        }

        sb.append(chatCount);
        sb.append(prev);
        System.out.println(sb.toString());
    }
}
