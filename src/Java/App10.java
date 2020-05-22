package Java;

import java.util.HashMap;
import java.util.Map;

public class App10 {

  public static void main(String[] args) {
    Map<Integer,Integer> map = new HashMap<>();
    map.put(1,1);
    map.put(2,2);
    map.put(3,3);
    map.put(4,4);
    map.put(5,5);

    for(int i =1;i<=5;i++){
      System.out.println(map.get(i));
        if(i == 3){
            map.remove(3);
        }
    }
  }
}
