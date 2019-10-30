package cryptography;

import java.util.HashMap;
import java.util.Map;

public class ShiftCipher {

    static Map<Character,Integer> characterIntegerMap = new HashMap<>();
    static Map<Integer,Character> integerCharacterMap = new HashMap<>();

    public static void main(String[] args) {
      setCharacterIntegerMap();
      String plainText = "ISAISGREAT";
      String cipherText = encrypt(plainText,100);
      String result = "";
      result= plainText.equalsIgnoreCase(decrypt(cipherText,100)) ? "Shift Cipher works as expected" : "Shift cipher doesn't work as expected";
      System.out.println(result);
    }

    public static String encrypt(String p,int k){
        char[] ch = p.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(Character c : ch){
            int position = characterIntegerMap.get(c);
            int shiftPosition = position + k;
            if(shiftPosition>=26){
                shiftPosition = shiftPosition%26;
            }
            sb.append(integerCharacterMap.get(shiftPosition));
        }

        return sb.toString();
    }

    public static String decrypt(String c, int k){
        char[] ch = c.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(Character e : ch){
            int shiftPosition = characterIntegerMap.get(e);
            int realPosition = shiftPosition - k;
            if(realPosition<0){
                if(realPosition<-26){
                    realPosition = (Math.abs(realPosition)%26) * -1;
                }

                realPosition = realPosition<0 ? 26+realPosition : realPosition;

            }

            sb.append(integerCharacterMap.get(realPosition));
        }

        return sb.toString();
    }

    private static void setCharacterIntegerMap(){
        int str  = 65;

        for(int i =0;i<26;i++){
            Character c = (char)str;
            characterIntegerMap.put(c,i);
            integerCharacterMap.put(i,c);
            str++;
        }
    }
}
