package MCA2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKnapSack {

    public static void main(String[] args) {

        Obj o1 = new Obj(2,10);
        Obj o2 = new Obj(3,5);
        Obj o3 = new Obj(5,15);
        Obj o4 = new Obj(7,7);
        Obj o5 = new Obj(1,6);
        Obj o6 = new Obj(4,18);
        Obj o7 = new Obj(1,3);

        List<Obj> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);
        list.add(o6);
        list.add(o7);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);


        int totWeight = 15;
        int count = 0;
        int profit = 0;
        while (totWeight>0 && count<list.size()) {
            int weightToAdd = list.get(count).w;
            if(totWeight-weightToAdd>=0){
                totWeight = totWeight - weightToAdd;
                profit+= (list.get(count).p * weightToAdd);
            } else {
                profit+= (list.get(count).p * totWeight);
                totWeight = 0;
            }
        }

        System.out.println(profit);
    }
}

class Obj implements Comparable<Obj>{
    int w;
    float p;

    float unitP;

   public Obj(int w,float p){
       this.w = w;
       this.p = p;

       unitP = p/w;
   }

    @Override
    public int compareTo(Obj o) {
        if(this.unitP >=o.unitP){
            return 1;
        } else {
            return -1;
        }
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public float getP() {
        return p;
    }

    public void setP(float p) {
        this.p = p;
    }
}
