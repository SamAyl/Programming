package CubeDP;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static Map<XY,Integer> map = new HashMap<>();

    public static void main(String[] args){
        map.put(new XY(1,1),2);
        map.put(new XY(0,0),0);
        map.put(new XY(0,1),1);
        map.put(new XY(1,0),1);

        System.out.println(getPath(0,2));
    }

    public static int getPath(int x,int y){
        XY xy = new XY(x,y);

        if(map.containsKey(xy)){
            return map.get(xy);
        }

        int path1 = 0;
        int path2 = 0;

        if(x-1>=0){
            path1 =  getPath(x-1,y);
        }

        if(y-1>=0){
            path2 = getPath(x,y-1);
        }
        map.put(xy,path1 + path2);

        return path1 + path2;

    }

}

class XY{
    int x;
    int y;

    public XY(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XY xy = (XY) o;

        if (x != xy.x) return false;
        return y == xy.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
