package Java;


import java.util.Base64;

public class App9 {

    public static void main(String[] args) {
        String s = "Hello";
        String s2 = "World";

        System.out.println(getString(s,s2));
        System.out.println();

    }


    private static String getStringWithAddition(String s1, String s2){
        String s11 = Base64.getEncoder().encodeToString(s1.getBytes());
        String s22 = Base64.getEncoder().encodeToString(s2.getBytes());

        String s3 = s11 + s22;
        System.out.println(s3);
        return new String(Base64.getDecoder().decode(s3));

    }

    private static String getString(String s1, String s2){
        String encodedS = Base64.getEncoder().encodeToString(s1.getBytes());
        String encodeds2 = Base64.getEncoder().encodeToString(s2.getBytes());

        byte[] encodedSbyteArr = Base64.getDecoder().decode(encodedS);
        byte[] encodeds2byteArr = Base64.getDecoder().decode(encodeds2);

        byte[] ans = new byte[encodedSbyteArr.length + encodeds2byteArr.length];

        for(int i = 0;i<encodedSbyteArr.length;i++){
            ans[i] = encodedSbyteArr[i];
        }

        int count = 0;
        for(int j = encodedSbyteArr.length; j<ans.length; j++){
            ans[j] = encodeds2byteArr[count];
            count++;
        }

        String ansWithString = new String(ans);
        return ansWithString;
    }
}
