package ByteByByte;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<Integer,Object[]> map = new HashMap<>();
        map.put(1,null);
        map.remove(1);
        map.put(2,null);
        System.out.println(map.size());
    }
}
