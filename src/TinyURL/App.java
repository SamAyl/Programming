package TinyURL;

public class App {

    public static void main(String[] args){
        TinyUrl tinyUrl = new TinyUrl();
        System.out.println(tinyUrl.put("www.google.com/`1234567890-1234567890-"));
        System.out.println(tinyUrl.put("www.gontu.com/dbvpehgpdghqegblqegladbgoqeghapuEHPQEGHPWHGPw'ytgpihgpHGApiw'gpiahwr" +
                        "ph'yqprgpwj'pgpirwgp"));
        System.out.println(tinyUrl.put("www.hotmail.com"));
        System.out.println(tinyUrl.put("www.isa.com"));
        System.out.println(tinyUrl.put("www.google.com/`1234567890-1234567890-"));

    }
}
