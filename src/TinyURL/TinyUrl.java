package TinyURL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TinyUrl {


    private Map<String, String> map = new HashMap<>();
    private Set<Long> randNumbers  = new HashSet<>();
    private Map<Integer, Character> symbols = new HashMap<>();

    public TinyUrl() {
              char temp;
              int tempSum;
        for (Integer i = 0; i < 100; i++) {
            tempSum = i+33;
            if(tempSum!=94 && tempSum!=98 && tempSum!=34) {
                 temp = (char) (tempSum);
                Character ch = temp;
                symbols.put(i, ch);
            }else if(i==94){
                 temp = (char)(196);
                 Character ch = temp;
                symbols.put(i, ch);
            }else if(i==98){
                temp = (char)(250);
                Character ch = temp;
                symbols.put(i, ch);
            }else{
                temp = (char)(167);
                Character ch = temp;
                symbols.put(i, ch);
            }
        }


    }


    public String put(String url){
        if(map.containsKey(url)){
            return "www.ti.y.com/"+map.get(url);
        }else{
            String encodedURL  = getValue();
            map.put(url,encodedURL);
            return "www.ti.y.com/"+encodedURL;
        }
    }

    public String getValue() {

        Long number = generate();

        while (randNumbers.contains(number)){
            number = generate();
        }

        randNumbers.add(number);
        String val="";
        if(number > 1000000 && number<1000000000){
            long temp = number/1000000;
            number = number%1000000;
            val = val+getEncryptedValue(temp);

        }

        if(number>1000 && number <1000000){
            long temp = number/1000;
            val = val + getEncryptedValue(temp);
            number = number%1000;
        }

        if(number<1000){
            val = val + getEncryptedValue(number);
        }

        return val;

    }

    public String getEncryptedValue(long number){
        String val = "";

        int rem  = (int)(number/100);
        val = val +  symbols.get(rem);
        rem = (int)number%100;
        val = val +  symbols.get(rem);

        return val;
    }

    public Long generate(){
        return (long)(Math.random() * 1000000000)+1;
    }

}
