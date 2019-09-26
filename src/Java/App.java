package Java;

import java.util.HashMap;
import java.util.Map;

public class App {




    public static void main(String[] args){
        Test t = new Test(1);
        Test t1 = new Test(1);

       t.equals(t1);

       Map<Integer,Integer> map = new HashMap<Integer,Integer>();


    }


}


class Test{
    int key;

    public Test(int key){
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        return key == test.key;
    }

    @Override
    public int hashCode() {
        return key;
    }
}