package Java;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class App5 {

    public static void main(String[] args) throws Exception {
        String ch = "!@#$";
        System.out.println(URLEncoder.encode(ch, StandardCharsets.US_ASCII.toString()));
        System.out.println(URLEncoder.encode(ch, StandardCharsets.UTF_8.toString()));

    }
}
